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
import com.ssthouse.officeautomation.controller.officialdoc.bean.IncomingResult;
import com.ssthouse.officeautomation.domain.IncomingEntity;
import com.ssthouse.officeautomation.service.IIncomingService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/incoming")
public class IncomingController extends BaseController<IIncomingService> {

	@Override
	public Class<IIncomingService> getServiceClass() {
		return IIncomingService.class;
	}

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String saveNewIncoming(HttpServletRequest request, @RequestBody IncomingEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().saveIncomingEntity(entity);
		return ResultHelper.generateSimpleResult(true, "");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String updateIncoming(HttpServletRequest request, @RequestBody IncomingEntity entity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateIncomingEntity(entity);
		return ResultHelper.generateSimpleResult(true, "");
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String deleteIncoming(HttpServletRequest request, @RequestParam int id) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().deleteIncomingEntity(id);
		return ResultHelper.generateSimpleResult(true, "");
	}
	
	@CrossOrigin
	@GetMapping(value = "/user", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getUserIncomings(HttpServletRequest request){
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<IncomingEntity> incomingEntities = getService().getUserIncomings(username);
		IncomingResult result = new IncomingResult(true, null, incomingEntities);
		return new Gson().toJson(request);
	}
	
	@CrossOrigin
	@GetMapping(value = "/owner", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getOwnerIncomings(HttpServletRequest request){
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<IncomingEntity> incomingEntities = getService().getOwnerIncomings(username);
		IncomingResult result = new IncomingResult(true, null, incomingEntities);
		return new Gson().toJson(request);
	}
}
