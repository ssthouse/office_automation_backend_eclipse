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
}
