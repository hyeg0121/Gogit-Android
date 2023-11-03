package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.adapter.PostAdapter;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.client.MemberRetrofitClient;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.dto.Post;
import com.gogit.gogit_app.service.MemberService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        SessionManager sessionManager = new SessionManager(getContext());

        Retrofit githubRetrofit = GithubRetrofitClient.getRetrofitInstance();

        // 글 정보 불러오기
        RecyclerView postsView = view.findViewById(R.id.post_recyclerview);
        postsView.setHasFixedSize(false);
        postsView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = MemberRetrofitClient.getRetrofitInstance();
        MemberService memberService = retrofit.create(MemberService.class);
        Call<List<Post>> postListCall = memberService.getPostByWriterId(sessionManager.getPk());
        postListCall.enqueue(new Callback<List<Post>>(){

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code() != 404) {
                    List<Post> posts = response.body();
                    postsView.setAdapter(new PostAdapter(posts));
                    Log.d("my tag", posts.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("my tag", t.getMessage());
            }
        });
        return view;
    }
}