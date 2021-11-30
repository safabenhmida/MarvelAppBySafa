package com.marvel.digital.app;

import android.app.Application;
import android.content.Context;

import com.marvel.digital.injection.DaggerInjector;
import com.marvel.digital.injection.GeneralModule;
import com.marvel.digital.injection.Injector;
import com.marvel.digital.injection.ServiceModule;


/**
 * Created by BENHMIDA SAFA
 */
public class FrontOfficeMobileApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    private static FrontOfficeMobileApp instance;
    private Injector injector;
    public enum DevMode {CONNECT_TO_SERVER,OFFLINE}
    private DevMode devMode = DevMode.CONNECT_TO_SERVER;


    public FrontOfficeMobileApp() {

        instance = this;
        injector = DaggerInjector.builder().
                generalModule(new GeneralModule())
                .serviceModule(new ServiceModule())
                .build();
    }


    public static FrontOfficeMobileApp getInstance() {
        return instance;
    }


    public Injector getInjector() {
        return injector;
    }

    public void initDagger() {
        injector = DaggerInjector.builder().
                generalModule(new GeneralModule())
                .serviceModule(new ServiceModule())
                .build();
    }

    public DevMode getDevMode() {
        return devMode;
    }
}
