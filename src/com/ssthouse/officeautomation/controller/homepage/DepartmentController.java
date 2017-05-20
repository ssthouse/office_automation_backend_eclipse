package com.ssthouse.officeautomation.controller.homepage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.homepage.bean.DepartmentListBean;
import com.ssthouse.officeautomation.domain.DepartmentEntity;
import com.ssthouse.officeautomation.service.IDepartmentService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController extends BaseController<IDepartmentService> {

	/**
	 * 获取apartment列表
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/all", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getAllDepartments(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		List<DepartmentEntity> departmentList = getService().getApartmentList();
		DepartmentListBean result = new DepartmentListBean(true, "", departmentList);
		return new Gson().toJson(result);
	}

	@Override
	public Class<IDepartmentService> getServiceClass() {
		return IDepartmentService.class;
	}
}
