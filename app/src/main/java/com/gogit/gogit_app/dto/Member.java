package com.gogit.gogit_app.dto;


public class Member {
    private Long id;
    private String githubId;
    private String githubToken;

    private String avatarUrl;
    private String htmlUrl;

    public Member() {

    }
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

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public void setGithubToken(String githubToken) {
        this.githubToken = githubToken;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
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
