package com.gogit.gogit_app.dto;

public class AddRepositoryRequest {
    private String name;
    private String description;

    public AddRepositoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}