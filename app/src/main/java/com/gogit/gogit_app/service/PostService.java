package com.gogit.gogit_app.service;

import com.gogit.gogit_app.model.Comment;
import com.gogit.gogit_app.request.AddPostRequest;
import com.gogit.gogit_app.model.Post;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostService {
    @POST("/posts")
    Call<Map<String, Object>> createdPost(@Body AddPostRequest addPostRequest);

    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @GET("/members/{pk}/posts")
    Call<List<Post>> getMembersAllPosts(
            @Path("pk") Long pk
    );

    @GET("/posts/{postId}")
    Call<Post> getPostById(
            @Path("postId") Long postId
    );

    @GET("/posts/{postId}/comments")
    Call<List<Comment>> getCommentByPostId(
            @Path("postId") Long postId
    );
}
