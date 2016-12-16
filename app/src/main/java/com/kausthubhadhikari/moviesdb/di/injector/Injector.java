package com.kausthubhadhikari.moviesdb.di.injector;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.showdetails.DetailActivity;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public interface Injector {

    void init(AppController appController);

    void inject(HomeActivity activity);

    void inject(DetailActivity activity);

    void inject(DrawerFragment fragment);

    void inject(SplashActivity activity);
}
