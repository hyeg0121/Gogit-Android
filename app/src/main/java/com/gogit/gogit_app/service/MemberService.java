package com.gogit.gogit_app.service;

import com.gogit.gogit_app.domain.Member;
import com.gogit.gogit_app.request.MemberSignInRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MemberService {
    @POST("/members")
    Call<Member> createMember(@Body MemberSignInRequest memberSignInRequest);

}
