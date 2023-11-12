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
import com.gogit.gogit_app.model.github.repo.Repository;

import java.util.List;

public class SearchRepoAdapter
        extends RecyclerView.Adapter<SearchRepoAdapter.ItemViewHolder> {


    class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    List<Repository> data;

    public SearchRepoAdapter(List<Repository> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.search_repository, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        View view = holder.view;
        Repository repo = data.get(position);

        ImageView profileImageView = view.findViewById(R.id.profile);
        TextView userIdTextView = view.findViewById(R.id.user_id);
        TextView repositoryNameTextView = view.findViewById(R.id.repository_name);
        TextView languageTypeTextView = view.findViewById(R.id.language_type);
        TextView accountForkedTextView = view.findViewById(R.id.account_forked);
        TextView accountStarTextView = view.findViewById(R.id.account_star);

        Glide.with(view)
                .load(repo.getOwner().getAvatar_url())
                .error(R.drawable.git_logo)
                .apply(RequestOptions.circleCropTransform())
                .into(profileImageView);
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


}
