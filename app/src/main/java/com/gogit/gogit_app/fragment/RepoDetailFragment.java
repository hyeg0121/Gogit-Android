package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.config.SessionManager;

public class RepoDetailFragment extends Fragment {
    private static final String REPO_NAME = "repo_name";
    private String repoName;
    private String login;
    private String token;

    public RepoDetailFragment() {}

    public static RepoDetailFragment newInstance(String repoName) {
        RepoDetailFragment fragment = new RepoDetailFragment();
        Bundle args = new Bundle();
        args.putString(REPO_NAME, repoName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            repoName = getArguments().getString(REPO_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repository_commit, container, false);

        SessionManager sessionManager = new SessionManager(getContext());
        login = sessionManager.getUserId();
        token = sessionManager.getToken();

        Log.d("my tag", repoName);

        return view;
    }
}