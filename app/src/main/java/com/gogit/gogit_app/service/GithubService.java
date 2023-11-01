package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.GithubUser;
import com.gogit.gogit_app.dto.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{login}")
    Call<GithubUser> getUser(
            @Header("Authorization") String auth,
            @Path("login") String username
    );

    @GET("users/{login}/followers")
    Call<List<GithubUser>> getFollowers(
            @Header("Authorization") String auth,
            @Path("login") String username
    );

    @GET("users/{login}/repos")
    Call<List<Repository>> getRepos(
            @Header("Authorization") String auth,
            @Path("login") String username
    );
}
