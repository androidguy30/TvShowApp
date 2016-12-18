package com.kausthubhadhikari.moviesdb.di.module;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.scope.ActivityScope;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.splash.SplashActivity;
import com.kausthubhadhikari.moviesdb.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */
@Module
public class SplashModule {

    private SplashActivity activity;

    public SplashModule(SplashActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public SplashPresenter providesSplashPresenter(NetworkManager manager) {
        return new SplashPresenter(activity, manager);
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
    public Context providesContext(){
        return activity;
    }

}
