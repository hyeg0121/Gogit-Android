package com.gogit.gogit_app.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogit.gogit_app.R;
import com.gogit.gogit_app.dto.Post;

import java.util.List;

public class PostAdapter
        extends RecyclerView.Adapter<PostAdapter.ItemViewHolder> {

    List<Post> data;

    public PostAdapter(List<Post> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater
               .from(parent.getContext())
               .inflate(R.layout.post, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        View view = holder.view;

        // 뷰 가져오기
        ImageView profileImageView = view.findViewById(R.id.profileImg);
        TextView userIdTextView = view.findViewById(R.id.userId);
        TextView contentTextView = view.findViewById(R.id.write);
        TextView commentCount = view.findViewById(R.id.comment_count);
        TextView likeCount = view.findViewById(R.id.heart_count);

        // 데이터
        Post post = data.get(position);

        Glide.with(view.getContext())
                .load(post.getWriter().getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .error(R.drawable.git_logo)
                .placeholder(R.drawable.git_logo)
                .into(profileImageView);

        if (post.getWriter() != null) {
            userIdTextView.setText(post.getWriter().getGithubId());
        } else {
            Log.d("my tag", post.toString());
        }
        contentTextView.setText(post.getContents());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ItemViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

}
