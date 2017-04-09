package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.OutingEntity;

public interface IOutingDao {

	void saveOutingEntity(OutingEntity outingEntity);

	void updateOutingEntity(OutingEntity outingEntity);

	void deleteOutingEntity(int id);

	OutingEntity getOutingEntity(int id);

	List<OutingEntity> getUserOutingEntities(String username);

	List<OutingEntity> getAdminOutingEntities(String approverUsername);
}
