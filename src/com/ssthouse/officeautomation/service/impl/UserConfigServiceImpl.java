package com.ssthouse.officeautomation.service.impl;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IUserConfigDao;
import com.ssthouse.officeautomation.domain.UserConfigEntity;
import com.ssthouse.officeautomation.service.IUserConfigService;

public class UserConfigServiceImpl extends BaseService<IUserConfigDao> implements IUserConfigService {

	@Override
	public void setUserConfig(UserConfigEntity userConfigEntity) {
		getDao().setUserConfig(userConfigEntity);
	}

	@Override
	public void updateUserConfig(UserConfigEntity userConfigEntity) {
		getDao().updateUserConfig(userConfigEntity);
	}

	@Override
	public void deleteUserConfig(int id) {
		getDao().deleteUserConfig(id);
	}

	@Override
	public UserConfigEntity getUserConfig(int id) {
		return getDao().getUserConfig(id);
	}

	@Override
	public UserConfigEntity getUserConfig(String username) {
		return getDao().getUserConfig(username);
	}

}
