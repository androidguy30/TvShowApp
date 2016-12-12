package com.kausthubhadhikari.moviesdb.di.component;

import com.kausthubhadhikari.moviesdb.detail.DetailActivity;
import com.kausthubhadhikari.moviesdb.detail.DetailPresenter;
import com.kausthubhadhikari.moviesdb.di.module.DetailModule;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */
@ActivityScope
@Component(modules = {DetailModule.class}, dependencies = {AppComponent.class})
public interface DetailComponent {
    void inject(DetailActivity activity);

    DetailPresenter providesDetailPresenter();

    DetailActivity providesDetailsActivity();
}
