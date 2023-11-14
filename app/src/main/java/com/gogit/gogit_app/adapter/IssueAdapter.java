package com.gogit.gogit_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.model.github.issue.Issue;

import java.util.List;

public class IssueAdapter
        extends RecyclerView.Adapter<IssueAdapter.ItemViewHolder> {

    List<Issue> data;

    public IssueAdapter(List<Issue> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.issues_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueAdapter.ItemViewHolder holder, int position) {
        View view = holder.view;
        Issue issue = data.get(position);

        TextView issueAddressTextView = view.findViewById(R.id.issues_address);
        TextView issueTitleTextView = view.findViewById(R.id.issues_title);

        issueAddressTextView.setText(issue.getRepository().getFull_name());
        issueTitleTextView.setText(issue.getTitle());
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
