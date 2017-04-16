package com.ssthouse.officeautomation.dao;

import com.ssthouse.officeautomation.domain.UserConfigEntity;

public interface IUserConfigDao {

	void setUserConfig(UserConfigEntity userConfigEntity);
	
	void updateUserConfig(UserConfigEntity userConfigEntity);
	
	void deleteUserConfig(int id);
	
	UserConfigEntity getUserConfig(int id);
	
	UserConfigEntity getUserConfig(String usrename);
}
