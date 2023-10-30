package com.gogit.gogit_app.dto;

import java.util.List;

import lombok.ToString;


public class Member {
    private final Long id;
    private final String githubId;
    private final String githubToken;

    public Member(Long id, String githubId, String githubToken, List<Post> likedArticles) {
        this.id = id;
        this.githubId = githubId;
        this.githubToken = githubToken;
    }

    public Long getId() {
        return id;
    }

    public String getGithubId() {
        return githubId;
    }

    public String getGithubToken() {
        return githubToken;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", githubId='" + githubId + '\'' +
                ", githubToken='" + githubToken + '\'' +
                '}';
    }
}
