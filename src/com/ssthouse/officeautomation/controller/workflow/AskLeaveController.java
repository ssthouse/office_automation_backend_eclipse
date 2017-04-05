package com.ssthouse.officeautomation.controller.workflow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.service.IAskLeaveService;
import com.ssthouse.officeautomation.service.impl.AskLeaveServiceImpl;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.Log;
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
		Log.error(new Gson().toJson(askLeaveEntity));
		return ResultHelper.generateSimpleResult(true, "新请假审批创建成功");
	}
}
