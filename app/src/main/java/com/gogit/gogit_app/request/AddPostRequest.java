package com.gogit.gogit_app.request;

import com.gogit.gogit_app.domain.Member;

public class AddPostRequest {
    private final Member writer;
    private final String contents;

    public AddPostRequest(Member writer, String contents) {
        this.writer = writer;
        this.contents = contents;
    }
}
