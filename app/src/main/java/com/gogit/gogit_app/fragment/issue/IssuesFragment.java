package com.gogit.gogit_app.fragment.issue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.adapter.IssueAdapter;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.model.github.issue.Issue;
import com.gogit.gogit_app.service.GithubService;
import com.gogit.gogit_app.util.MyToast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IssuesFragment extends Fragment {

    Retrofit retrofit;
    GithubService githubService;
    RecyclerView issuesRecyclerView;
    SessionManager sessionManager;
    String token;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.issues, container, false);

        sessionManager = new SessionManager(getContext());

        retrofit = GithubRetrofitClient.getRetrofitInstance();

        githubService = retrofit.create(GithubService.class);

        token = sessionManager.getToken();

        issuesRecyclerView = view.findViewById(R.id.issues_recyclerview);
        issuesRecyclerView.setHasFixedSize(false);
        issuesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        showIssues(token);
        return view;
    }

    private void showIssues(String token) {
        Call<List<Issue>> call = githubService.getUesrsIssues(
                "Bearer " + token);
        call.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                List<Issue> issues = response.body();
                if (issues != null) {
                    issuesRecyclerView.setAdapter(new IssueAdapter(issues));
                    Log.d("my tag", issues.toString());
                } else {
                    MyToast.showToast(getContext(), "이슈가 존재하지 않습니다.");
                }
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
                MyToast.showNetworkErrorToast(getContext());
            }
        });
    }
}