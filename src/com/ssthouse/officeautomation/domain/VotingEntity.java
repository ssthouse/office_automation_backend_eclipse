package com.ssthouse.officeautomation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ssthouse.officeautomation.util.StringUtil;

/**
 * Created by ssthouse on 03/04/2017.
 */
@Entity
@Table(name = "voting", schema = "office_automation", catalog = "")
public class VotingEntity {
	public static final String PROPERTY_CREATER_ID = "createrId";
	public static final String PROPERTY_VOTING_ID = "votingId";

	private int votingId;
	private String createrId;
	private String title;
	private String description;
	private String deadline;
	private boolean published;
	private boolean multipleChoice;
	
	private List<VoteOptionEntity> voteOptions = new ArrayList<VoteOptionEntity>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "votingId", targetEntity = VoteOptionEntity.class, cascade = { CascadeType.ALL })
	public List<VoteOptionEntity> getVoteOptions() {
		return voteOptions;
	}

	public void setVoteOptions(List<VoteOptionEntity> voteOptions) {
		this.voteOptions = voteOptions;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voting_id", nullable = false)
	public int getVotingId() {
		return votingId;
	}

	public void setVotingId(int votingId) {
		this.votingId = votingId;
	}

	@Basic
	@Column(name = "creater_id", nullable = false, length = 20)
	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
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
	@Column(name = "description", nullable = true, length = 1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "deadline", nullable = false, length = 30)
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Basic
	@Column(name="multiple_choice", nullable = false, columnDefinition = "TINYINT(1)")
	public boolean getMultipleChoice(){
		return multipleChoice;
	}
	
	public void setMultipleChoice(boolean multipleChoice){
		this.multipleChoice = multipleChoice;
	}
	
	@Basic
	@Column(name="published", nullable = false, columnDefinition = "TINYINT(1)")
	public boolean getPublished(){
		return published;
	}
	
	public void setPublished(boolean published){
		this.published = published;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		VotingEntity that = (VotingEntity) o;

		if (votingId != that.votingId)
			return false;
		if (createrId != null ? !createrId.equals(that.createrId) : that.createrId != null)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (description != null ? !description.equals(that.description) : that.description != null)
			return false;
		if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = votingId;
		result = 31 * result + (createrId != null ? createrId.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
		return result;
	}

	@Transient
	public boolean isValid() {
		if (StringUtil.isEmpty(createrId, title, deadline)) {
			return false;
		}
		return true;
	}
}
