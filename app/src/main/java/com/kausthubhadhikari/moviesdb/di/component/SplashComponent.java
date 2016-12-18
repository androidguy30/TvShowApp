package com.kausthubhadhikari.moviesdb.di.component;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.di.module.SplashModule;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */
@ActivityScope
@Component(modules = {SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {

    void inject(SplashActivity activity);

    MaterialDialog providesMaterialDialogLoader();

    Context providesContext();
}
