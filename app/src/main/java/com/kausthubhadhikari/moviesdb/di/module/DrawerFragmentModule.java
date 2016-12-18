package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragment;
import com.kausthubhadhikari.moviesdb.drawerfragment.DrawerFragmentPresenter;
import com.kausthubhadhikari.moviesdb.drawerfragment.ItemDecorator;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.utils.misc.AppUtils;

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
        return fragment.getActivity();
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

    @ActivityScope
    @Provides
    public MaterialDialog providesMaterialDialogLoader(Context context) {
        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .customView(R.layout.progress_dialog, false)
                .cancelable(false)
                .theme(Theme.LIGHT)
                .build();
        materialDialog.getWindow().setLayout(AppUtils.dpTox(85), AppUtils.dpTox(85));
        materialDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#90000000")));

        return materialDialog;
    }

    @ActivityScope
    @Provides
    public ItemDecorator providesItemDecorator() {
        return new ItemDecorator(AppUtils.dpTox(8));
    }

}
