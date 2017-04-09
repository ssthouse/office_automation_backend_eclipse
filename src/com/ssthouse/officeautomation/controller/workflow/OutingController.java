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
import com.ssthouse.officeautomation.controller.workflow.bean.OutingListResult;
import com.ssthouse.officeautomation.domain.OutingEntity;
import com.ssthouse.officeautomation.service.IOutingService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/outing")
public class OutingController extends BaseController<IOutingService> {

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String saveNewOuting(HttpServletRequest request, @RequestBody OutingEntity outingEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveNewOuting(outingEntity);
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String updateOuting(HttpServletRequest request, @RequestBody OutingEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateOuting(entity);
		return ResultHelper.generateSimpleResult(true, "更新成功");
	}

	@CrossOrigin
	@GetMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String deleteOuting(HttpServletRequest request, @RequestParam int id) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().deleteOuting(id);
		return ResultHelper.generateSimpleResult(true, "删除成功");
	}

	@CrossOrigin
	@GetMapping(value = "/open", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOpenOutingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<OutingEntity> list = getService().getOpenOutingList(username);
		Log.error(username);
		Log.error(new Gson().toJson(new OutingListResult(true, "获取数据成功", list)));
		return new Gson().toJson(new OutingListResult(true, "获取数据成功", list));
	}

	@CrossOrigin
	@GetMapping(value = "/admin", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getAdminOutingList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String approverUsername = TokenManager.getTokenUsername(request.getHeader("token"));
		List<OutingEntity> list = getService().getAdminOutingList(approverUsername);
		return new Gson().toJson(new OutingListResult(true, "获取数据成功", list));
	}

	@Override
	public Class<IOutingService> getServiceClass() {
		return IOutingService.class;
	}
}
