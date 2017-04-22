package com.ssthouse.officeautomation.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IIncomingDao;
import com.ssthouse.officeautomation.domain.IncomingEntity;
import com.ssthouse.officeautomation.service.IIncomingService;
import com.ssthouse.officeautomation.util.StringUtil;

public class IncomingServiceImpl extends BaseService<IIncomingDao> implements IIncomingService {

	@Override
	public void saveIncomingEntity(IncomingEntity entity) {
		if (entity == null || entity.getId() > 0) {
			return;
		}
		getDao().saveIncomingEntity(entity);
	}

	@Override
	public void updateIncomingEntity(IncomingEntity entity) {
		if (entity == null || entity.getId() <= 0) {
			return;
		}
		getDao().updateIncomingEntity(entity);
	}

	@Override
	public void deleteIncomingEntity(int id) {
		if (id <= 0) {
			return;
		}
		getDao().deleteIncomingEntity(id);
	}

	@Override
	public IncomingEntity getIncomingEntity(int id) {
		if (id <= 0) {
			return null;
		}
		return getDao().getIncomingEntity(id);
	}

	@Override
	public List<IncomingEntity> getUserIncomings(String username) {
		if (StringUtil.isEmpty(username)) {
			return new ArrayList<>();
		}
		return getDao().getUserIncomings(username);
	}

	@Override
	public List<IncomingEntity> getOwnerIncomings(String ownerUsername) {
		if (StringUtil.isEmpty(ownerUsername)) {
			return new ArrayList<>();
		}
		return getDao().getOwnerIncomings(ownerUsername);
	}

}
