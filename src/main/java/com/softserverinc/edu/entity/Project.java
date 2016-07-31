package com.softserverinc.edu.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pasha on 7/30/16.
 */
@Entity
public class Project {
    private int id;
    private String title;
    private byte guestView;
    private byte guestCreateIssues;
    private byte guestAddComment;

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
    @Column(name = "guestView")
    public byte getGuestView() {
        return guestView;
    }

    public void setGuestView(byte guestView) {
        this.guestView = guestView;
    }

    @Basic
    @Column(name = "guestCreateIssues")
    public byte getGuestCreateIssues() {
        return guestCreateIssues;
    }

    public void setGuestCreateIssues(byte guestCreateIssues) {
        this.guestCreateIssues = guestCreateIssues;
    }

    @Basic
    @Column(name = "guestAddComment")
    public byte getGuestAddComment() {
        return guestAddComment;
    }

    public void setGuestAddComment(byte guestAddComment) {
        this.guestAddComment = guestAddComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (guestView != project.guestView) return false;
        if (guestCreateIssues != project.guestCreateIssues) return false;
        if (guestAddComment != project.guestAddComment) return false;
        if (title != null ? !title.equals(project.title) : project.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (int) guestView;
        result = 31 * result + (int) guestCreateIssues;
        result = 31 * result + (int) guestAddComment;
        return result;
    }
}
