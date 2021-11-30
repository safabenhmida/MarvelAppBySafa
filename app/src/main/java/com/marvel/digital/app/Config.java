package com.marvel.digital.app;

import android.content.SharedPreferences;


import com.marvel.digital.R;

import javax.inject.Inject;

/**
 * Created by BENHMIDA SAFA
 */
public class Config {

    public static final String SERVER_URL = "SERVER_URL";
    public static final String USE_DEMO_SERVER = "USE_DEMO_SERVER";


    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public Config() {
    }

    public String getServerUrl() {
        return sharedPreferences.getString(SERVER_URL,FrontOfficeMobileApp.getInstance().getResources().getString(R.string.pref_default_server_url)); }

    public Boolean getUseDemoServer() {
        return sharedPreferences.getBoolean(USE_DEMO_SERVER,false);
    }

}

