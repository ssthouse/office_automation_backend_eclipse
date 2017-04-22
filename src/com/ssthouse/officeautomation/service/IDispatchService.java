package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.DispatchEntity;

public interface IDispatchService {

	void saveDispatch(DispatchEntity entity);
	
	void deleteDispatch(int id);
	
	void updateDispatch(DispatchEntity entity);
	
	List<DispatchEntity> getUserDispatchList(String username);
	
	List<DispatchEntity> getOwnedDispatchList(String ownerUsername);
}
