package com.gogit.gogit_app.dto;

public class AddPostRequest {
    private final Member wrtier;
    private final String contents;

    public AddPostRequest(Member wrtier, String contents) {
        this.wrtier = wrtier;
        this.contents = contents;
    }
}
