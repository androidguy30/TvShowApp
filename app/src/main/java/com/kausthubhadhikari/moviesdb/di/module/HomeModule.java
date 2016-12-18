package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.home.HomeActivity;
import com.kausthubhadhikari.moviesdb.home.HomePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */
@Module
public class HomeModule {

    private HomeActivity activity;

    public HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public HomePresenter providesHomePresenter() {
        return new HomePresenter(activity);
    }

    @ActivityScope
    @Provides
    public MaterialDialog providesMaterialDialogLoader(Context context) {
        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .customView(R.layout.progress_dialog, false)
                .cancelable(false)
                .theme(Theme.LIGHT)
                .build();
        materialDialog.getWindow().setLayout(85, 85);
        materialDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#90000000")));

        return materialDialog;
    }

    @ActivityScope
    @Provides
    public Context providesContext() {
        return activity;
    }

}
