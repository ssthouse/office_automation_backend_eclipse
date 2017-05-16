package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.NewsEntity;

public interface INewsDao {

	void addNews(NewsEntity newsEntity);
	
	void deleteNews(NewsEntity newsEntity);
	
	void deleteNews(int beanId);
	
	void updateNews(NewsEntity newsEntity);
	
	List<NewsEntity> getAllNews();
}
