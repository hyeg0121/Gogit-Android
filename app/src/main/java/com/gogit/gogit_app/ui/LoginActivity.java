package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.gogit.gogit_app.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(e -> {
            Intent intent = new Intent(this, GenericIdpActivity.class);
            startActivity(intent);
        });
    }
}