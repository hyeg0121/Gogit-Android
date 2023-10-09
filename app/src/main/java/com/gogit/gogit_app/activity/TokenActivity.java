package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TokenActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_token);

        Button submitButton = findViewById(R.id.submit_button);
        EditText toeknEditText = findViewById(R.id.token_editText);


        submitButton.setOnClickListener(e -> {
            String token = toeknEditText.getText().toString();
            Log.d("my tag", token);

            Observable.fromCallable(() -> {
                GitHub gitHub = new GitHubBuilder().withOAuthToken(myToken).build();
                return gitHub;
            })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            gitHub -> {
                                Intent intent = new Intent(TokenActivity.this, MemberMainActivity.class);
                                startActivity(intent);
                            },
                            error -> {
                                Log.d("my tag", "error");
                            }
                    );


        });
    }
}