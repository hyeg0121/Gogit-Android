package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.GithubRetrofitClient;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.request.AddRepositoryRequest;
import com.gogit.gogit_app.service.GithubService;
import com.gogit.gogit_app.util.FragmentHelper;
import com.gogit.gogit_app.util.MyToast;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CreateRepoFragment extends Fragment {

    GithubService githubService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_repository, container, false);

        SessionManager sessionManager = new SessionManager(getContext());
        String userId = sessionManager.getUserId();
        String token = sessionManager.getToken();

        EditText nameEditText = view.findViewById(R.id.name_editText);
        EditText descEditText = view.findViewById(R.id.desc_editText);
        Button uploadButton = view.findViewById(R.id.upload_button);

        Retrofit githubRetrofit = GithubRetrofitClient.getRetrofitInstance();
        githubService = githubRetrofit.create(GithubService.class);

        uploadButton.setOnClickListener(e -> {
            // TODO: 빈 칸일 떄 유효성 검사
            String name = nameEditText.getText().toString();
            String description = descEditText.getText().toString();

            AddRepositoryRequest addRepositoryRequest = new AddRepositoryRequest(name, description);

            Call<Map<String, Object>> createRepoCall = githubService.createRepo(
                    "Bearer " + token,
                    addRepositoryRequest);

            createRepoCall.enqueue(new Callback<Map<String, Object>>() {
                @Override
                public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                    // TODO: 리포지토리 목록 나열할 페이지 만들기
                    FragmentHelper.replaceFragment(getFragmentManager(), R.id.containers, new MyPageFragment());
                }

                @Override
                public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                    MyToast.showToast(getContext(), "네트워크가 불안정합니다.");
                }
            });

        });

        return view;
    }
}