package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.TodoEntity;

public interface ITodoDao {

	void addTodo(TodoEntity todoEntity);

	void deleteTodo(TodoEntity todoEntity);

	void updateTodo(TodoEntity todoEntity);

	TodoEntity getTodoEntity(int id);

	List<TodoEntity> getAllTodo(String username);
}
