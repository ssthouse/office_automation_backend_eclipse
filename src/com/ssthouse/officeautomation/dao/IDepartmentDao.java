package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.DepartmentEntity;

public interface IDepartmentDao {

	// 增加部门
	void addApartment(DepartmentEntity apartmentEntity);
	
	//删除部门
	void deleteApartment(DepartmentEntity apartmentEntity);
	
	//更新部门
	void updateApartment(DepartmentEntity apartmentEntity);
	
	//获取部门
	DepartmentEntity getApartment(int id);
	
	//获取全部apartment
	List<DepartmentEntity> getAllApartment();
}
