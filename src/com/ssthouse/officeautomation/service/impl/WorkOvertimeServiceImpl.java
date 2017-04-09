package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IWorkOvertimeDao;
import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;
import com.ssthouse.officeautomation.service.IWorkOvertimeService;

public class WorkOvertimeServiceImpl extends BaseService<IWorkOvertimeDao> implements IWorkOvertimeService {

	@Override
	public void saveNewWorkOvertime(WorkOvertimeEntity entity) {
		getDao().saveWorkOvertime(entity);
	}

	@Override
	public WorkOvertimeEntity getWorkOvertime(int entityId) {
		return getDao().getWorkOvertimeEntity(entityId);
	}

	@Override
	public List<WorkOvertimeEntity> getUserWorkOvertimeList(String username) {
		return getDao().getUserWorkOvertimeList(username);
	}

	@Override
	public List<WorkOvertimeEntity> getAdminWorkOvertimeList(String approverUsername) {
		return getDao().getAdminWorkOvertimeList(approverUsername);
	}

}
