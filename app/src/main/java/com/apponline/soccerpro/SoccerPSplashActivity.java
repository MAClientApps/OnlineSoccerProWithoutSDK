package com.apponline.soccerpro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SoccerPSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer_splash);

        SoccerGlobalApplication global=(SoccerGlobalApplication)this.getApplication();
        global.config.getRemoteConfig(this);

        global.config.OnSplashListener(() -> {
                    Intent intent = new Intent(SoccerPSplashActivity.this, SoccerDashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    startActivity(intent);
                    finish();
                }
        );

    }
}