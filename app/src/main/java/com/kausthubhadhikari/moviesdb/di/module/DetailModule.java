package com.kausthubhadhikari.moviesdb.di.module;

import com.kausthubhadhikari.moviesdb.detail.DetailActivity;
import com.kausthubhadhikari.moviesdb.detail.DetailPresenter;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

@Module
public class DetailModule {

    private DetailActivity activity;

    public DetailModule(DetailActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public DetailPresenter providesDetailsPresenter(DetailActivity activity) {
        return new DetailPresenter(activity);
    }

    @ActivityScope
    @Provides
    public DetailActivity providesDetailsActivity() {
        return activity;
    }

}
