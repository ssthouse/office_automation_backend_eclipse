package com.ssthouse.officeautomation.controller.homepage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.homepage.bean.DepartmentBean;
import com.ssthouse.officeautomation.controller.homepage.bean.DepartmentListBean;
import com.ssthouse.officeautomation.controller.homepage.bean.UserDepartmentBean;
import com.ssthouse.officeautomation.dao.impl.UserDaoImpl;
import com.ssthouse.officeautomation.domain.DepartmentEntity;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.service.IDepartmentService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;
import com.sun.org.apache.bcel.internal.generic.NEW;

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

	@CrossOrigin
	@RequestMapping(value = "/user_department", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getUserWithDepartment(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		// 获取部门列表
		List<DepartmentEntity> departmentList = getService().getApartmentList();
		// 获取用户列表
		UserDaoImpl userDaoImpl = new ClassPathXmlApplicationContext("spring.xml").getBean(UserDaoImpl.class);
		List<UserEntity> userList = userDaoImpl.getAllUser();
		// 创建并填充DepartmentList
		List<DepartmentBean> departmentBeanList = new ArrayList<>();
		for (DepartmentEntity departmentEntity : departmentList) {
			DepartmentBean departmentBean = new DepartmentBean(departmentEntity.getName(), new ArrayList<>());
			for (UserEntity userEntity : userList) {
				if (userEntity.getDepartment().equals(departmentEntity.getName())) {
					departmentBean.addUserEntity(userEntity);
				}
			}
			departmentBeanList.add(departmentBean);
		}
		// 返回数据
		return new Gson().toJson(new UserDepartmentBean(true, "", departmentBeanList));
	}

	@Override
	public Class<IDepartmentService> getServiceClass() {
		return IDepartmentService.class;
	}
}
