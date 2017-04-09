package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;

public interface IWorkOvertimeService {
	
	void saveNewWorkOvertime(WorkOvertimeEntity entity);
	
	void updateWorkOvertime(WorkOvertimeEntity entity);
	
	void deleteWorkOvertime(int entityId);
	
	WorkOvertimeEntity getWorkOvertime(int entityId);
	
	List<WorkOvertimeEntity> getUserWorkOvertimeList(String username);
	
	List<WorkOvertimeEntity> getAdminWorkOvertimeList(String approverUsername);

}
