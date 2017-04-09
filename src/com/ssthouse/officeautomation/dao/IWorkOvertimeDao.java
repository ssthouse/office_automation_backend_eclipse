package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;

public interface IWorkOvertimeDao{

	void saveWorkOvertime (WorkOvertimeEntity workOvertimeEntity);
	
	void updateWorkOvertime(WorkOvertimeEntity entity);
	
	void deleteWorkOvertime(int entiyId);
	
	WorkOvertimeEntity getWorkOvertimeEntity(int id);
	
	List<WorkOvertimeEntity> getUserWorkOvertimeList(String username);
	
	List<WorkOvertimeEntity> getAdminWorkOvertimeList(String approverUsername);
}
