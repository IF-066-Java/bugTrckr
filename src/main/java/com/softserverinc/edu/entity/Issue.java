package com.softserverinc.edu.entity;

<<<<<<< HEAD
import com.softserverinc.edu.entity.enums.IssueProperty;
import com.softserverinc.edu.entity.enums.IssueStatus;
import com.softserverinc.edu.entity.enums.IssueType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pasha on 8/2/16.
 */

@Entity
@Table
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false, length = 25)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueType issueType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private IssueProperty issueProperty;

    @Column( nullable = false)
    private Date createIssueTime;

    @Column
    private Date dueIssueTime;

    @Column
    private Date lastUpdateIssueTime;

    @Column
    private long estimateIssueTime;

=======
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
>>>>>>> 37bd1f369849fe0bebae0f58bbd841f60fd81a29
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

<<<<<<< HEAD
    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public IssueProperty getIssueProperty() {
        return issueProperty;
    }

    public void setIssueProperty(IssueProperty issueProperty) {
        this.issueProperty = issueProperty;
    }

    public Date getCreateIssueTime() {
        return createIssueTime;
    }

    public void setCreateIssueTime(Date createIssueTime) {
        this.createIssueTime = createIssueTime;
    }

    public Date getDueIssueTime() {
        return dueIssueTime;
    }

    public void setDueIssueTime(Date dueIssueTime) {
        this.dueIssueTime = dueIssueTime;
    }

    public Date getLastUpdateIssueTime() {
        return lastUpdateIssueTime;
    }

    public void setLastUpdateIssueTime(Date lastUpdateIssueTime) {
        this.lastUpdateIssueTime = lastUpdateIssueTime;
    }

    public long getEstimateIssueTime() {
        return estimateIssueTime;
    }

    public void setEstimateIssueTime(long estimateIssueTime) {
        this.estimateIssueTime = estimateIssueTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
=======
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
>>>>>>> 37bd1f369849fe0bebae0f58bbd841f60fd81a29
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
=======
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
>>>>>>> 37bd1f369849fe0bebae0f58bbd841f60fd81a29
