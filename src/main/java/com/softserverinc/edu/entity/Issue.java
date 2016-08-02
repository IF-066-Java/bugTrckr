package com.softserverinc.edu.entity;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}