package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gogit.gogit_app.R;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MemberMainActivity extends AppCompatActivity {


    String myToken = "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";
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE);

        String userToken = sharedPreferences.getString("access_token", null);
        Log.d("my tag",userToken);

        Observable<GitHub> source = Observable.create(emitter -> {
            GitHub gitHub = new GitHubBuilder().withOAuthToken(myToken).build();
            emitter.onNext(gitHub);
            emitter.onError(new Throwable("Some error"));
            emitter.onComplete();
        });

        source.subscribe(
                item -> Log.d("my tag", item.toString()),
                throwable -> Log.d("my tag", "error")
        );
    }
}