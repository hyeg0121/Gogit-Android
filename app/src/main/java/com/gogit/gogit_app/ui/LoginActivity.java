package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.config.SessionManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.clearLoginDetails();

        if (sessionManager.getToken() != null
                && sessionManager.getUserId() != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(e -> {
            Intent intent = new Intent(this, GenericIdpActivity.class);
            startActivity(intent);
        });
    }
}