package com.gogit.gogit_app.activity;

import static kotlinx.coroutines.BuildersKt.launch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.gogit.gogit_app.R;
import com.gogit.gogit_app.client.MyWebViewClient;
import com.gogit.gogit_app.util.Util;

public class GitHubOAuthLoginActivity extends AppCompatActivity {

    String url = "http://10.0.2.2:8080/login/github";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_oauth_login);

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webView.setWebViewClient(new MyWebViewClient());
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);

    }
}