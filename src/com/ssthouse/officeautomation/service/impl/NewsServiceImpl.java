package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.INewsDao;
import com.ssthouse.officeautomation.domain.NewsEntity;
import com.ssthouse.officeautomation.service.INewsService;
import com.sun.org.apache.regexp.internal.recompile;

public class NewsServiceImpl extends BaseService<INewsDao> implements INewsService {

	@Override
	public void addNews(NewsEntity newsEntity) {
		if (newsEntity == null || !newsEntity.isValid()) {
			return;
		}
		getDao().addNews(newsEntity);
	}

	@Override
	public void deleteNews(NewsEntity newsEntity) {
		if (newsEntity == null || newsEntity.getId() == 0) {
			return;
		}
		getDao().deleteNews(newsEntity);
	}

	@Override
	public void updateNews(NewsEntity newsEntity) {
		if (newsEntity == null || newsEntity.getId() == 0) {
			return;
		}
		getDao().updateNews(newsEntity);
	}

	@Override
	public List<NewsEntity> getAllNews() {
		return getDao().getAllNews();
	}

	@Override
	public void deleteNews(int beanId) {
		if (beanId <= 0) {
			return;
		}
		getDao().deleteNews(beanId);
	}

}
