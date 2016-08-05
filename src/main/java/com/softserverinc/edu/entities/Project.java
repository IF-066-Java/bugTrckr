package com.softserverinc.edu.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by volodymyr on 8/3/16.
 */
@Entity
@Table(name = "Project")
public class Project implements Serializable  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectManagerId", referencedColumnName = "id", nullable = false)
    private User projectManager;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Release> releases;

    @Column(name = "guestView", nullable = false)
    private boolean guestView;

    @Column(name = "guestCreateIssues", nullable = false)
    private boolean guestCreateIssues;

    @Column(name = "guestAddComment", nullable = false)
    private boolean guestAddComment;

    @Column(name = "description", nullable = true, length = 10000)
    private String description;

    public Project() {
    }

    public Project(String title, User projectManager, boolean guestView, boolean guestCreateIssues, boolean guestAddComment, String description) {
        this.title = title;
        this.projectManager = projectManager;

        this.guestView = guestView;
        this.guestCreateIssues = guestCreateIssues;
        this.guestAddComment = guestAddComment;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGuestView() {
        return guestView;
    }

    public void setGuestView(boolean guestView) {
        this.guestView = guestView;
    }

    public boolean isGuestCreateIssues() {
        return guestCreateIssues;
    }

    public void setGuestCreateIssues(boolean guestCreateIssues) {
        this.guestCreateIssues = guestCreateIssues;
    }

    public boolean isGuestAddComment() {
        return guestAddComment;
    }

    public void setGuestAddComment(boolean guestAddComment) {
        this.guestAddComment = guestAddComment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public Set<Release> getReleases() {
        return releases;
    }

    public void setReleases(Set<Release> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}