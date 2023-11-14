package com.gogit.gogit_app.fragment.issue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogit.gogit_app.R;

public class IssuesFragment extends Fragment {

    public IssuesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.issues, container, false);


        return view;
    }
}