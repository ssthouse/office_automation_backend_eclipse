package com.ssthouse.officeautomation.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.constant.SessionCons;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.bean.TokenResultBean;
import com.ssthouse.officeautomation.controller.bean.UserBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.token.cons.TokenCons;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/")
public class LoginController {

	// @CrossOrigin
	// @RequestMapping("/addCookie")
	// public void addCookie(HttpServletRequest request, HttpServletResponse
	// response){
	//// for(Cookie cookie : request.getCookies()){
	//// Log.error(cookie.getName()+"****************************"+cookie.getValue());
	//// }
	// Cookie cookie = new Cookie(TokenCons.COOKIE_KEY_TOKEN, "I_am_the_token");
	// // 设置Maximum Age
	// cookie.setMaxAge(36000000);
	// // 设置cookie路径为当前项目路径
	// cookie.setPath("/");
	// cookie.setDomain("www.ssthouse.com");
	// // 添加cookie
	// response.addCookie(cookie);
	// Log.error("I have add the cookie");
	// }

	@CrossOrigin
	@RequestMapping("/token")
	public void getToken(HttpServletRequest request, HttpServletResponse response,
			@RequestBody UserBean requestUserBean,
			@CookieValue(value = "token", defaultValue = "null token") String tokenFrom) {
		if (requestUserBean == null || StringUtil.isEmpty(requestUserBean.getUsername())
				|| StringUtil.isEmpty(requestUserBean.getPassword())) {
			sendTokenResultBean(response, false, "");
			return;
		}
		Log.error("the token from javascript is *******************************: " + tokenFrom);
		// 尝试获取用户 Entity
		UserDaoImpl userDaoImple = new ClassPathXmlApplicationContext("spring.xml").getBean(UserDaoImpl.class);
		UserEntity userEntity = userDaoImple.getUserEntity(requestUserBean.getUsername(), requestUserBean.getPassword(),
				requestUserBean.getIsAdmin());
		boolean loginReault = false;
		loginReault = (userEntity != null);
		if (loginReault == false) {
			sendTokenResultBean(response, false, "");
			return;
		}
		String token = TokenManager.getToken(requestUserBean.getUsername());
		Cookie cookie = new Cookie(TokenCons.COOKIE_KEY_TOKEN, token);
		// 设置Maximum Age
		cookie.setMaxAge(36000000);
		// 设置cookie路径为当前项目路径
		cookie.setPath("/");
		cookie.setDomain("localhost");
		// 添加cookie
		response.addCookie(cookie);
		sendTokenResultBean(response, true, token);
	}

	private void sendTokenResultBean(HttpServletResponse response, boolean success, String token) {
		try {

			if (success) {
				response.getWriter().print(new Gson().toJson(new TokenResultBean(success, token)));
			} else {
				response.getWriter().print(new Gson().toJson(new TokenResultBean(success, "")));
			}
		} catch (IOException e) {
			Log.error("send token result bean fail!");
			e.printStackTrace();
		}
	}

	@CrossOrigin
	@RequestMapping("/login")
	@ResponseBody
	public SimpleResultBean loginAsAdmin(@RequestBody UserBean requestBody, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		Log.error("what the fuck");
		boolean isTokenValid = TokenManager.verifyToken(request);
		if(!isTokenValid){
			return new SimpleResultBean(false);
		}else{
			Log.error("token 验证成功");
		}
		// TODO 尝试获取 token(在 header 中)
		Log.error(request.getHeader("token") + "**************************");
		// 尝试获取用户 Entity
		UserDaoImpl userDaoImple = new ClassPathXmlApplicationContext("spring.xml").getBean(UserDaoImpl.class);
		UserEntity userEntity = userDaoImple.getUserEntity(requestBody.getUsername(), requestBody.getPassword(),
				requestBody.getIsAdmin());
		boolean loginReault = false;
		loginReault = (userEntity != null);
		if (loginReault) {
			session.setAttribute(SessionCons.KEY_USERNAME, requestBody.getUsername());
			session.setAttribute(SessionCons.KEY_PASSWORD, requestBody.getPassword());
		}
		response.addCookie(new Cookie("testCookie", "CookieValue"));
		return new SimpleResultBean(loginReault);
	}
}
