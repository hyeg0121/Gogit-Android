 package com.gogit.gogit_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gogit.gogit_app.R;

public class GitHubOAuthLoginActivity extends AppCompatActivity {

    final String URL = "http://10.0.2.2:8080/login";
    final String REDIREC_URL = "http://10.0.2.2:8080";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_oauth_login);

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // SSL 인증서 무시
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Log.d("my tag", error.toString());
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //return super.shouldOverrideUrlLoading(view, request);
                view.loadUrl(request.getUrl().toString());

                return true; //응용프로그램이 직접 url 처리
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                    Intent intent = new Intent(GitHubOAuthLoginActivity.this, TokenActivity.class);
                    startActivity(intent);
            }

        });
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(URL);

    }
}