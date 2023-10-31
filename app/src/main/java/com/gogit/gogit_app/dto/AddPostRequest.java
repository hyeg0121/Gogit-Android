package com.gogit.gogit_app.dto;

public class AddPostRequest {
    private final Member writer;
    private final String contents;

    public AddPostRequest(Member writer, String contents) {
        this.writer = writer;
        this.contents = contents;
    }
}
