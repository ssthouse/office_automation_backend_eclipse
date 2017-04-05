package com.ssthouse.officeautomation.controller.homepage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.homepage.bean.UserResultBean;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.service.IUserInfoService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

/**
 * Created by ssthouse on 26/01/2017.
 */

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 获取用户信息 GET
	 * 
	 * @param username
	 * @return
	 */
	@CrossOrigin
	@GetMapping(value = "/info", produces = { ControllerCons.PRODUCES_UTF_8 })
	@ResponseBody
	public String getUserInfo(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return new Gson().toJson(new UserResultBean(false, "token 过期", null));
		}
		// 根据token获取UserEntity
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IUserInfoService userInfoService = context.getBean(IUserInfoService.class);
		UserEntity userEntity = userInfoService.getUserInfo(request.getHeader("token"));
		if (!userEntity.isValid()) {
			return new Gson().toJson(new UserResultBean(false, "未找到用户", null));
		}
		return new Gson().toJson(new UserResultBean(true, userEntity));
	}

	@CrossOrigin
	@PostMapping(value = "/info", produces = { ControllerCons.PRODUCES_UTF_8 })
	@ResponseBody
	public String modifyUserInfo(@RequestBody UserEntity userEntity, HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return new Gson().toJson(new SimpleResultBean(false, "token无效"));
		}
		// 根据username找到UserEntity
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IUserInfoService userInfoService = context.getBean(IUserInfoService.class);
		boolean result = userInfoService.updateUserInfo(userEntity, request.getHeader("token"));
		return new Gson().toJson(new SimpleResultBean(result));
	}
}
