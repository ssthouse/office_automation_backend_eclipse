package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.DepartmentEntity;

public interface IDepartmentService {

	void addApartment(DepartmentEntity departmentEntity);
	
	void deleteApartment(int id);
	
	void updateApartment(DepartmentEntity departmentEntity);
	
	List<DepartmentEntity> getApartmentList();
}
