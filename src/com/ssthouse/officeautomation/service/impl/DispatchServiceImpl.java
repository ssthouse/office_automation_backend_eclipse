package com.ssthouse.officeautomation.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IDispatchDao;
import com.ssthouse.officeautomation.domain.DispatchEntity;
import com.ssthouse.officeautomation.service.IDispatchService;
import com.ssthouse.officeautomation.util.StringUtil;

public class DispatchServiceImpl extends BaseService<IDispatchDao> implements IDispatchService {

	@Override
	public void saveDispatch(DispatchEntity entity) {
		if (entity == null || entity.getId() > 0) {
			return;
		}
		getDao().saveDispatch(entity);
	}

	@Override
	public void updateDispatch(DispatchEntity entity) {
		if (entity == null || entity.getId() <= 0) {
			return;
		}
		getDao().updateDispatch(entity);
	}

	@Override
	public List<DispatchEntity> getUserDispatchList(String username) {
		if (StringUtil.isEmpty(username)) {
			return new ArrayList<>();
		}
		return getDao().getUserDispatchList(username);
	}

	@Override
	public List<DispatchEntity> getOwnedDispatchList(String ownerUsername) {
		if (StringUtil.isEmpty(ownerUsername)) {
			return new ArrayList<>();
		}
		return getDao().getOwnedDispatchList(ownerUsername);
	}

	@Override
	public void deleteDispatch(int id) {
		getDao().deleteDispatch(id);
	}

}
