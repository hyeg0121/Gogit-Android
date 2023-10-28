package com.gogit.gogit_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.RetrofitClient;
import com.gogit.gogit_app.config.SessionManager;

import retrofit2.Retrofit;

public class CreatePostFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_post, container, false);

        // sesstion manager
        SessionManager sessionManager = new SessionManager(getContext());
        Log.d("my tag", sessionManager.getToken());
        Log.d("my tag", sessionManager.getUserId());

        // view
        EditText contentEditText = view.findViewById(R.id.content_edittext);
        Button uploadButton = view.findViewById(R.id.upload_button);

        // retrofit
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();


        uploadButton.setOnClickListener(e -> {
            String content = contentEditText.getText().toString();

        });

        return view;
    }
}