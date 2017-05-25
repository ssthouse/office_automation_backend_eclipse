package com.ssthouse.officeautomation.controller.homepage;

import java.util.List;

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
import com.ssthouse.officeautomation.controller.homepage.bean.TodoListResult;
import com.ssthouse.officeautomation.domain.TodoEntity;
import com.ssthouse.officeautomation.service.ITodoService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.ResultHelper;
import com.ssthouse.officeautomation.util.constant.ControllerCons;
import com.sun.org.apache.bcel.internal.generic.NEW;

import antlr.build.Tool;

@Controller
@RequestMapping(value = "/todo")
public class TodoController extends BaseController<ITodoService> {

	@CrossOrigin
	@PostMapping(value = "/update", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String updateTodo(HttpServletRequest request, @RequestBody TodoEntity todoEntity) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		getService().updateTodo(todoEntity);
		return ResultHelper.generateSimpleResult(true, "更新日程成功");
	}

	@CrossOrigin
	@GetMapping(value = "/todo_list", produces = ControllerCons.PRODUCES_UTF_8)
	@ResponseBody
	public String getTodoList(HttpServletRequest request) {
		if (!TokenManager.verifyToken(request)) {
			return ResultHelper.generateTokenInvalidResult();
		}
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		List<TodoEntity> todoList = getService().getTodoList(username);
		return new Gson().toJson(new TodoListResult(true, "", todoList));
	}

	@Override
	public Class<ITodoService> getServiceClass() {
		return ITodoService.class;
	}
}
