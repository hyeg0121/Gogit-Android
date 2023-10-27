package com.gogit.gogit_app.service;

import com.gogit.gogit_app.dto.Member;
import com.gogit.gogit_app.dto.MemberSignInRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MemberService {
    @POST("/api/members")
    Call<Member> createMember(@Body MemberSignInRequest memberSignInRequest);

}
