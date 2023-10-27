package com.gogit.gogit_app.dto;

public class MemberSignInRequest {
    private final String githubId;
    private final String githubToken;

    public MemberSignInRequest(String githubId, String githubToken) {
        this.githubId = githubId;
        this.githubToken = githubToken;
    }

}
