package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gogit.gogit_app.R;

public class PostFragment extends Fragment {

    public PostFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_create, container, false);

        // 뷰 가져오기
        Button repositoryCreateButton = view.findViewById(R.id.repositories_create_btn);
        Button postCreateButton = view.findViewById(R.id.post_create_btn);

        repositoryCreateButton.setOnClickListener(e -> {
            // 프래그먼트 트랜잭션 시작
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Follower 프래그먼트를 생성하고 추가
            CreateRepoFragment createRepoFragment = new CreateRepoFragment();
            transaction.replace(R.id.containers, createRepoFragment);
            transaction.addToBackStack(null); // 이전 상태를 백 스택에 추가

            // 트랜잭션 커밋
            transaction.commit();
        });

        postCreateButton.setOnClickListener(e -> {
            // 프래그먼트 트랜잭션 시작
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Follower 프래그먼트를 생성하고 추가
            CreatePostFragment createPostFragment = new CreatePostFragment();
            transaction.replace(R.id.containers, createPostFragment);
            transaction.addToBackStack(null); // 이전 상태를 백 스택에 추가

            // 트랜잭션 커밋
            transaction.commit();
        });

        return view;
    }
}