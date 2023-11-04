package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.MemberRetrofitClient;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.request.AddPostRequest;
import com.gogit.gogit_app.model.Member;
import com.gogit.gogit_app.model.Post;
import com.gogit.gogit_app.service.PostService;
import com.gogit.gogit_app.util.MyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreatePostFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_post, container, false);

        // sesstion manager
        SessionManager sessionManager = new SessionManager(getContext());
        Log.d("my tag", sessionManager.getToken());
        Log.d("my tag", sessionManager.getUserId());

        // view
        EditText contentEditText = view.findViewById(R.id.content_edittext);
        Button uploadButton = view.findViewById(R.id.upload_button);

        // retrofit
        Retrofit retrofit = MemberRetrofitClient.getRetrofitInstance();
        PostService postService = retrofit.create(PostService.class);

        uploadButton.setOnClickListener(e -> {
            String content = contentEditText.getText().toString();
            Log.d("my tag", sessionManager.getPk().toString());

            Member writer = new Member(
                    sessionManager.getPk(),
                    sessionManager.getUserId(),
                    sessionManager.getToken());

            Log.d("my tag", writer.toString());


            AddPostRequest addPostRequest = new AddPostRequest(writer, content);

            Call<Post> call = postService.createdPost(addPostRequest);

            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    Post post = response.body();
                    Log.d("my tag", post.toString());
                    // 프래그먼트 트랜잭션 시작
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    // Follower 프래그먼트를 생성하고 추가
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.containers, homeFragment);
                    transaction.addToBackStack(null); // 이전 상태를 백 스택에 추가

                    // 트랜잭션 커밋
                    transaction.commit();
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Log.d("my tag", "onFailure: " + t.getMessage());
                    MyToast.showToast(getContext(), "네트워크 에러 발생");
                }
            });

        });

        return view;
    }
}