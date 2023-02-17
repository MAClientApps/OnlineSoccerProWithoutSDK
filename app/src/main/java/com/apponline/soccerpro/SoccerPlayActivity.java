package com.apponline.soccerpro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class SoccerPlayActivity extends AppCompatActivity {

    private android.webkit.WebView contentWebPlay;
    private String link = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_soccer_activity);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            getSupportActionBar().hide();

        } catch (Exception e) {

        }
        initGameWebView();
    }



    @SuppressLint("ResourceAsColor")
    private void initGameWebView() {
        contentWebPlay = (android.webkit.WebView)findViewById(R.id.wv_jeep_game);
        CookieManager.getInstance().setAcceptCookie(true);
        contentWebPlay.getSettings().setJavaScriptEnabled(true);
        contentWebPlay.getSettings().setUseWideViewPort(false);
        contentWebPlay.getSettings().setLoadWithOverviewMode(false);
        contentWebPlay.getSettings().setDomStorageEnabled(true);
        contentWebPlay.getSettings().setPluginState(WebSettings.PluginState.ON);
        contentWebPlay.setWebChromeClient(new WebChromeClient());
        contentWebPlay.setVisibility(View.VISIBLE);
        contentWebPlay.getSettings().setSupportZoom(false);


        contentWebPlay.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {

                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        contentWebPlay.loadUrl("https://html5.gamemonetize.co/k1orda4ozayeomp9aujirw4yqnuwxebh/");


    }


    @Override
    public void onResume() {
        super.onResume();
        contentWebPlay.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        contentWebPlay.onPause();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (contentWebPlay.canGoBack()) {
                        contentWebPlay.goBack();
                    } else {
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        contentWebPlay.loadUrl("about:blank");
    }



}