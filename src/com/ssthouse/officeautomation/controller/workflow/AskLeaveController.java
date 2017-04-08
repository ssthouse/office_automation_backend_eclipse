package com.ssthouse.officeautomation.controller.workflow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.controller.workflow.bean.AskLeaveEntitiesResult;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.service.IAskLeaveService;
import com.ssthouse.officeautomation.service.impl.AskLeaveServiceImpl;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/ask_leave")
public class AskLeaveController {

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postNewAskLeave(HttpServletRequest request, @RequestBody AskLeaveEntity askLeaveEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAskLeaveService askLeaveService = context.getBean(AskLeaveServiceImpl.class);
		askLeaveService.saveNewAskLeave(askLeaveEntity);
		return ResultHelper.generateSimpleResult(true, "新请假审批创建成功");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postUpdateAskLeave(HttpServletRequest request, @RequestBody AskLeaveEntity askLeaveEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAskLeaveService askLeaveService = context.getBean(AskLeaveServiceImpl.class);
		askLeaveService.updateAskLeaveEntity(askLeaveEntity);
		return ResultHelper.generateSimpleResult(true, "请假审批更新成功");
	}

	@CrossOrigin
	@GetMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postUpdateAskLeave(HttpServletRequest request, @RequestParam int id) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAskLeaveService askLeaveService = context.getBean(AskLeaveServiceImpl.class);
		askLeaveService.deleteAskLeaveEntity(id);
		return ResultHelper.generateSimpleResult(true, "请假审批成功删除");
	}

	@CrossOrigin
	@GetMapping(value = "/open", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	String getUserAskLeaveEntities(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AskLeaveServiceImpl service = context.getBean(AskLeaveServiceImpl.class);
		List<AskLeaveEntity> askLeaveList = service.getUserAskLeaveEntities(username);
		if (askLeaveList == null) {
			return ResultHelper.generateSimpleResult(false, "请假审批数据获取失败");
		}
		AskLeaveEntitiesResult result = new AskLeaveEntitiesResult(true, "获取成功", askLeaveList);
		return new Gson().toJson(result);
	}

	@CrossOrigin
	@GetMapping(value = "/admin", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	String getAdminAskLeaveEntities(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String approverUername = TokenManager.getTokenUsername(request.getHeader("token"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AskLeaveServiceImpl service = context.getBean(AskLeaveServiceImpl.class);
		List<AskLeaveEntity> askLeaveList = service.getAdminAskLeaveEntities(approverUername);
		if (askLeaveList == null) {
			return ResultHelper.generateSimpleResult(false, "请假审批数据获取失败");
		}
		AskLeaveEntitiesResult result = new AskLeaveEntitiesResult(true, "获取审批数据成功", askLeaveList);
		return new Gson().toJson(result);
	}
}
