package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.ITodoDao;
import com.ssthouse.officeautomation.domain.TodoEntity;

public class TodoDaoImpl extends BaseDao implements ITodoDao {

	@Override
	public void addTodo(TodoEntity todoEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(todoEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteTodo(TodoEntity todoEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.delete(todoEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateTodo(TodoEntity todoEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(todoEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public TodoEntity getTodoEntity(int id) {
		Session session = openSession();
		session.beginTransaction();
		TodoEntity todoEntity = (TodoEntity) session.createCriteria(TodoEntity.class).add(Restrictions.eq("id", id))
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return todoEntity;
	}

	@Override
	public List<TodoEntity> getAllTodo(String creater) {
		Session session = openSession();
		session.beginTransaction();
		List<TodoEntity> todoList = session.createCriteria(TodoEntity.class).add(Restrictions.eq("creater", creater))
				.list();
		session.getTransaction().commit();
		session.close();
		return todoList;
	}

}
