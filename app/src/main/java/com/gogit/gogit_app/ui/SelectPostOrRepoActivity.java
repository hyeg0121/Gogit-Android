package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.gogit.gogit_app.R;

public class SelectPostOrRepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_create);

        // 뷰 가져오기
        Button repositoryCreateButton = findViewById(R.id.repositories_create_btn);
        Button postCreateButton = findViewById(R.id.post_create_btn);

        repositoryCreateButton.setOnClickListener(e -> {
            Intent intent = new Intent(SelectPostOrRepoActivity.this,
                    CreateRepoActivity.class);
            startActivity(intent);
        });

        postCreateButton.setOnClickListener(e -> {
            Intent intent = new Intent(SelectPostOrRepoActivity.this,
                    CreatePostActivity.class);
            startActivity(intent);
        });
    }
}