package com.kausthubhadhikari.moviesdb.di.component;

import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.di.module.SplashModule;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;
import com.kausthubhadhikari.moviesdb.splash.SplashPresenter;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */
@ActivityScope
@Component(modules = {SplashModule.class},dependencies = {AppComponent.class})
public interface SplashComponent {

    void inject(Injector injector);

    public SplashActivity providesSplashActivity();

    public SplashPresenter providesSplashPresenter();

}
