package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IOutingDao;
import com.ssthouse.officeautomation.domain.OutingEntity;
import com.ssthouse.officeautomation.service.IOutingService;

public class OutingServiceImpl extends BaseService<IOutingDao> implements IOutingService {

	@Override
	public void saveNewOuting(OutingEntity outingEntity) {
		getDao().saveOutingEntity(outingEntity);
	}

	@Override
	public void updateOuting(OutingEntity outingEntity) {
		getDao().updateOutingEntity(outingEntity);
	}

	@Override
	public void deleteOuting(int id) {
		getDao().deleteOutingEntity(id);
	}

	@Override
	public List<OutingEntity> getOpenOutingList(String username) {
		return getDao().getUserOutingEntities(username);
	}

	@Override
	public List<OutingEntity> getAdminOutingList(String approverUsername) {
		return getDao().getAdminOutingEntities(approverUsername);
	}

}
