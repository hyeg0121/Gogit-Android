package com.gogit.gogit_app.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.ui.CreatePostActivity;
import com.gogit.gogit_app.ui.CreateRepoActivity;

public class PostFragment extends Fragment {

    public PostFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_create, container, false);

        // 뷰 가져오기
        Button repositoryCreateButton = view.findViewById(R.id.repositories_create_btn);
        Button postCreateButton = view.findViewById(R.id.post_create_btn);

        repositoryCreateButton.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), CreateRepoActivity.class);
            startActivity(intent);
        });

        postCreateButton.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), CreatePostActivity.class);
            startActivity(intent);
        });

        return view;
    }
}