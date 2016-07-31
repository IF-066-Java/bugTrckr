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
public class Issue {
    private int id;
    private String title;
    private String type;
    private String priority;
    private Date createTime;
    private Date dueDate;
    private Date lastUpdateDate;
    private int estimateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "dueDate")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "lastUpdateDate")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "estimateTime")
    public int getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != issue.id) return false;
        if (estimateTime != issue.estimateTime) return false;
        if (title != null ? !title.equals(issue.title) : issue.title != null) return false;
        if (type != null ? !type.equals(issue.type) : issue.type != null) return false;
        if (priority != null ? !priority.equals(issue.priority) : issue.priority != null) return false;
        if (createTime != null ? !createTime.equals(issue.createTime) : issue.createTime != null) return false;
        if (dueDate != null ? !dueDate.equals(issue.dueDate) : issue.dueDate != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(issue.lastUpdateDate) : issue.lastUpdateDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + estimateTime;
        return result;
    }
}
