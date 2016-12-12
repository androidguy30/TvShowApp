package com.kausthubhadhikari.moviesdb.di.injector;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.detail.DetailActivity;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public interface Injector {

    void init(AppController appController);

    void inject(HomeActivity activity);

    void inject(DetailActivity activity);

}
