package com.ssthouse.officeautomation.controller.homepage.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.UserEntity;

public class DepartmentBean {

	private String name;
	private List<UserEntity> personList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserEntity> getPersonList() {
		return personList;
	}
	public void setPersonList(List<UserEntity> personList) {
		this.personList = personList;
	}
	public DepartmentBean(String name, List<UserEntity> personList) {
		super();
		this.name = name;
		this.personList = personList;
	}
	
	public void addUserEntity(UserEntity userEntity){
		personList.add(userEntity);
	}
	
}
