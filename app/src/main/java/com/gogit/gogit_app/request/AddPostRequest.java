package com.gogit.gogit_app.request;

import com.gogit.gogit_app.model.Member;

public class AddPostRequest {
    private final Long writer;
    private final String content;

    public AddPostRequest(Long writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddPostRequest{" +
                "writer=" + writer +
                ", content='" + content + '\'' +
                '}';
    }
}
