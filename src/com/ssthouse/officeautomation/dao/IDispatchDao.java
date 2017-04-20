package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.DispatchEntity;

public interface IDispatchDao {

	void saveDispatch(DispatchEntity entity);
	
	void updateDispatch(DispatchEntity entity);
	
	DispatchEntity getDispatch(int id);
	
	List<DispatchEntity> getUserDispatchList(String username);
	
	List<DispatchEntity> getOwnedDispatchList(String ownerUsername);
}
