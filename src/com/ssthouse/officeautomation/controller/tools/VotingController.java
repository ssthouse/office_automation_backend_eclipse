package com.ssthouse.officeautomation.controller.tools;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/voting")
public class VotingController {

	@CrossOrigin
	@ResponseBody
	@PostMapping(value = "/new")
	public String saveVotingEntity(HttpServletRequest request) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		return "";
	}

}
