package com.gogit.gogit_app.dto;

import java.util.Date;

public class Repository {
    private Member owner;
    private Date updated_at;

    private String name;
    private String language;
    private String visibility;
    private int fork_count;
    private int open_issues;

    public Repository(Member owner, Date updated_at, String name, String language, String visibility, int fork_count, int open_issues) {
        this.owner = owner;
        this.updated_at = updated_at;
        this.name = name;
        this.language = language;
        this.visibility = visibility;
        this.fork_count = fork_count;
        this.open_issues = open_issues;
    }

    public Member getOwner() {
        return owner;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getName() {
        return name;
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
}
