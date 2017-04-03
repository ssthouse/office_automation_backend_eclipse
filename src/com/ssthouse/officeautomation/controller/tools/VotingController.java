package com.ssthouse.officeautomation.controller.tools;

import java.util.List;

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
import com.ssthouse.officeautomation.controller.tools.bean.OpenVotingListResult;
import com.ssthouse.officeautomation.controller.tools.bean.OwnedVotingListResult;
import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.service.IVotingService;
import com.ssthouse.officeautomation.service.impl.VotingServiceImpl;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/voting")
public class VotingController {

	@CrossOrigin
	@ResponseBody
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	public String saveVotingEntity(HttpServletRequest request, @RequestBody VotingEntity votingEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		if (!votingEntity.isValid()) {
			return ResultHelper.generateSimpleResult(false, "请求数据不完整");
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IVotingService votingService = context.getBean(VotingServiceImpl.class);
		votingService.saveVoting(votingEntity);
		return ResultHelper.generateSimpleResult(true, "问卷保存成功");
	}

	@CrossOrigin
	@ResponseBody
	@GetMapping(value = "/open", produces = ControllerCons.PRODUCES_UTF_8)
	public String getOpenVotingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IVotingService service = context.getBean(VotingServiceImpl.class);
		List<VotingEntity> openVotingList = service.getVotingList(username);
		OpenVotingListResult result = new OpenVotingListResult(true, "获取公开投票数据成功", openVotingList);
		return new Gson().toJson(result);
	}

	@CrossOrigin
	@ResponseBody
	@GetMapping(value = "/owned", produces = ControllerCons.PRODUCES_UTF_8)
	public String getOwnedVotingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String createrId = TokenManager.getTokenUsername(request.getHeader("token"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IVotingService service = context.getBean(VotingServiceImpl.class);
		List<VotingEntity> ownedVotingList = service.getOwnedVotingList(createrId);
		OwnedVotingListResult result = new OwnedVotingListResult(true, "获取公开投票数据成功", ownedVotingList);
		return new Gson().toJson(result);
	}

}
