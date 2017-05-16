package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.NewsEntity;

public interface INewsService {

	void addNews(NewsEntity newsEntity);
	
	void deleteNews(NewsEntity newsEntity);
	
	void deleteNews(int beanId);
	
	void updateNews(NewsEntity newsEntity);
	
	List<NewsEntity> getAllNews();
}
