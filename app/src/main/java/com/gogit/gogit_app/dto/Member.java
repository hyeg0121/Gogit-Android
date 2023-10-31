package com.gogit.gogit_app.dto;


public class Member {
    private final Long id;
    private final String githubId;
    private final String githubToken;

    private String avatarUrl;
    private String htmlUrl;

    public Member(Long id, String githubId, String githubToken) {
        this.id = id;
        this.githubId = githubId;
        this.githubToken = githubToken;
    }

    public Member(Long id, String githubId, String githubToken, String avatarUrl, String htmlUrl) {
        this.id = id;
        this.githubId = githubId;
        this.githubToken = githubToken;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
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
