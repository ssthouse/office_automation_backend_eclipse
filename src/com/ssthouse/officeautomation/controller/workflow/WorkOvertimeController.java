package com.ssthouse.officeautomation.controller.workflow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.workflow.bean.WorkOvertimeListResult;
import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;
import com.ssthouse.officeautomation.service.IWorkOvertimeService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/work_overtime")
public class WorkOvertimeController extends BaseController<IWorkOvertimeService> {

	@Override
	public Class<IWorkOvertimeService> getServiceClass() {
		return IWorkOvertimeService.class;
	}

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postNewWorkOvertime(HttpServletRequest request, @RequestBody WorkOvertimeEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveNewWorkOvertime(entity);
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@GetMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String deleteWorkOvertime(HttpServletRequest request, @RequestParam int entityId) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		if(entityId <=0){
			return ResultHelper.generateSimpleResult(false, "请求不合法");
		}
		getService().deleteWorkOvertime(entityId);
		return ResultHelper.generateSimpleResult(true, "删除成功");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postUpdateWorkOvertime(HttpServletRequest request, @RequestBody WorkOvertimeEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateWorkOvertime(entity);
		return ResultHelper.generateSimpleResult(true, "更新成功");
	}

	@CrossOrigin
	@GetMapping(value = "/open", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOpenList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<WorkOvertimeEntity> list = getService().getUserWorkOvertimeList(username);
		return new Gson().toJson(new WorkOvertimeListResult(true, "获取成功", list));
	}

	@CrossOrigin
	@GetMapping(value = "/admin", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getAdminList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String approverUsername = TokenManager.getTokenUsername(request.getHeader("token"));
		List<WorkOvertimeEntity> list = getService().getAdminWorkOvertimeList(approverUsername);
		return new Gson().toJson(new WorkOvertimeListResult(true, "获取成功", list));
	}
}
