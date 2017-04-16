package com.ssthouse.officeautomation.service;

import com.ssthouse.officeautomation.domain.UserConfigEntity;

public interface IUserConfigService {

	void setUserConfig(UserConfigEntity userConfigEntity);
	
	void updateUserConfig(UserConfigEntity userConfigEntity);
	
	void deleteUserConfig(int id);
	
	UserConfigEntity getUserConfig(int id);
	
	UserConfigEntity getUserConfig(String usrename);
}
