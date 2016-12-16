package com.kausthubhadhikari.moviesdb;

import android.app.Application;

import com.kausthubhadhikari.moviesdb.di.injector.DaggerInjector;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public class AppController extends Application {

    private Injector injector;
    private String baseURL;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    public void initDagger() {
        getDaggerInjector().init(this);
    }

    public Injector getDaggerInjector() {
        if (injector == null) {
            injector = new DaggerInjector();
        }
        return injector;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() {
        return baseURL;
    }

}
