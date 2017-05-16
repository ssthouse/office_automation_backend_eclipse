package com.ssthouse.officeautomation.controller.homepage.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.NewsEntity;

public class NewsListResult {

	private boolean ok;
	private String msg;
	private List<NewsEntity> newsList;
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
	public List<NewsEntity> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<NewsEntity> newsList) {
		this.newsList = newsList;
	}
	public NewsListResult(boolean ok, String msg, List<NewsEntity> newsList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.newsList = newsList;
	}
}
