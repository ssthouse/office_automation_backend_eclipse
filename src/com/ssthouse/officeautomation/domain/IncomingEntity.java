package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ssthouse on 22/04/2017.
 */
@Entity
@Table(name = "official_doc_incoming", schema = "office_automation", catalog = "")
public class IncomingEntity {
	private int id;
	private String owner;
	private String state;
	private long beginDate;
	private long deadline;
	private String type;
	private String title;
	private String targetOrganization;
	private String copyToOrganization;
	private String content;
	private String propose;
	private String approve;
	private String deal;
	private String executors;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "owner", nullable = false, length = 30)
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Basic
	@Column(name = "state", nullable = false, length = 30)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Basic
	@Column(name = "begin_date", nullable = false)
	public long getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(long beginDate) {
		this.beginDate = beginDate;
	}

	@Basic
	@Column(name = "deadline", nullable = false)
	public long getDeadline() {
		return deadline;
	}

	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}

	@Basic
	@Column(name = "type", nullable = false, length = 30)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "target_organization", nullable = false, length = 100)
	public String getTargetOrganization() {
		return targetOrganization;
	}

	public void setTargetOrganization(String targetOrganization) {
		this.targetOrganization = targetOrganization;
	}

	@Basic
	@Column(name = "copy_to_organization", nullable = false, length = 100)
	public String getCopyToOrganization() {
		return copyToOrganization;
	}

	public void setCopyToOrganization(String copyToOrganization) {
		this.copyToOrganization = copyToOrganization;
	}

	@Basic
	@Column(name = "content", nullable = false, length = 3000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "propose", nullable = true, length = 3000)
	public String getPropose() {
		return propose;
	}

	public void setPropose(String propose) {
		this.propose = propose;
	}

	@Basic
	@Column(name = "approve", nullable = true, length = 3000)
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	@Basic
	@Column(name = "deal", nullable = true, length = 3000)
	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	@Basic
	@Column(name = "executors", nullable = false, length = 1000)
	public String getExecutors() {
		return executors;
	}

	public void setExecutors(String executors) {
		this.executors = executors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		IncomingEntity that = (IncomingEntity) o;

		if (id != that.id)
			return false;
		if (beginDate != that.beginDate)
			return false;
		if (deadline != that.deadline)
			return false;
		if (owner != null ? !owner.equals(that.owner) : that.owner != null)
			return false;
		if (state != null ? !state.equals(that.state) : that.state != null)
			return false;
		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (targetOrganization != null ? !targetOrganization.equals(that.targetOrganization)
				: that.targetOrganization != null)
			return false;
		if (copyToOrganization != null ? !copyToOrganization.equals(that.copyToOrganization)
				: that.copyToOrganization != null)
			return false;
		if (content != null ? !content.equals(that.content) : that.content != null)
			return false;
		if (propose != null ? !propose.equals(that.propose) : that.propose != null)
			return false;
		if (approve != null ? !approve.equals(that.approve) : that.approve != null)
			return false;
		if (deal != null ? !deal.equals(that.deal) : that.deal != null)
			return false;
		if (executors != null ? !executors.equals(that.executors) : that.executors != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (owner != null ? owner.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (int) (beginDate ^ (beginDate >>> 32));
		result = 31 * result + (int) (deadline ^ (deadline >>> 32));
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (targetOrganization != null ? targetOrganization.hashCode() : 0);
		result = 31 * result + (copyToOrganization != null ? copyToOrganization.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (propose != null ? propose.hashCode() : 0);
		result = 31 * result + (approve != null ? approve.hashCode() : 0);
		result = 31 * result + (deal != null ? deal.hashCode() : 0);
		result = 31 * result + (executors != null ? executors.hashCode() : 0);
		return result;
	}
}
