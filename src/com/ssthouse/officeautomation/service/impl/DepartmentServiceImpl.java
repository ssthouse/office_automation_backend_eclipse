package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IDepartmentDao;
import com.ssthouse.officeautomation.domain.DepartmentEntity;
import com.ssthouse.officeautomation.service.IDepartmentService;

public class DepartmentServiceImpl extends BaseService<IDepartmentDao> implements IDepartmentService {

	@Override
	public void addApartment(DepartmentEntity apartmentEntity) {
		if (apartmentEntity == null || apartmentEntity.getId() > 0) {
			return;
		}
		getDao().addApartment(apartmentEntity);
	}

	@Override
	public void deleteApartment(int id) {
		if (id < 0) {
			return;
		}
		DepartmentEntity apartmentEntity = getDao().getApartment(id);
		getDao().deleteApartment(apartmentEntity);
	}

	@Override
	public void updateApartment(DepartmentEntity apartmentEntity) {
		if (apartmentEntity == null || apartmentEntity.getId() < 0) {
			return;
		}
		getDao().updateApartment(apartmentEntity);
	}

	@Override
	public List<DepartmentEntity> getApartmentList() {
		return getDao().getAllApartment();
	}

}
