package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.INewsDao;
import com.ssthouse.officeautomation.domain.NewsEntity;

public class NewsDaoImpl extends BaseDao implements INewsDao {

	@Override
	public void addNews(NewsEntity newsEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(newsEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteNews(NewsEntity newsEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.delete(newsEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateNews(NewsEntity newsEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(newsEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<NewsEntity> getAllNews() {
		Session session = openSession();
		session.beginTransaction();
		List<NewsEntity> result = session.createCriteria(NewsEntity.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	private NewsEntity getNewsEntity(int beanId) {
		Session session = openSession();
		session.beginTransaction();
		NewsEntity result = (NewsEntity) session.createCriteria(NewsEntity.class).add(Restrictions.eq("id", beanId)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public void deleteNews(int beanId) {
		NewsEntity entity = getNewsEntity(beanId);
		deleteNews(entity);
	}

}
