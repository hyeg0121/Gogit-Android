package com.gogit.gogit_app.request;

import com.gogit.gogit_app.model.Member;

public class AddPostRequest {
    private final Member writer;
    private final String content;

    public AddPostRequest(Member writer, String content) {
        this.writer = writer;
        this.content = content;
    }
}
