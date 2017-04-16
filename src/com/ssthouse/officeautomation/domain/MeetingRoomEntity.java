package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ssthouse on 16/04/2017.
 */
@Entity
@Table(name = "tools_meeting_room", schema = "office_automation", catalog = "")
public class MeetingRoomEntity {
	private int id;
	private String name;
	private int capacity;
	private String asset;

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

	@Basic
	@Column(name = "capacity", nullable = false)
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Basic
	@Column(name = "asset", nullable = false, length = 1000)
	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MeetingRoomEntity that = (MeetingRoomEntity) o;

		if (id != that.id)
			return false;
		if (capacity != that.capacity)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (asset != null ? !asset.equals(that.asset) : that.asset != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + capacity;
		result = 31 * result + (asset != null ? asset.hashCode() : 0);
		return result;
	}
}
