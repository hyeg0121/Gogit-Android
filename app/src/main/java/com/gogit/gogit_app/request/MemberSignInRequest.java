package com.gogit.gogit_app.request;

public class MemberSignInRequest {
    private final String githubId;
    private final String githubToken;
    private final String avatarUrl;
    private final String htmlUrl;

    public MemberSignInRequest(String githubId, String githubToken, String avatarUrl, String htmlUrl) {
        this.githubId = githubId;
        this.githubToken = githubToken;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

}
