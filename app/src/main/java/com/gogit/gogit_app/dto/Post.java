package com.gogit.gogit_app.dto;

import java.util.List;

public class Post {
    private final Long id;
    private final Member writer;
    private final String contents;
    private final List<Comment> comment;
    private final List<Member> likedMembers;

    public Post(Long id, Member writer, String contents, List<Comment> comment, List<Member> likedMembers) {
        this.id = id;
        this.writer = writer;
        this.contents = contents;
        this.comment = comment;
        this.likedMembers = likedMembers;
    }

    public Long getId() {
        return id;
    }

    public Member getWriter() {
        return writer;
    }

    public String getContents() {
        return contents;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public List<Member> getLikedMembers() {
        return likedMembers;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", wrtier=" + writer +
                ", contents='" + contents + '\'' +
                ", comment=" + comment +
                ", likedMembers=" + likedMembers +
                '}';
    }
}
