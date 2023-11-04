package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.AddPostRequest;
import com.gogit.gogit_app.dto.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostService {
    @POST("/posts")
    Call<Post> createdPost(@Body AddPostRequest addPostRequest);

    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @GET("/posts/member/{pk}")
    Call<List<Post>> getMembersAllPosts(
            @Path("pk") Long pk
    );
}
