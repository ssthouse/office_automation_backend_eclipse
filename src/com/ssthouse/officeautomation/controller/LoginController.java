package com.ssthouse.officeautomation.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssthouse.officeautomation.constant.SessionCons;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.bean.UserBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.token.cons.TokenCons;
import com.ssthouse.officeautomation.util.StringUtil;

@Controller
@RequestMapping("/")
public class LoginController {

	@CrossOrigin
	@RequestMapping("/token")
	public void getToken(HttpServletRequest request, HttpServletResponse response, @RequestBody UserBean requestUserBean){
		Cookie cookie=new Cookie(TokenCons.COOKIE_KEY_TOKEN, "Tom");
		//设置Maximum Age
		cookie.setMaxAge(1000);
		//设置cookie路径为当前项目路径
		cookie.setPath(request.getContextPath());
		//添加cookie
		response.addCookie(cookie);
	}
	
	@CrossOrigin
	@RequestMapping("/login")
	@ResponseBody
	public SimpleResultBean loginAsAdmin(@RequestBody UserBean requestBody, HttpSession session) {
		if(requestBody == null || StringUtil.isEmpty(requestBody.getUsername())
				|| StringUtil.isEmpty(requestBody.getPassword())){
			return new SimpleResultBean(false);
		}
		// 尝试获取用户 Entity
		UserDaoImpl userDaoImple = new ClassPathXmlApplicationContext("spring.xml").getBean(UserDaoImpl.class);
		UserEntity userEntity = userDaoImple.getUserEntity(requestBody.getUsername(), 
				requestBody.getPassword(), requestBody.getIsAdmin());
		boolean loginReault = false;
		loginReault =  (userEntity != null);
		if(loginReault){
			session.setAttribute(SessionCons.KEY_USERNAME, requestBody.getUsername());
			session.setAttribute(SessionCons.KEY_PASSWORD, requestBody.getPassword());
		}
		return new SimpleResultBean(loginReault);
	}
}
