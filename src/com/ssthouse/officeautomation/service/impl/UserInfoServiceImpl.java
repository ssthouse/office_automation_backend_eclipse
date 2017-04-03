package com.ssthouse.officeautomation.service.impl;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IUserDao;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.service.IUserInfoService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.StringUtil;

public class UserInfoServiceImpl extends BaseService<IUserDao> implements IUserInfoService {

	@Override
	public boolean updateUserInfo(UserEntity userEntity, String token) {
		UserEntity databaseUserEntity = getUserInfo(token);
		if (!databaseUserEntity.isValid()) {
			return false;
		}
		// 更新基本信息
		if (!StringUtil.isEmpty(userEntity.getUsername())) {
			databaseUserEntity.setUsername(userEntity.getUsername());
		}
		if (!StringUtil.isEmpty(userEntity.getPassword())) {
			databaseUserEntity.setPassword(userEntity.getPassword());
		}
		if (!StringUtil.isEmpty(userEntity.getDescription())) {
			databaseUserEntity.setDescription(userEntity.getDescription());
		}
		// 更新详细信息
		if (!StringUtil.isEmpty(userEntity.getGender())) {
			databaseUserEntity.setGender(userEntity.getGender());
		}
		if (!StringUtil.isEmpty(userEntity.getName())) {
			databaseUserEntity.setName(userEntity.getName());
		}
		if (!StringUtil.isEmpty(userEntity.getPhoneNumber())) {
			databaseUserEntity.setPhoneNumber(userEntity.getPhoneNumber());
		}
		if (!StringUtil.isEmpty(userEntity.getDepartment())) {
			databaseUserEntity.setDepartment(userEntity.getDepartment());
		}
		getDao().updateUserEntity(databaseUserEntity);
		return true;
	}

	@Override
	public UserEntity getUserInfo(String token) {
		String username = TokenManager.getTokenUsername(token);
		if (StringUtil.isEmpty(username)) {
			return null;
		}
		return getDao().getUserEntity(username);
	}

}
