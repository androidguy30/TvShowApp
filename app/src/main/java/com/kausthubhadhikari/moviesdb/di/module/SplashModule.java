package com.kausthubhadhikari.moviesdb.di.module;

import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;
import com.kausthubhadhikari.moviesdb.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */
@Module
public class SplashModule {

    private SplashActivity activity;

    public SplashModule(SplashActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public SplashPresenter providesSplashPresenter(SplashActivity activity, NetworkManager manager) {
        return new SplashPresenter(activity, manager);
    }

    @ActivityScope
    @Provides
    public SplashActivity providesDetailsActivity() {
        return activity;
    }

}
