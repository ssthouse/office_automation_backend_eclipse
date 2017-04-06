package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IAskLeaveDao;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.service.IAskLeaveService;

public class AskLeaveServiceImpl extends BaseService<IAskLeaveDao> implements IAskLeaveService {

	@Override
	public void saveNewAskLeave(AskLeaveEntity askLeaveEntity) {
		getDao().saveAskLeaveEntity(askLeaveEntity);
	}

	@Override
	public List<AskLeaveEntity> getUserAskLeaveEntities(String username) {
		return getDao().getUserAskLeaveEntities(username);
	}

	@Override
	public List<AskLeaveEntity> getAdminAskLeaveEntities(String approverUsername) {
		return getDao().getAdminAskLeaveEntities(approverUsername);
	}

	@Override
	public void updateAskLeaveEntity(AskLeaveEntity askLeaveEntity) {
		getDao().updateAskLeaveEntity(askLeaveEntity);
	}

	@Override
	public void deleteAskLeaveEntity(int askLeaveEntityId) {
		getDao().deleteAskLeaveEntity(askLeaveEntityId);
	}

}
