package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Created by ssthouse on 03/04/2017.
 */
@Entity
@Table(name = "vote_option", schema = "office_automation", catalog = "")
public class VoteOptionEntity {
	
	public static final String PROPERTY_VOTING_ID = "votingId";
	
	private int id;
	private int votingId;
	private String title;
	private int sum;
	
	public VoteOptionEntity() {
		this.id = 1;
		this.votingId = 1;
		this.title = "";
		this.sum = 1;
	}

	@Expose
	@ManyToOne
	@JoinColumn(name = "voting_id")
	private VotingEntity votingEntity;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "voting_id", nullable = false)
	public int getVotingId() {
		return votingId;
	}

	public void setVotingId(int votingId) {
		this.votingId = votingId;
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
	@Column(name = "sum", nullable = false)
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		VoteOptionEntity that = (VoteOptionEntity) o;

		if (id != that.id)
			return false;
		if (votingId != that.votingId)
			return false;
		if (sum != that.sum)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + votingId;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + sum;
		return result;
	}
}
