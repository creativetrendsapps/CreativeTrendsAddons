package com.creativetrends.addons.activities;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**Created by Creative Trends Apps on 3/25/2017.*/

public class CreativeTrends extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context mContext;

    public static Context getContextOfApplication() {

        return mContext;
    }

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();
    }

}