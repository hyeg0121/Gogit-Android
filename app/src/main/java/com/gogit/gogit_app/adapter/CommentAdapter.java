package com.gogit.gogit_app.adapter;

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
import com.gogit.gogit_app.model.Comment;

import java.util.List;

public class CommentAdapter
    extends RecyclerView.Adapter<CommentAdapter.ItemViewHolder> {

    List<Comment> data;

    public CommentAdapter(List<Comment> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CommentAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.comment_user, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ItemViewHolder holder, int position) {
        View view = holder.view;
        Comment comment = data.get(position);

        ImageView otherProfileImageView = view.findViewById(R.id.other_profile);
        TextView userIdTextView = view.findViewById(R.id.userId);
        TextView contentTextView = view.findViewById(R.id.write);

        Glide.with(view)
                .load(comment.getAuthor().getAvatarUrl())
                .error(R.drawable.git_logo)
                .apply(RequestOptions.circleCropTransform())
                .into(otherProfileImageView);

        userIdTextView.setText(comment.getAuthor().getGithubId());
        contentTextView.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
