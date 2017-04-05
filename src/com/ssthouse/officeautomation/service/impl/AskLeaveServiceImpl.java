package com.ssthouse.officeautomation.service.impl;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IAskLeaveDao;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.service.IAskLeaveService;

public class AskLeaveServiceImpl extends BaseService<IAskLeaveDao> implements IAskLeaveService{

	@Override
	public void saveNewAskLeave(AskLeaveEntity askLeaveEntity) {
		getDao().saveAskLeaveEntity(askLeaveEntity);
	}

}
