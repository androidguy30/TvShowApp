package com.kausthubhadhikari.moviesdb.di.component;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.model.manager.HorizontalItemDecorator;
import com.kausthubhadhikari.moviesdb.showdetails.DetailActivity;
import com.kausthubhadhikari.moviesdb.showdetails.DetailPresenter;
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

    Context providesContext();

    LinearLayoutManager providesLinearLayoutManager();

    DefaultItemAnimator providsItemAnimator();

    MaterialDialog providesMaterialDialogLoader();

    HorizontalItemDecorator providesHorizontalItemDecorator();

}
