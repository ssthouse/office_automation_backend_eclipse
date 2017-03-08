package com.ssthouse.officeautomation.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssthouse.officeautomation.controller.bean.SimpleResultBean;
import com.ssthouse.officeautomation.controller.bean.UserBean;
import com.ssthouse.officeautomation.util.Log;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/login")
public class LoginController {

	@CrossOrigin
	@RequestMapping(value = "/admin")
	@ResponseBody
	public SimpleResultBean loginAsAdmin(@RequestBody UserBean requestBody) {
		Log.error(requestBody.getPassword());
		Log.error(requestBody.getUsername());
		return new SimpleResultBean(true);
	}
}
