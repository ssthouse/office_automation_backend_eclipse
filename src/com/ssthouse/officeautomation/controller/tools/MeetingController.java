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
import com.ssthouse.officeautomation.controller.tools.bean.MeetingListResult;
import com.ssthouse.officeautomation.domain.MeetingEntity;
import com.ssthouse.officeautomation.service.IMeetingService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/meeting")
public class MeetingController extends BaseController<IMeetingService> {

	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	@CrossOrigin
	public String postNewMeeting(HttpServletRequest request, @RequestBody MeetingEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveMeeting(entity);
		return ResultHelper.generateSimpleResult(true, "新建会议成功");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postUpdateMeeting(HttpServletRequest request, @RequestBody MeetingEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateMeeting(entity);
		return ResultHelper.generateSimpleResult(true, "更新会议成功");
	}

	@CrossOrigin
	@GetMapping(value = "/open", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOpenMeetingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<MeetingEntity> meetingList = getService().getOpenMeetingList(username);
		MeetingListResult result = new MeetingListResult(true, "获取会议数据成功", meetingList);
		return new Gson().toJson(result);
	}

	@CrossOrigin
	@GetMapping(value = "/owned", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOwnedMeetingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<MeetingEntity> meetingList = getService().getOwnedMeetingList(username);
		MeetingListResult result = new MeetingListResult(true, "获取会议数据成功", meetingList);
		return new Gson().toJson(result);
	}

	@Override
	public Class<IMeetingService> getServiceClass() {
		return IMeetingService.class;
	}
}
