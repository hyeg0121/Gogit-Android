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
import com.gogit.gogit_app.model.Repository;

import java.util.List;

public class RepoAdapter
        extends RecyclerView.Adapter<RepoAdapter.ItemViewHolder> {

    List<Repository> data;

    public RepoAdapter(List<Repository> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RepoAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.repository, parent, false);

        return new RepoAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        View view = holder.view;

        ImageView profileImageView = view.findViewById(R.id.profile);
        TextView userIdTextView = view.findViewById(R.id.user_id);
        TextView repositoryNameTextView = view.findViewById(R.id.repository_name);
        TextView languageTypeTextView = view.findViewById(R.id.language_type);
        TextView accountForkedTextView = view.findViewById(R.id.account_forked);
        TextView accountStarTextView = view.findViewById(R.id.account_star);

        Repository repo = data.get(position);

        Glide.with(view.getContext())
                .load(repo.getOwner().getAvatar_url())
                .apply(RequestOptions.circleCropTransform())
                .error(R.drawable.git_logo)
                .placeholder(R.drawable.git_logo)
                .into(profileImageView);

        // TODO: lang null 해결하기
        // TODO: 많이 쓰이는 lang 컬러 지정하기
        userIdTextView.setText(repo.getOwner().getLogin());
        repositoryNameTextView.setText(repo.getFull_name());
        languageTypeTextView.setText(repo.getLanguage());
        accountForkedTextView.setText(repo.getFork_count() + "");
        accountStarTextView.setText(repo.getStargazers_count() + "");
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
