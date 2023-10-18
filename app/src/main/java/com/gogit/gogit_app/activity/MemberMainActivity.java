package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.config.Config;
import com.gogit.gogit_app.dto.GithubUser;
import com.gogit.gogit_app.service.ApiService;
import com.gogit.gogit_app.service.GithubService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MemberMainActivity extends AppCompatActivity {


    String myToken = "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";
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user);

        TextView userIdTextView = findViewById(R.id.userId);
        ImageView profileImageView = findViewById(R.id.profileImg);
        TextView repoTextview = findViewById(R.id.account_repositories);
        TextView followerTextView = findViewById(R.id.account_follower);
        TextView followingTextView = findViewById(R.id.account_following);
        TextView usernameTextView = findViewById(R.id.userName);
        ImageButton[] organizationButtons = {
                findViewById(R.id.organization),
                findViewById(R.id.organization2),
                findViewById(R.id.organization3)
        };

        Retrofit githubRetrofit = GithubRetrofitClient.getRetrofitInstance();
        GithubService githubService = githubRetrofit.create(GithubService.class);

        String username = "hyeg0121";
        Call<GithubUser> call = githubService.getUser(
                "Bearer " + Config.GITHUB_TOKEN, username);

        call.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                if (response.code() == 404) {

                } else {
                    GithubUser user = (GithubUser) response.body();
                    Log.d("my tag", user.toString());
                    if (user != null) {
                        userIdTextView.setText(user.getLogin());
                        usernameTextView.setText(user.getName());
                        Glide.with(MemberMainActivity.this)
                                .load(user.getAvatar_url())
                                .apply(RequestOptions.circleCropTransform())
                                .error(R.drawable.git_logo)
                                .placeholder(R.drawable.git_logo)
                                .into(profileImageView);
                        repoTextview.setText(user.getPublic_repos() + "");
                        // TODO: 프라이빗도 가져오기
                        followerTextView.setText(user.getFollowers() + "");
                        followingTextView.setText(user.getFollowing() + "");
                    }
                }
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Log.d("my tag", t.getMessage());
            }
        });
    }
}