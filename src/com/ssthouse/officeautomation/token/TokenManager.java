package com.ssthouse.officeautomation.token;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.jdbc.authentication.Sha256PasswordPlugin;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.token.cons.TokenCons;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import sun.launcher.resources.launcher;
import sun.tools.jar.resources.jar_es;

public class TokenManager {

	private static final String KEY_HEADER_TYP = "typ";
	private static final String KEY_HEADER_ALG = "alg";

	private static final String KEY_CLAIM_IAT = "iat";
	private static final String KEY_CLAIM_EXP = "exp";

	// 自己定义的 claim, 暂时用不到, 用于后面扩展
	private static final String KEY_CLAIM_USERNAME = "username";

	/**
	 * depresed, use JJWT library
	 * 
	 * @param username
	 * @return
	 */
	@Deprecated
	public static String creatToken(String username, String password) {
		// 获取 header token
		JsonObject headerJsonObj = new JsonObject();
		headerJsonObj.addProperty(KEY_HEADER_TYP, "JWT");
		headerJsonObj.addProperty(KEY_HEADER_ALG, "HS256");
		String headerStr = headerJsonObj.toString();
		String headerToken = Base64.encode(headerStr.getBytes());
		Log.error(headerToken);
		// 获取payload token
		long currentTimeInMillis = System.currentTimeMillis();
		JsonObject payLoadJsonObj = new JsonObject();
		payLoadJsonObj.addProperty(KEY_CLAIM_USERNAME, username);
		payLoadJsonObj.addProperty(KEY_CLAIM_IAT, currentTimeInMillis);
		payLoadJsonObj.addProperty(KEY_CLAIM_EXP, currentTimeInMillis + 24 * 60 * 60 * 1000);
		String payLoadStr = payLoadJsonObj.toString();
		String payLoadToken = Base64.encode(payLoadStr.getBytes());
		Log.error(payLoadToken + "  is the payLoad token");
		// 获取 signature token
		return "";
	}

	/**
	 * 获取 token
	 * 
	 * @param username
	 *            将 username 添加到 claim 中
	 * @return
	 */
	public static String getToken(String username) {
		long curTimeInMillis = System.currentTimeMillis();
		String token = Jwts.builder().claim(KEY_CLAIM_IAT, curTimeInMillis)
				.claim(KEY_CLAIM_EXP, curTimeInMillis + 24 * 60 * 60 * 1000).claim(KEY_CLAIM_USERNAME, username)
				.signWith(SignatureAlgorithm.HS256, TokenCons.TOKEN_SECRET).compact();
		return token;
	}

	/**
	 * 验证
	 * 
	 * @param request
	 * @return
	 */
	public static boolean verifyToken(HttpServletRequest request) {
		if (request == null || StringUtil.isEmpty(request.getHeader("token"))) {
			return false;
		}
		try {
			// 1.判断时候符合 secret 签名
			Jws<Claims> jws = Jwts.parser().setSigningKey(TokenCons.TOKEN_SECRET)
					.parseClaimsJws(request.getHeader("token"));
			// body 中
			if (!jws.getBody().containsKey(KEY_CLAIM_EXP)) {
				return false;
			}
			long curTimeInMillis = System.currentTimeMillis();
			long tokenExpTime = (long) jws.getBody().get(KEY_CLAIM_EXP);
			if (tokenExpTime < curTimeInMillis) {
				return false;
			}
			return true;
		} catch (SignatureException e) {
			return false;
		}
	}

	/**
	 * 从token中解析出 username 信息
	 * 
	 * @param token
	 * @return
	 */
	public static String getTokenUsername(String token) {
		try {
			// 1.判断是否符合 secret 签名
			Jws<Claims> jws = Jwts.parser().setSigningKey(TokenCons.TOKEN_SECRET).parseClaimsJws(token);
			// body 中
			if (!jws.getBody().containsKey(KEY_CLAIM_USERNAME)) {
				return "";
			}
			return (String) jws.getBody().get(KEY_CLAIM_USERNAME);
		} catch (SignatureException e) {
			return "";
		}
	}

}
