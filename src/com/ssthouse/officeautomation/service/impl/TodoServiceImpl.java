package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.ITodoDao;
import com.ssthouse.officeautomation.domain.TodoEntity;
import com.ssthouse.officeautomation.service.ITodoService;

public class TodoServiceImpl extends BaseService<ITodoDao> implements ITodoService {

	@Override
	public void addTodo(TodoEntity todoEntity) {
		if (todoEntity == null || !todoEntity.isValid()) {
			return;
		}
		getDao().addTodo(todoEntity);
	}

	@Override
	public void deleteTodo(int id) {
		if (id < 0) {
			return;
		}
		TodoEntity todoEntity = getDao().getTodoEntity(id);
		getDao().deleteTodo(todoEntity);
	}

	@Override
	public void updateTodo(TodoEntity todoEntity) {
		if (todoEntity == null || !todoEntity.isValid()) {
			return;
		}
		getDao().updateTodo(todoEntity);
	}

	@Override
	public List<TodoEntity> getTodoList(String creater) {
		return getDao().getAllTodo(creater);
	}

}
