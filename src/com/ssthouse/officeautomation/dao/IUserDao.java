package com.ssthouse.officeautomation.dao;

import com.ssthouse.officeautomation.domain.UserEntity;

public interface IUserDao {

	/**
	 * get an user from table User
	 * 
	 * @param username
	 * @param password
	 * @param isAdmin
	 * @return
	 */
	UserEntity getUserEntity(String username, String password, boolean isAdmin);
	
	/**
	 * 直接通过username获取用户信息
	 * 用于已经登录(请求带有token)的情况
	 * @param username
	 * @return
	 */
	UserEntity getUserEntity(String username);
}
