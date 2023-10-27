package com.gogit.gogit_app.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {
    private final Long id;
    private final String githubId;
    private final String githubToken;
    private final List<Article> likedArticles;

    public Member(Long id, String githubId, String githubToken, List<Article> likedArticles) {
        this.id = id;
        this.githubId = githubId;
        this.githubToken = githubToken;
        this.likedArticles = likedArticles;
    }
}
