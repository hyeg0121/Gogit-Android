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
import com.gogit.gogit_app.model.GithubUser;


import java.util.List;

public class SearchUserAdapter
        extends RecyclerView.Adapter<SearchUserAdapter.ItemViewHolder> {

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    List<GithubUser> data;

    public SearchUserAdapter(List<GithubUser> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.search_user, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        View view = holder.view;
        GithubUser user = data.get(position);

        ImageView profileImageView = view.findViewById(R.id.profile);
        TextView userIdTextView = view.findViewById(R.id.search_user_id);

        Glide.with(view)
                .load(user.getAvatar_url())
                .error(R.drawable.git_logo)
                .apply(RequestOptions.circleCropTransform())
                .into(profileImageView);


        userIdTextView.setText(user.getLogin());
        
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
