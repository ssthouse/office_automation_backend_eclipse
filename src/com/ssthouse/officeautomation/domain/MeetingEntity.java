package com.ssthouse.officeautomation.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ssthouse on 17/04/2017.
 */
@Entity
@Table(name = "tools_meeting", schema = "office_automation", catalog = "")
public class MeetingEntity {
	private int id;
	private String sponsor;
	private String hoster;
	private String meetingRoom;
	private String participant;
	private long beginDate;
	private long beginTime;
	private long endTime;
	private String topic;
	private String description;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "sponsor", nullable = false, length = 30)
	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	@Basic
	@Column(name = "hoster", nullable = true, length = 30)
	public String getHoster() {
		return hoster;
	}

	public void setHoster(String hoster) {
		this.hoster = hoster;
	}

	@Basic
	@Column(name = "meeting_room", nullable = false, length = 100)
	public String getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	@Basic
	@Column(name = "participant", nullable = false, length = 1000)
	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
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
	@Column(name = "begin_time", nullable = false)
	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	@Basic
	@Column(name = "end_time", nullable = false)
	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Basic
	@Column(name = "topic", nullable = false, length = 100)
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Basic
	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MeetingEntity that = (MeetingEntity) o;

		if (id != that.id)
			return false;
		if (beginDate != that.beginDate)
			return false;
		if (beginTime != that.beginTime)
			return false;
		if (endTime != that.endTime)
			return false;
		if (sponsor != null ? !sponsor.equals(that.sponsor) : that.sponsor != null)
			return false;
		if (hoster != null ? !hoster.equals(that.hoster) : that.hoster != null)
			return false;
		if (meetingRoom != null ? !meetingRoom.equals(that.meetingRoom) : that.meetingRoom != null)
			return false;
		if (participant != null ? !participant.equals(that.participant) : that.participant != null)
			return false;
		if (topic != null ? !topic.equals(that.topic) : that.topic != null)
			return false;
		if (description != null ? !description.equals(that.description) : that.description != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (sponsor != null ? sponsor.hashCode() : 0);
		result = 31 * result + (hoster != null ? hoster.hashCode() : 0);
		result = 31 * result + (meetingRoom != null ? meetingRoom.hashCode() : 0);
		result = 31 * result + (participant != null ? participant.hashCode() : 0);
		result = 31 * result + (int) (beginDate ^ (beginDate >>> 32));
		result = 31 * result + (int) (beginTime ^ (beginTime >>> 32));
		result = 31 * result + (int) (endTime ^ (endTime >>> 32));
		result = 31 * result + (topic != null ? topic.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}
}
