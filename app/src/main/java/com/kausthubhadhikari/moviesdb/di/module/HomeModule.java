package com.kausthubhadhikari.moviesdb.di.module;

import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;
import com.kausthubhadhikari.moviesdb.home.HomePresenter;

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
    public HomePresenter providesHomePresenter(){
        return new HomePresenter(activity);
    }

}
