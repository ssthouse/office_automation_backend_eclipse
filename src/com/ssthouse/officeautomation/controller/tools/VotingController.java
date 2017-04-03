package com.ssthouse.officeautomation.controller.tools;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.service.IVotingService;
import com.ssthouse.officeautomation.service.impl.VotingServiceImpl;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;

@Controller
@RequestMapping("/voting")
public class VotingController {

	@CrossOrigin
	@ResponseBody
	@PostMapping(value = "/new")
	public String saveVotingEntity(HttpServletRequest request, @RequestBody VotingEntity votingEntity) {
		if(!TokenManager.verifyToken(request)){
			return ResultHelper.generateTokenInvalidResult();
		}
		if(!votingEntity.isValid()){
			return ResultHelper.generateSimpleResult(false, "请求数据不完整");
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IVotingService votingService = context.getBean(VotingServiceImpl.class);
		votingService.saveVoting(votingEntity);
		return ResultHelper.generateSimpleResult(true, "问卷保存成功");
	}

}
