package com.apponline.soccerpro;

import static com.apponline.soccerpro.SoccerAdMobClass.SOCCER_AD_IS_VISIBLE;
import static com.apponline.soccerpro.SoccerAdMobClass.SOCCER_BANNER_ID;
import static com.apponline.soccerpro.SoccerAdMobClass.SOCCER_GAME_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class SoccerDashboardActivity extends AppCompatActivity {

    ImageView btnPlay1;
    LinearLayout ad_BannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer_dashboard);

        ad_BannerView = findViewById(R.id.ad_BannerView);
        btnPlay1 = findViewById(R.id.btnPLay);
        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SoccerDashboardActivity.this, SoccerPlayActivity.class);
                startActivity(it);
            }
        });

        if (SOCCER_AD_IS_VISIBLE && SoccerAdMobClass.isConctionAvailableLv(getApplicationContext())){
            UnityAds.initialize(this, SOCCER_GAME_ID, SOCCER_AD_IS_VISIBLE);
            BannerView view = new BannerView(SoccerDashboardActivity.this, SOCCER_BANNER_ID, new UnityBannerSize(320, 50));
            view.load();
            ad_BannerView.addView(view);
        }
    }
}