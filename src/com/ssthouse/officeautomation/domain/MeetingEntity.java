package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

/**
 * Created by ssthouse on 15/04/2017.
 */
@Entity
@Table(name = "tools_meeting", schema = "office_automation", catalog = "")
public class MeetingEntity {
    private int id;
    private String sponsor;
    private String hoster;
    private String topic;
    private String meetingRoom;
    private String participant;
    private String beginDate;
    private String beginTime;
    private String endTime;

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
    @Column(name = "topic", nullable = false, length = 100)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
    @Column(name = "begin_date", nullable = false, length = 50)
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "begin_time", nullable = false, length = 30)
    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false, length = 30)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingEntity that = (MeetingEntity) o;

        if (id != that.id) return false;
        if (sponsor != null ? !sponsor.equals(that.sponsor) : that.sponsor != null) return false;
        if (hoster != null ? !hoster.equals(that.hoster) : that.hoster != null) return false;
        if (meetingRoom != null ? !meetingRoom.equals(that.meetingRoom) : that.meetingRoom != null) return false;
        if (participant != null ? !participant.equals(that.participant) : that.participant != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sponsor != null ? sponsor.hashCode() : 0);
        result = 31 * result + (hoster != null ? hoster.hashCode() : 0);
        result = 31 * result + (meetingRoom != null ? meetingRoom.hashCode() : 0);
        result = 31 * result + (participant != null ? participant.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
