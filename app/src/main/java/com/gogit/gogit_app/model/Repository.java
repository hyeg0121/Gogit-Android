package com.gogit.gogit_app.model;

import java.util.Date;

public class Repository {
    private GithubUser owner;
    private Date updated_at;

    private String full_name;
    private String language;
    private String visibility;
    private int fork_count;
    private int open_issues;

    private int stargazers_count;


    public Repository(GithubUser owner, Date updated_at, String full_name, String language, String visibility, int fork_count, int open_issues, int stargazers_count) {
        this.owner = owner;
        this.updated_at = updated_at;
        this.full_name = full_name;
        this.language = language;
        this.visibility = visibility;
        this.fork_count = fork_count;
        this.open_issues = open_issues;
        this.stargazers_count = stargazers_count;
    }

    public GithubUser getOwner() {
        return owner;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getLanguage() {
        return language;
    }

    public String getVisibility() {
        return visibility;
    }

    public int getFork_count() {
        return fork_count;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "owner=" + owner +
                ", updated_at=" + updated_at +
                ", full_name='" + full_name + '\'' +
                ", language='" + language + '\'' +
                ", visibility='" + visibility + '\'' +
                ", fork_count=" + fork_count +
                ", open_issues=" + open_issues +
                ", stargazers_count=" + stargazers_count +
                '}';
    }
}
