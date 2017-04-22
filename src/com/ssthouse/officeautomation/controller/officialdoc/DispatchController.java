package com.ssthouse.officeautomation.controller.officialdoc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.officialdoc.bean.DispatchListResult;
import com.ssthouse.officeautomation.domain.DispatchEntity;
import com.ssthouse.officeautomation.service.IDispatchService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/dispatch")
public class DispatchController extends BaseController<IDispatchService> {

	@Override
	public Class<IDispatchService> getServiceClass() {
		return IDispatchService.class;
	}

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String saveDispatch(HttpServletRequest request, @RequestBody DispatchEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveDispatch(entity);
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@GetMapping(value = "/user", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getUserDispatchList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<DispatchEntity> result = getService().getUserDispatchList(username);
		return new Gson().toJson(new DispatchListResult(true, null, result));
	}

	@CrossOrigin
	@GetMapping(value = "/owner", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOwnerDispatchList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<DispatchEntity> result = getService().getOwnedDispatchList(username);
		return new Gson().toJson(new DispatchListResult(true, null, result));
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String updateDisapth(HttpServletRequest request, @RequestBody DispatchEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateDispatch(entity);
		return ResultHelper.generateSimpleResult(true, null);
	}

	@CrossOrigin
	@DeleteMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String deleteDispatch(HttpServletRequest request, @RequestParam int id) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().deleteDispatch(id);
		return ResultHelper.generateSimpleResult(true, "删除成功");
	}
}
