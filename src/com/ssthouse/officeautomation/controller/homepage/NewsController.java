package com.ssthouse.officeautomation.controller.homepage;

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
import com.ssthouse.officeautomation.controller.homepage.bean.NewsListResult;
import com.ssthouse.officeautomation.domain.NewsEntity;
import com.ssthouse.officeautomation.service.INewsService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;

@Controller
@RequestMapping(value = "/news")
public class NewsController extends BaseController<INewsService> {

	@CrossOrigin
	@PostMapping(value = "/new", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postAddNews(HttpServletRequest request, @RequestBody NewsEntity newsEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().addNews(newsEntity);
		return ResultHelper.generateSimpleResult(true, "保存成功");
	}

	@CrossOrigin
	@GetMapping(value = "/delete", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String deleteNews(HttpServletRequest request, @RequestParam int beanId) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		if (beanId <= 0) {
			return ResultHelper.generateSimpleResult(false, "请求不合法");
		}
		getService().deleteNews(beanId);
		return ResultHelper.generateSimpleResult(true, "删除成功");
	}

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String postUpdateNews(HttpServletRequest request, @RequestBody NewsEntity newsEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateNews(newsEntity);
		return ResultHelper.generateSimpleResult(true, "更新成功");
	}

	@CrossOrigin
	@GetMapping(value = "/all", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getAllNews(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		NewsListResult result = new NewsListResult(true, "", getService().getAllNews());
		return new Gson().toJson(result);
	}

	@Override
	public Class<INewsService> getServiceClass() {
		return INewsService.class;
	}

}
