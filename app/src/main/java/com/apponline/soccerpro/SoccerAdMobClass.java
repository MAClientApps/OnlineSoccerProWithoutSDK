package com.apponline.soccerpro;

import android.content.Context;
import android.net.ConnectivityManager;

public class SoccerAdMobClass {

    public static final String SOCCER_GAME_ID = "5034953";
    public static Boolean SOCCER_AD_IS_VISIBLE = true;
    public static final String SOCCER_BANNER_ID = "Banner_Android";

    public static boolean isConctionAvailableLv(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm != null && cm.getActiveNetworkInfo() != null) && cm
                .getActiveNetworkInfo().isConnectedOrConnecting();
    }

}
