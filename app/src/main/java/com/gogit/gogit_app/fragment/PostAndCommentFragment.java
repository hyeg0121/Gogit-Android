package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogit.gogit_app.R;
import com.gogit.gogit_app.adapter.CommentAdapter;
import com.gogit.gogit_app.client.PostRetrofitClient;
import com.gogit.gogit_app.model.Comment;
import com.gogit.gogit_app.model.Post;
import com.gogit.gogit_app.service.PostService;
import com.gogit.gogit_app.util.MyToast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostAndCommentFragment extends Fragment {

    private static final String POST_ID = "post_id";

    private Long postId;
    Retrofit retrofit;
    PostService postService;

    ImageView writerProfileImageView;
    TextView writerIdTextView;
    TextView postContentTextView;
    RecyclerView commentRecyclerView;

    public PostAndCommentFragment() {
    }

    public static PostAndCommentFragment newInstance(Long postId) {
        PostAndCommentFragment fragment = new PostAndCommentFragment();
        Bundle args = new Bundle();
        args.putLong(POST_ID, postId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            postId = getArguments().getLong(POST_ID);
        }

        retrofit = PostRetrofitClient.getRetrofitInstance();
        postService = retrofit.create(PostService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.comment_window, container, false);

        writerProfileImageView = view.findViewById(R.id.profileImg);
        writerIdTextView = view.findViewById(R.id.userId);
        postContentTextView = view.findViewById(R.id.write);

        commentRecyclerView = view.findViewById(R.id.comment_recyclerview);
        commentRecyclerView.setHasFixedSize(false);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        showPost(postId);
        showComments(postId);

        return view;
    }

    private void showPost(Long postId) {
        Call<Post> call = postService.getPostById(postId);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.code() == 404) {
                    MyToast.showToast(getContext(), "글을 찾을 수 없습니다");
                } else if (response.code() == 400) {
                    MyToast.showToast(getContext(), "글을 조회 중 에러가 발생했습니다.");
                } else {
                    Post post = response.body();
                    if (post != null) {
                        Glide.with(getView())
                                .load(post.getWriter().getAvatarUrl())
                                .error(R.drawable.git_logo)
                                .apply(RequestOptions.circleCropTransform())
                                .into(writerProfileImageView);

                        writerIdTextView.setText(post.getWriter().getGithubId());
                        postContentTextView.setText(post.getContent());
                    }

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                MyToast.showToast(getContext(), "네트워크가 불안정합니다.");
            }
        });
    }

    private void showComments(Long postId) {
        Call<List<Comment>> call = postService.getCommentByPostId(postId);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.code() == 404) {
                    // 댓글이 없을 때
                } else if (response.code() == 400) {
                    MyToast.showToast(getContext(), "댓글 조회 중 에러가 발생했습니다.");
                } else {
                    List<Comment> comments = response.body();
                    if (comments != null) {
                        Log.d("my tag", comments.toString());
                        commentRecyclerView.setAdapter(new CommentAdapter(comments));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                MyToast.showToast(getContext(), "네트워크가 불안정합니다.");
            }
        });
    }
}