package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.adapter.FollowerAdapter;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.config.Config;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.dto.GithubUser;
import com.gogit.gogit_app.service.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FollowerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follower);
        // 로그인 정보 가져오기
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        String login = sessionManager.getUserId();

        // 이전 버튼 액션 리스너
        ImageButton prevButton = findViewById(R.id.prev_button);
        prevButton.setOnClickListener(e -> {
            Intent intent = new Intent(getApplicationContext(), MemberMainActivity.class);
            startActivity(intent);
        });


        Retrofit githubRetrofit = GithubRetrofitClient.getRetrofitInstance();
        GithubService githubService = githubRetrofit.create(GithubService.class);

        RecyclerView followerView = findViewById(R.id.follow_list);
        followerView.setHasFixedSize(false);
        followerView.setLayoutManager(new LinearLayoutManager(this));


        Call<List<GithubUser>> call = githubService.getFollowers(
                "Bearer " + Config.GITHUB_TOKEN, login);

        call.enqueue(new Callback<List<GithubUser>>() {

            @Override
            public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response) {
                if (response.code() != 404) {
                    List<GithubUser> githubUsers = response.body();

                    followerView.setAdapter(new FollowerAdapter(githubUsers));
                }
            }

            @Override
            public void onFailure(Call<List<GithubUser>> call, Throwable t) {
                Log.d("my tag", t.getMessage());
            }
        });



    }
}