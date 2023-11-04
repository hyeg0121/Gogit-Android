package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.Member;
import com.gogit.gogit_app.dto.MemberSignInRequest;
import com.gogit.gogit_app.dto.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MemberService {
    @POST("/members")
    Call<Member> createMember(@Body MemberSignInRequest memberSignInRequest);

}
