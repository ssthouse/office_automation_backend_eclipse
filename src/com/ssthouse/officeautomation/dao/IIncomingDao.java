package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.IncomingEntity;

public interface IIncomingDao {

	void saveIncomingEntity(IncomingEntity entity);
	
	void updateIncomingEntity(IncomingEntity entity);
	
	void deleteIncomingEntity(int id);
	
	IncomingEntity getIncomingEntity(int id);
	
	List<IncomingEntity> getUserIncomings(String username);
	
	List<IncomingEntity> getOwnerIncomings(String ownerUsername);
}
