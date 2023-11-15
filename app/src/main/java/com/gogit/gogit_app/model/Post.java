package com.gogit.gogit_app.model;

import java.util.Date;
import java.util.List;

public class Post {
    private final Long id;
    private final Member writer;
    private final String content;
    private final List<Comment> comment;
    private final List<Member> likedMembers;
    private final Date createdAt;
    private final Long commentCount;

    public Post(Long id, Member writer, String content, List<Comment> comment, List<Member> likedMembers, Date createdAt, Long commentCount) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.comment = comment;
        this.likedMembers = likedMembers;
        this.createdAt = createdAt;
        this.commentCount = commentCount;
    }

    public Long getId() {
        return id;
    }

    public Member getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public List<Member> getLikedMembers() {
        return likedMembers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", writer=" + writer +
                ", content='" + content + '\'' +
                ", comment=" + comment +
                ", likedMembers=" + likedMembers +
                ", createdAt=" + createdAt +
                ", commentCount=" + commentCount +
                '}';
    }
}
