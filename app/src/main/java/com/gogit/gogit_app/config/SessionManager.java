package com.gogit.gogit_app.config;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String PREF_NAME = "LoginPrefs";
    public static final String KEY_USERID = "userid";
    public static final String KEY_TOKEN = "usertoken";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void saveLoginDetails(String userId, String token) {
        editor.putString(KEY_USERID, userId);
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public String getUserId() {
        return pref.getString(KEY_USERID, null);
    }

    public String getToken() {
        return pref.getString(KEY_TOKEN, null);
    }

    public void clearLoginDetails() {
        editor.remove(KEY_USERID);
        editor.remove(KEY_TOKEN);
        editor.apply();
    }

}
