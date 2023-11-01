package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.AddPostRequest;
import com.gogit.gogit_app.dto.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostService {
    @POST("/posts")
    Call<Post> createdPost(@Body AddPostRequest addPostRequest);
}
