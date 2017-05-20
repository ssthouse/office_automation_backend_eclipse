package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ssthouse on 18/05/2017.
 */
@Entity
@Table(name = "department", schema = "office_automation", catalog = "")
public class DepartmentEntity {
	private int id;
	private String name;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DepartmentEntity that = (DepartmentEntity) o;

		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
