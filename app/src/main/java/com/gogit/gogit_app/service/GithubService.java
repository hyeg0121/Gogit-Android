package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{username}")
    Call<GithubUser> getUser(
            @Header("Authorization") String auth,
            @Path("username") String username
    );
}
