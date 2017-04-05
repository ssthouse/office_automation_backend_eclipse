package com.ssthouse.officeautomation.controller.workflow;

import javax.persistence.*;

/**
 * Created by ssthouse on 05/04/2017.
 */
@Entity
@Table(name = "workflow_ask_leave", schema = "office_automation", catalog = "")
public class AskLeaveEntity {
    private int id;
    private String leaveType;
    private String beginDate;
    private String endDate;
    private int dayNum;
    private String description;
    private String username;
    private String approverUsername;
    private String state;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "leave_type", nullable = false, length = 30)
    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Basic
    @Column(name = "begin_date", nullable = false, length = 30)
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false, length = 30)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "day_num", nullable = false)
    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "approver_username", nullable = false, length = 30)
    public String getApproverUsername() {
        return approverUsername;
    }

    public void setApproverUsername(String approverUsername) {
        this.approverUsername = approverUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AskLeaveEntity that = (AskLeaveEntity) o;

        if (id != that.id) return false;
        if (dayNum != that.dayNum) return false;
        if (leaveType != null ? !leaveType.equals(that.leaveType) : that.leaveType != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (approverUsername != null ? !approverUsername.equals(that.approverUsername) : that.approverUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (leaveType != null ? leaveType.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + dayNum;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (approverUsername != null ? approverUsername.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 30)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
