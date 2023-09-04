package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.util.Util;

public class GitHubOAuthLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_oauth_login);

        Uri.Builder builder = Uri.parse(Util.GITHUB_AUTHORIZE_URL).buildUpon()
                .appendQueryParameter("client_id", Util.GITHUB_CLIENT_ID)
                .appendQueryParameter("redirect_uri", Util.GITHUB_CALLBACK_URL)
                .appendQueryParameter("scope", "user");

        Intent intent = new Intent(Intent.ACTION_VIEW, builder.build());
        startActivity(intent);
    }
}