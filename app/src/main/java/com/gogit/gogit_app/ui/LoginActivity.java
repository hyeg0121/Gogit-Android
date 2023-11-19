package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.util.SessionManager;
import com.gogit.gogit_app.util.ToastHelper;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        SessionManager sessionManager = new SessionManager(getApplicationContext());
//        sessionManager.clearLoginDetails();

        // 저장된 정보가 있는 경우
        if (sessionManager.getToken() != null
                && sessionManager.getUserId() != null
                && sessionManager.getPk() != null) {

            // 저장된 토큰이 유효한지 검사
            try {
                GitHub gitHub = new GitHubBuilder().withOAuthToken(sessionManager.getToken()).build();
                gitHub.checkApiUrlValidity();
            } catch (IOException e) {
                ToastHelper.showToast(this, "토큰이 유효하지 않아 다시 로그인합니다.");
                Log.d("my tag", e.getMessage());
                return;
            }

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        // 저장된 정보가 없으면 로그인
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(e -> {
            Intent intent = new Intent(this, GenericIdpActivity.class);
            startActivity(intent);
        });
    }
}