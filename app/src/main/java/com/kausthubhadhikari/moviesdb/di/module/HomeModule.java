package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

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
    public Context providesContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    public LinearLayoutManager providesLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @ActivityScope
    @Provides
    public DefaultItemAnimator providesItemAnimator() {
        return new DefaultItemAnimator();
    }

    @ActivityScope
    @Provides
    public HomePresenter providesHomePresenter(){
        return new HomePresenter(activity);
    }

}
