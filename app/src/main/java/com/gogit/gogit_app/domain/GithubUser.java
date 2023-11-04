package com.gogit.gogit_app.domain;

public class GithubUser {
    private String login;
    private String avatar_url;
    private String name;
    private String email;
    private int public_repos;
    private int followers;
    private int following;

    private int total_private_repos;

    @Override
    public String toString() {
        return "GithubUser{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", public_repos=" + public_repos +
                ", followers=" + followers +
                ", following=" + following +
                ", total_private_repos=" + total_private_repos +
                '}';
    }


    public int getTotal_private_repos() {
        return total_private_repos;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

}
