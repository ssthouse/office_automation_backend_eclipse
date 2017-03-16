package com.ssthouse.officeautomation.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.api.Session;
import com.ssthouse.officeautomation.constant.SessionCons;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.bean.UserBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/")
public class LoginController {

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
