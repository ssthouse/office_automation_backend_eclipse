package com.ssthouse.officeautomation.base;

public abstract class BaseService<T> {

	private T dao;
	
	public void setDao(T dao){
		this.dao = dao;
	}
	
	public T getDao(){
		return dao;
	}
}
