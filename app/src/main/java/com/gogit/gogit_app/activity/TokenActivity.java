package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class TokenActivity extends AppCompatActivity {

    String myToken = "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";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_token);

        Button submitButton = findViewById(R.id.submit_button);
        EditText toeknEditText = findViewById(R.id.token_editText);


        submitButton.setOnClickListener(e -> {
            String token = toeknEditText.getText().toString();
            Log.d("my tag", token);
        });
    }
}