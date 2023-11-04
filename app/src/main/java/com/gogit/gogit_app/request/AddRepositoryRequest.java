package com.gogit.gogit_app.request;

public class AddRepositoryRequest {
    private String name;
    private String description;

    public AddRepositoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
