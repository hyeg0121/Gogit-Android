package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.RetrofitClient;
import com.gogit.gogit_app.config.SessionManager;

import retrofit2.Retrofit;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        // sesstion manager
        SessionManager sessionManager = new SessionManager(this);
        Log.d("my tag", sessionManager.getToken());
        Log.d("my tag", sessionManager.getUserId());

        // view
        EditText contentEditText = findViewById(R.id.content_edittext);
        Button uploadButton = findViewById(R.id.upload_button);

        // retrofit
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();


        uploadButton.setOnClickListener(e -> {
            String content = contentEditText.getText().toString();

        });


    }
}