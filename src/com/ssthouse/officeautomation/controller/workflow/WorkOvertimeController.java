package com.ssthouse.officeautomation.controller.workflow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;
import com.ssthouse.officeautomation.service.IWorkOvertimeService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping("/work_overtime")
public class WorkOvertimeController extends BaseController<IWorkOvertimeService>{

	@Override
	public Class<IWorkOvertimeService> getServiceClass(){
		return IWorkOvertimeService.class;
	}
	
	@CrossOrigin
	@PostMapping(value="/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postNewWorkOvertime(HttpServletRequest request, @RequestBody WorkOvertimeEntity entity){
		if(!TokenManager.verifyToken(request)){
			return ResultHelper.generateTokenInvalidResult();
		}
		IWorkOvertimeService service = getService();
		service.saveNewWorkOvertime(entity);
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}
}
