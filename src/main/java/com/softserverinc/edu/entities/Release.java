package com.softserverinc.edu.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Stinio on 02.08.2016.
 */

@Entity
@Table(name = "Release")
public class Release implements Serializable  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "projectId", referencedColumnName = "id", nullable = false)
    private Project project;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Issue> issues;

    @Column(name = "version", nullable = false, length = 32)
    private String version;

    @Column(name = "status", nullable = false, length = 25)
    private String status;

    @Column(name = "description", nullable = false, length = 65535)
    private String description;

    public Release() {
    }

    public Release(Project project, Set<Issue> issues, String version, String status, String description) {
        this.project = project;
        this.issues = issues;
        this.version = version;
        this.status = status;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
