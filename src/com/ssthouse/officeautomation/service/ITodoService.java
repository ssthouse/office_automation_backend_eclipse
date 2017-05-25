package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.TodoEntity;

public interface ITodoService {

	void addTodo(TodoEntity todoEntity);

	void deleteTodo(int id);

	void updateTodo(TodoEntity todoEntity);

	List<TodoEntity> getTodoList(String creater);
}
