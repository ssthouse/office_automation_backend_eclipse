package com.ssthouse.officeautomation.controller.tools;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.tools.bean.OpenVotingListResult;
import com.ssthouse.officeautomation.controller.tools.bean.OwnedVotingListResult;
import com.ssthouse.officeautomation.domain.VoteOptionEntity;
import com.ssthouse.officeautomation.domain.VotingEntity;
import com.ssthouse.officeautomation.service.IVotingService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/voting")
public class VotingController extends BaseController<IVotingService> {

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
		getService().saveVoting(votingEntity);
		return ResultHelper.generateSimpleResult(true, "投票保存成功");
	}

	@CrossOrigin
	@ResponseBody
	@PostMapping(value = "/vote", produces = ControllerCons.PRODUCES_UTF_8)
	public String saveVoteOptionList(HttpServletRequest request, @RequestBody List<VoteOptionEntity> voteOptionList) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveVoteOptionList(voteOptionList);
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
		List<VotingEntity> openVotingList = getService().getVotingList(username);
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
		List<VotingEntity> ownedVotingList = getService().getOwnedVotingList(createrId);
		OwnedVotingListResult result = new OwnedVotingListResult(true, "获取公开投票数据成功", ownedVotingList);
		return new Gson().toJson(result);
	}

	@Override
	public Class<IVotingService> getServiceClass() {
		return IVotingService.class;
	}

}
