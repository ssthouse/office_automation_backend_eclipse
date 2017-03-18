package com.ssthouse.officeautomation.service;

import com.ssthouse.officeautomation.domain.UserEntity;

/**
 * 处理用户信息的service接口
 * @author ssthouse
 *
 */
public interface IUserInfoService {

	/**
	 * 更新用户信息
	 * @param userEntity
	 */
	boolean updateUserInfo(UserEntity userEntity, String token);
	
	/**
	 * 获取用户信息
	 * @param token
	 */
	UserEntity getUserInfo(String token);
}
