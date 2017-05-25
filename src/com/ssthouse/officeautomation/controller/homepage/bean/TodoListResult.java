package com.ssthouse.officeautomation.controller.homepage.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.TodoEntity;

public class TodoListResult {

	private boolean ok;
	private String msg;
	private List<TodoEntity> todoList;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<TodoEntity> getTodoList() {
		return todoList;
	}
	public void setTodoList(List<TodoEntity> todoList) {
		this.todoList = todoList;
	}
	public TodoListResult(boolean ok, String msg, List<TodoEntity> todoList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.todoList = todoList;
	}
	
}
