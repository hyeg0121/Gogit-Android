package com.gogit.gogit_app.model.github.issue;

import com.gogit.gogit_app.model.github.repo.Repository;
import com.gogit.gogit_app.model.github.user.GithubUser;

public class Issue {
    private Long number;
    private String title;
    private String state;
    private GithubUser user;
    private Repository repository;
    private String body;

    public Issue(Long number, String title, String state, GithubUser user, Repository repository, String body) {
        this.number = number;
        this.title = title;
        this.state = state;
        this.user = user;
        this.repository = repository;
        this.body = body;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public GithubUser getUser() {
        return user;
    }

    public void setUser(GithubUser user) {
        this.user = user;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", repository=" + repository +
                ", body='" + body + '\'' +
                '}';
    }
}
