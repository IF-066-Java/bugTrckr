
package com.softserverinc.edu.entities;

import com.softserverinc.edu.entities.enums.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pasha on 8/3/16.
 */

@Entity
@Table(name = "Issues")
public class Issue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "issueStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "createTime", nullable = false)
    private Date createTime;

    @Column(name = "dueTime")
    private Date dueTime;

    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;

    @Column(name = "estimateTime")
    private long estimateTime;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public IssueStatus getIssueStatus() {
        return issueStatus;
    }
    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getDueTime() {
        return dueTime;
    }
    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public long getEstimateTime() {
        return estimateTime;
    }
    public void setEstimateTime(long estimateTime) {
        this.estimateTime = estimateTime;
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