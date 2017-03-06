package com.ssthouse.officeautomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/{test_str}")
	@ResponseBody
	public String getTestResponse(@PathVariable String test_str){
		return new Gson().toJson(new UserInfo(test_str, "22"));
	}

}
