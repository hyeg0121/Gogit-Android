package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogit.gogit_app.R;
import com.gogit.gogit_app.adapter.PostAdapter;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.client.RetrofitClient;
import com.gogit.gogit_app.config.Config;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.dto.GithubUser;
import com.gogit.gogit_app.dto.Post;
import com.gogit.gogit_app.service.GithubService;
import com.gogit.gogit_app.service.MemberService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyPageFragment extends Fragment {


    public MyPageFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        SessionManager sessionManager = new SessionManager(getContext());

        TextView userIdTextView = view.findViewById(R.id.userId);
        ImageView profileImageView = view.findViewById(R.id.profileImg);
        TextView repoTextview = view.findViewById(R.id.account_repositories);
        TextView followerTextView = view.findViewById(R.id.account_follower);
        TextView usernameTextView = view.findViewById(R.id.userName);
        LinearLayout followerLayout = view.findViewById(R.id.follower_layout);
        followerLayout.setOnClickListener(e -> {
            // 프래그먼트 트랜잭션 시작
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Follower 프래그먼트를 생성하고 추가
            FollowerFragment followerFragment = new FollowerFragment();
            transaction.replace(R.id.containers, followerFragment);
            transaction.addToBackStack(null); // 이전 상태를 백 스택에 추가

            // 트랜잭션 커밋
            transaction.commit();
        });


        // 레트로핏
        Retrofit githubRetrofit = GithubRetrofitClient.getRetrofitInstance();

        GithubService githubService = githubRetrofit.create(GithubService.class);
        String login = sessionManager.getUserId();
        Call<GithubUser> userCall = githubService.getUser(
                "Bearer " + Config.GITHUB_TOKEN, login);


        // 유저 정보
        userCall.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                if (response.code() == 404) {

                } else {
                    GithubUser user = (GithubUser) response.body();
                    Log.d("my tag", user.toString());
                    if (user != null) {
                        userIdTextView.setText(user.getLogin());
                        usernameTextView.setText(user.getName());
                        Glide.with(getContext())
                                .load(user.getAvatar_url())
                                .apply(RequestOptions.circleCropTransform())
                                .error(R.drawable.git_logo)
                                .placeholder(R.drawable.git_logo)
                                .into(profileImageView);
                        repoTextview.setText((user.getPublic_repos() + user.getTotal_private_repos()) + "");
                        followerTextView.setText(user.getFollowers() + "");

                    }
                }
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Log.d("my tag", t.getMessage());
            }
        });

        // 글 정보 불러오기
        RecyclerView postsView = view.findViewById(R.id.post_recyclerview);
        postsView.setHasFixedSize(false);
        postsView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
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