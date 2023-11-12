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
import com.gogit.gogit_app.model.github.user.GithubUser;

import java.util.List;

public class FollowerAdapter
        extends RecyclerView.Adapter<FollowerAdapter.ItemViewHolder> {

    List<GithubUser> data;

    public FollowerAdapter(List<GithubUser> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.follower_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        View view = holder.view;
        ImageView profile = view.findViewById(R.id.user_profile);
        TextView name = view.findViewById(R.id.user_name);
        TextView id = view.findViewById(R.id.user_id);

        GithubUser user = data.get(position);

        Glide.with(view.getContext())
                .load(user.getAvatar_url())
                .placeholder(R.drawable.git_logo)
                .error(R.drawable.git_logo)
                .apply(RequestOptions.circleCropTransform())
                .into(profile);
        name.setText(user.getName());
        id.setText(user.getLogin());
        // TODO: 팔로우 취소 버튼 생성

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
