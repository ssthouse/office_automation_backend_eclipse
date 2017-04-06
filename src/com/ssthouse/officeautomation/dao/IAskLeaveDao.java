package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.AskLeaveEntity;

public interface IAskLeaveDao {

	void saveAskLeaveEntity(AskLeaveEntity askLeaveEntity);
	
	void updateAskLeaveEntity(AskLeaveEntity askLeaveEntity);
	
	void deleteAskLeaveEntity(AskLeaveEntity askLeaveEntity);
	
	void deleteAskLeaveEntity(int askLeaveEntityId);
	
	AskLeaveEntity getAskLeaveEntity(int id);
	
	List<AskLeaveEntity> getUserAskLeaveEntities(String username);
	
	List<AskLeaveEntity> getAdminAskLeaveEntities(String approverUsername);
}
