package com.ssthouse.officeautomation.controller.homepage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseController;
import com.ssthouse.officeautomation.controller.homepage.bean.UserConfigResult;
import com.ssthouse.officeautomation.domain.UserConfigEntity;
import com.ssthouse.officeautomation.service.IUserConfigService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/user_config")
public class UserConfigController extends BaseController<IUserConfigService> {

	@Override
	public Class<IUserConfigService> getServiceClass() {
		return IUserConfigService.class;
	}

	@CrossOrigin
	@GetMapping(value = "/detail", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getUserConfig(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		UserConfigEntity entity = getService().getUserConfig(username);
		return new Gson().toJson(new UserConfigResult(true, "获取用户设置成功", entity));
	}

	@CrossOrigin
	@PostMapping(value="/update", produces=ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String updateUserConfig(HttpServletRequest request, @RequestBody UserConfigEntity userConfigEntity){
		if(!TokenManager.verifyToken(request)){
			return ResultHelper.generateTokenInvalidResult();
		}
		// TODO verify is the request body is valid
		if(!userConfigEntity.isValid()){
			return ResultHelper.generateSimpleResult(false, "提交数据有误");
		}
		getService().updateUserConfig(userConfigEntity);
		return ResultHelper.generateSimpleResult(true, "更新配置成功");
	}
}
