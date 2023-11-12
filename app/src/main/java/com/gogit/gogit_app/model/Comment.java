package com.gogit.gogit_app.model;

public class Comment {
    private Long id;
    private String content;
    private Member author;

    public Comment(Long id, String content, Member author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Member getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}
