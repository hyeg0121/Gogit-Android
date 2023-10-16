package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    String myToken = "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";

    @SuppressLint("CheckResult")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_token);

        // TODO: 토큰이 있으면 바로 메인으로 가기

        Button submitButton = findViewById(R.id.submit_button);
        EditText toeknEditText = findViewById(R.id.token_editText);


        submitButton.setOnClickListener(e -> {
            // 입력된 토큰 가져오기
            String token = toeknEditText.getText().toString();
            // TODO: 토큰 유효성 검사하기
            // TODO: 빈 칸일 때 리턴
            SharedPreferences sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE);

            // 저장된 토큰 가져오기
            String storedToken = sharedPreferences.getString("access_token", null);

            if (storedToken == null) {
                // 저장된 토큰이 존재하지 않으면 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("access_token", myToken);
                editor.apply();
            }

            Intent intent = new Intent(TokenActivity.this, MemberMainActivity.class);
            startActivity(intent);

//            Observable.fromCallable(() -> {
//                GitHub gitHub = new GitHubBuilder().withOAuthToken(myToken).build();
//                return gitHub;
//            })
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(
//                            gitHub -> {
//                            },
//                            error -> {
//                            }
//                    );


        });
    }
}