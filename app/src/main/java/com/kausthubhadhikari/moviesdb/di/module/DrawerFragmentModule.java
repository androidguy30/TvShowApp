package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragmentPresenter;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */
@Module
public class DrawerFragmentModule {

    DrawerFragment fragment;

    public DrawerFragmentModule(DrawerFragment fragment) {
        this.fragment = fragment;
    }

    @ActivityScope
    @Provides
    public Context providesContext() {
        return fragment.getContext();
    }

    @ActivityScope
    @Provides
    public DrawerFragmentPresenter provideDrawerFragmentPresenter(DrawerFragment fragment, NetworkManager manager) {
        return new DrawerFragmentPresenter(fragment, manager);
    }

    @ActivityScope
    @Provides
    public LinearLayoutManager providesLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    @ActivityScope
    @Provides
    public DefaultItemAnimator providesDefaultItemAnimator() {
        return new DefaultItemAnimator();
    }

    @ActivityScope
    @Provides
    public DrawerFragment providesDrawerFragment() {
        return fragment;
    }

}
