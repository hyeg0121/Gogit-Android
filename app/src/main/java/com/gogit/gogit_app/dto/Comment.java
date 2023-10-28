package com.gogit.gogit_app.dto;

public class Comment {
    private final Long id;
    private final String content;
    private final Member author;
    private final Article article;

    public Comment(Long id, String content, Member author, Article article) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.article = article;
    }
}
