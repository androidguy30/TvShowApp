package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;

import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */
@Module
public class HomeModule {

    private HomeActivity activity;

    public HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public Context providesContext() {
        return activity;
    }

}
