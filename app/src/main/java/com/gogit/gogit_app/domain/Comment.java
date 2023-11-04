package com.gogit.gogit_app.domain;

public class Comment {
    private final Long id;
    private final String content;
    private final Member author;
    private final Post post;

    public Comment(Long id, String content, Member author, Post post) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.post = post;
    }
}
