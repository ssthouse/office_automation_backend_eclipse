package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

import com.ssthouse.officeautomation.util.StringUtil;

/**
 * Created by ssthouse on 14/03/2017.
 */
@Entity
@Table(name = "user", schema = "office_automation", catalog = "")
public class UserEntity {
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_IS_ADMIN = "isAdmin";

	private int id;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String phoneNumber;
	private String description;
	private String department;
	private boolean isAdmin;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "gender", nullable = true, length = 10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Basic
	@Column(name = "phone_number", nullable = true, length = 20)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "department", nullable = true, length = 255)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Basic
	@Column(name = "is_admin", nullable = false, columnDefinition = "TINYINT(1)")
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserEntity that = (UserEntity) o;

		if (id != that.id)
			return false;
		if (isAdmin != that.isAdmin)
			return false;
		if (username != null ? !username.equals(that.username) : that.username != null)
			return false;
		if (password != null ? !password.equals(that.password) : that.password != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (gender != null ? !gender.equals(that.gender) : that.gender != null)
			return false;
		if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null)
			return false;
		if (description != null ? !description.equals(that.description) : that.description != null)
			return false;
		if (department != null ? !department.equals(that.department) : that.department != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (department != null ? department.hashCode() : 0);
		return result;
	}
}
