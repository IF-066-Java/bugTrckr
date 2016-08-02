package com.softserverinc.edu.entities;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by 37.0 on 02.08.2016.
 */
@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "issueId", referencedColumnName = "id", nullable = false)
    private Issue issueIdById;

    public Label() {

    }

    public Label(String title, Issue issueIdById) {
        this.title = title;
        this.issueIdById = issueIdById;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Issue getIssueById() {
        return issueIdById;
    }

    public void setIssueId(Issue issueIdById) {
        this.issueIdById = issueIdById;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
