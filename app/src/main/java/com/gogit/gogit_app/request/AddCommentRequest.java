package com.gogit.gogit_app.request;

public class AddCommentRequest {
    private Long post_id;
    private Long member_id;
    private String content;

    public AddCommentRequest(Long post_id, Long member_id, String content) {
        this.post_id = post_id;
        this.member_id = member_id;
        this.content = content;
    }

    public Long getPost_id() {
        return post_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public String getContent() {
        return content;
    }
}
