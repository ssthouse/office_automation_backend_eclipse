package com.ssthouse.officeautomation.controller.tools;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.tools.bean.MeetingRoomListResult;
import com.ssthouse.officeautomation.domain.MeetingRoomEntity;
import com.ssthouse.officeautomation.service.IMeetingRoomService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/meeting_room")
public class MeetingRoomController extends BaseController<IMeetingRoomService> {

	@Override
	public Class<IMeetingRoomService> getServiceClass() {
		return IMeetingRoomService.class;
	}

	@CrossOrigin
	@ResponseBody
	@GetMapping(value = "/all", produces = ControllerCons.PRODUCES_UTF_8)
	public String getMeetingRoomList(HttpServletRequest request) {
		if(!TokenManager.verifyToken(request)){
			return ResultHelper.generateTokenInvalidResult(); 
		}
		List<MeetingRoomEntity> list = getService().getMeetingRoomList();
		MeetingRoomListResult result = new MeetingRoomListResult(true, "", list);
		return new Gson().toJson(result);
	}
}
