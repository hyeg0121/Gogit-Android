package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.RetrofitClient;
import com.gogit.gogit_app.config.Config;
import com.gogit.gogit_app.config.SessionManager;
import com.gogit.gogit_app.util.MyToast;

import retrofit2.Retrofit;

public class TokenActivity extends AppCompatActivity {
    @SuppressLint("CheckResult")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_token);

        SessionManager sessionManager = new SessionManager(getApplicationContext());

        // 토큰이 있으면 입력받지 않음
        // TODO: 토큰이 유효한 토큰인지 검사
        if (sessionManager.getToken() != null) {
            Intent intent = new Intent(TokenActivity.this, MemberMainActivity.class);
            startActivity(intent);
        }

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();


        Button submitButton = findViewById(R.id.submit_button);
        EditText toeknEditText = findViewById(R.id.token_editText);


        submitButton.setOnClickListener(e -> {
            String token = toeknEditText.getText().toString();

            // 토큰을 입력하지 않았을 때
            if (token == null || token.length() == 0) {
                MyToast.showToast(getApplicationContext(), "토큰을 입력해주세요.");
                return;
            }

            sessionManager.saveLoginDetails(getIntent().getStringExtra(SessionManager.KEY_TOKEN), Config.GITHUB_TOKEN);

            Intent intent = new Intent(TokenActivity.this, MemberMainActivity.class);
            startActivity(intent);

        });
    }
}