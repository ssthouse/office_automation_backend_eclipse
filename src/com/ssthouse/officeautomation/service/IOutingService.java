package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.OutingEntity;

public interface IOutingService {

	void saveNewOuting(OutingEntity outingEntity);
	
	void updateOuting(OutingEntity outingEntity);
	
	void deleteOuting(int id);
	
	List<OutingEntity> getOpenOutingList(String username);
	
	List<OutingEntity> getAdminOutingList(String approverUsername);
}
