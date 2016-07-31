package com.softserverinc.edu.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by pasha on 7/30/16.
 */
@Entity
public class WorkLog {
    private int id;
    private int issueId;
    private int userId;
    private Date time;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "issueId")
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkLog workLog = (WorkLog) o;

        if (id != workLog.id) return false;
        if (issueId != workLog.issueId) return false;
        if (userId != workLog.userId) return false;
        if (time != null ? !time.equals(workLog.time) : workLog.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + issueId;
        result = 31 * result + userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
