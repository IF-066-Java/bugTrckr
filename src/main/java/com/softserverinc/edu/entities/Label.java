package com.softserverinc.edu.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.*;

/**
 * Created by 37.0 on 02.08.2016.
 */
@Entity(name = "Label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Set<Issue> issueIdSet;

    public Label() {

    }

    public Label(String title, Set<Issue> issueIdSet) {
        this.title = title;
        this.issueIdSet = issueIdSet;
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

    public Set<Issue> getIssueIdSet() {
        if (this.issueIdSet == null) {
            this.issueIdSet = new HashSet<Issue>();
        }
        return this.issueIdSet;
    }

    public void setIssueIdSet(Set<Issue> issueIdSet) {
        this.issueIdSet = issueIdSet;
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
