package com.kausthubhadhikari.moviesdb.di.injector;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.di.component.DaggerDrawerFragmentComponent;
import com.kausthubhadhikari.moviesdb.di.component.DaggerSplashComponent;
import com.kausthubhadhikari.moviesdb.di.module.DrawerFragmentModule;
import com.kausthubhadhikari.moviesdb.di.module.SplashModule;
import com.kausthubhadhikari.moviesdb.showdetails.DetailActivity;
import com.kausthubhadhikari.moviesdb.di.component.AppComponent;
import com.kausthubhadhikari.moviesdb.di.component.DaggerAppComponent;
import com.kausthubhadhikari.moviesdb.di.component.DaggerDetailComponent;
import com.kausthubhadhikari.moviesdb.di.component.DaggerHomeComponent;
import com.kausthubhadhikari.moviesdb.di.module.AppModule;
import com.kausthubhadhikari.moviesdb.di.module.DetailModule;
import com.kausthubhadhikari.moviesdb.di.module.HomeModule;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public class DaggerInjector implements Injector {

    private AppComponent appComponent;

    @Override
    public void init(AppController appController) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appController))
                .build();
    }

    @Override
    public void inject(HomeActivity activity) {
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(activity))
                .build();
    }

    @Override
    public void inject(DetailActivity activity) {
        DaggerDetailComponent.builder()
                .appComponent(appComponent)
                .detailModule(new DetailModule(activity))
                .build();
    }

    @Override
    public void inject(DrawerFragment fragment) {
        DaggerDrawerFragmentComponent.builder()
                .appComponent(appComponent)
                .drawerFragmentModule(new DrawerFragmentModule(fragment))
                .build();
    }

    @Override
    public void inject(SplashActivity activity) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(activity))
                .build();
    }
}
