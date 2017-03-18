package com.ssthouse.officeautomation.service.impl;

import com.ssthouse.officeautomation.dao.IUserDao;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.service.IUserInfoService;
import com.ssthouse.officeautomation.token.TokenManager;
import com.ssthouse.officeautomation.util.StringUtil;

public class UserInfoServiceImpl implements IUserInfoService{
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao){
		this.userDao = userDao;
	}
	
	public IUserDao getUserDao(){
		return userDao;
	}

	@Override
	public void updateUserInfo(UserEntity userEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity getUserInfo(String token) {
		String username = TokenManager.getTokenUsername(token);
		if(StringUtil.isEmpty(username)){
			return null;
		}
		return userDao.getUserEntity(username);
	}

}
