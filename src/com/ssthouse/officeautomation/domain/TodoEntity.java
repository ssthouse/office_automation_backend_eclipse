package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ssthouse.officeautomation.util.StringUtil;

/**
 * Created by ssthouse on 25/05/2017.
 */
@Entity
@Table(name = "todo", schema = "office_automation", catalog = "")
public class TodoEntity {
	private int id;
	private String creater;
	private String content;
	private long time;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "creater", nullable = false, length = 30)
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Basic
	@Column(name = "content", nullable = false, length = 300)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "time", nullable = false)
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TodoEntity that = (TodoEntity) o;

		if (id != that.id)
			return false;
		if (time != that.time)
			return false;
		if (content != null ? !content.equals(that.content) : that.content != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (int) (time ^ (time >>> 32));
		return result;
	}

	@Transient
	public boolean isValid() {
		if (StringUtil.isEmpty(content)) {
			return false;
		}
		return true;
	}
}
