package com.creativetrends.addons.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.creativetrends.addons.activities.CreativeTrends;

public final class PreferencesUtility {

    public PreferencesUtility(final Context context) {
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static String getString(String key, String defValue) {
        return PreferenceManager.getDefaultSharedPreferences(CreativeTrends.getContextOfApplication()).getString(key, defValue);
    }



    static void putString(String key, String value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(CreativeTrends.getContextOfApplication()).edit();
        editor.putString(key, value);
        editor.apply();
    }




}




