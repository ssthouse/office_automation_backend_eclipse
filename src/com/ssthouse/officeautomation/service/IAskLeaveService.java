package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.AskLeaveEntity;

public interface IAskLeaveService {
	
	void saveNewAskLeave(AskLeaveEntity askLeaveEntity);

	List<AskLeaveEntity> getUserAskLeaveEntities(String username);
	
	List<AskLeaveEntity> getAdminAskLeaveEntities(String approverUsername);
	
	void updateAskLeaveEntity(AskLeaveEntity askLeaveEntity);
	
	void deleteAskLeaveEntity(int askLeaveEntityId);
}
