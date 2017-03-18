package com.ssthouse.officeautomation.controller;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.bean.UserBean;
import com.ssthouse.officeautomation.controller.bean.UserResultBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.service.IUserInfoService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.StringUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ssthouse on 26/01/2017.
 */

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 获取用户信息 GET 直接从token中获取username进行数据库query
	 * 
	 * @param username
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/info", produces = { "application/json;charset=UTF-8" }, method=RequestMethod.GET)
	@ResponseBody
	public String getUserInfo(HttpServletRequest request) {
		Log.error("user/info  ****************************");
		if (!TokenManager.verifyToken(request)) {
			return new Gson().toJson(new UserResultBean(false, "token 过期", null));
		}
		String token = request.getHeader("token");
		// 根据token获取UserEntity
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IUserInfoService userInfoService = context.getBean(IUserInfoService.class);
		UserEntity userEntity = userInfoService.getUserInfo(token);
		if (!isUserEntityValid(userEntity)) {
			return new Gson().toJson(new UserResultBean(false, "未找到用户", null));
		}
		Log.error(new Gson().toJson(userEntity));
		return new Gson().toJson(new UserResultBean(true, userEntity));
	}

	private boolean isUserEntityValid(UserEntity userEntity) {
		if (userEntity == null) {
			return false;
		}
		if (StringUtil.isEmpty(userEntity.getUsername())) {
			return false;
		}
		if (StringUtil.isEmpty(userEntity.getPassword())) {
			return false;
		}
		return true;
	}

	@CrossOrigin
	@RequestMapping(value="/info", method=RequestMethod.POST)
	@ResponseBody
	public String modifyUserInfo(@RequestBody UserEntity userEntity, HttpServletRequest request){
		if(!TokenManager.verifyToken(request)){
			return new Gson().toJson(new SimpleResultBean(false));
		}
		//TODO 根据username找到UserEntity
		return null;
	}
	
	@CrossOrigin
	@RequestMapping("/{username}/blog/{blogId}")
	@ResponseBody
	public String getUserBlogInfo(@PathVariable String username, @PathVariable int blogId) {
		return String.format("username: %s; blogId: %d", username, blogId);
	}

	@CrossOrigin
	@RequestMapping("/index")
	public String getIndex() {
		return "test";
	}

}
