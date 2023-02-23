package com.hcc.entities;

/*
to implement:
id: Long
status: String
number: Integer
githubUrl: String
branch: String
reviewVideoUrl: String
user: User
codeReviewer: User
AFTER SPRINT 1: unable to add codeReviewer- spoke w/ instructor unclear what causes it to crash
 */

import javax.persistence.*;
import com.hcc.entities.User;

@Entity
@Table(name = "assignments")

public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //do not necessarily need @Column notation if not changing the name


    @Column(name = "status")
    private String status;
    @Column(name = "assignmentnumber")
    private Integer assignmentnumber;
    @Column(name = "githubUrl")
    private String githubUrl;
    @Column(name = "branch")
    private String branch;
    @Column(name = "reviewVideoUrl")
    private String reviewVideoUrl;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne
    private User codeReviewer;

    //made Assignment public to access in Assignment Controller
    public Assignment(){}

    public Assignment(String status, Integer assignmentnumber, String githubUrl, String branch, String reviewVideoUrl, User user, User codeReviewer) {
        this.status = status;
        this.assignmentnumber = assignmentnumber;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
        this.codeReviewer = codeReviewer;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssignmentnumber() {
        return assignmentnumber;
    }

    public void setAssignmentnumber(Integer assignmentnumber) {
        this.assignmentnumber = assignmentnumber;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCodeReviewer() {
        return codeReviewer;
    }

    public void setCodeReviewer(User codeReviewer) {
        this.codeReviewer = codeReviewer;
    }
}
