package com.ssthouse.officeautomation.token;

import com.google.gson.JsonObject;
import com.mysql.jdbc.authentication.Sha256PasswordPlugin;
import com.ssthouse.officeautomation.util.Log;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import sun.launcher.resources.launcher;

public class TokenManager {

	/**
	 * 
	 * 
	 * payload的标准格式 { "iss": "John Wu JWT", "iat": 1441593502, "exp":
	 * 1441594722, "aud": "www.example.com", "sub": "jrocket@example.com",
	 * "from_user": "B", "target_user": "A" }
	 * 
	 * @param username
	 * @return
	 */
	public static String creatToken(String username) {
		// 获取 header token
		JsonObject headerJsonObj = new JsonObject();
		headerJsonObj.addProperty("typ", "JWT");
		headerJsonObj.addProperty("alg", "HS256");
		String headerStr = headerJsonObj.toString();
		String headerToken = Base64.encode(headerStr.getBytes());
		Log.error(headerToken);
		// 获取payload token
		long currentTimeInMillis = System.currentTimeMillis();
		JsonObject payLoadJsonObj = new JsonObject();
		payLoadJsonObj.addProperty("username", username);
		payLoadJsonObj.addProperty("exp", currentTimeInMillis);
		payLoadJsonObj.addProperty("exp", currentTimeInMillis + 1 * 60 * 60 * 1000);
		String payLoadStr = payLoadJsonObj.toString();
		String payLoadToken = Base64.encode(payLoadStr.getBytes());
		Log.error(payLoadToken+"  is the payLoad token");
		// 获取 signature token
		return "";
	}
}
