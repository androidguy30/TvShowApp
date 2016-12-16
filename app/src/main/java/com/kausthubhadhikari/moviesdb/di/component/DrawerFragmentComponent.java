package com.kausthubhadhikari.moviesdb.di.component;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.kausthubhadhikari.moviesdb.di.module.DrawerFragmentModule;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragmentPresenter;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */
@ActivityScope
@Component(modules = {DrawerFragmentModule.class}, dependencies = {AppComponent.class})
public interface DrawerFragmentComponent {

    void inject(DrawerFragment fragment);

    Context providesContext();

    LinearLayoutManager providesLinearLayoutManager();

    DefaultItemAnimator providesItemAnimator();

    DrawerFragmentPresenter provideDrawerFragmentPresenter();
}
