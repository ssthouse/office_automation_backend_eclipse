package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

import com.ssthouse.officeautomation.domain.base.IWorkflowState;

/**
 * Created by ssthouse on 09/04/2017.
 */
@Entity
@Table(name = "workflow_work_overtime", schema = "office_automation", catalog = "")
public class WorkOvertimeEntity implements IWorkflowState{
    private int id;
    private boolean isHoliday;
    private String beginDate;
    private String endDate;
    private int hourNum;
    private String description;
    private String username;
    private String approverUsername;
    private String state;

    public static final String PROPERTY_USERNME = "username";
    public static final String PROPERTY_APPROVER_USRNAME = "approverUsername";
    public static final String PROPERTY_ID = "id";
    
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_holiday", nullable = false, columnDefinition = "TINYINT(1)")
    public boolean getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    @Basic
    @Column(name = "beginDate", nullable = false, length = 30)
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "endDate", nullable = false, length = 30)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "hourNum", nullable = false)
    public int getHourNum() {
        return hourNum;
    }

    public void setHourNum(int hourNum) {
        this.hourNum = hourNum;
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
    @Column(name = "approverUsername", nullable = false, length = 30)
    public String getApproverUsername() {
        return approverUsername;
    }

    public void setApproverUsername(String approverUsername) {
        this.approverUsername = approverUsername;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkOvertimeEntity that = (WorkOvertimeEntity) o;

        if (id != that.id) return false;
        if (isHoliday != that.isHoliday) return false;
        if (hourNum != that.hourNum) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (approverUsername != null ? !approverUsername.equals(that.approverUsername) : that.approverUsername != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + hourNum;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (approverUsername != null ? approverUsername.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
