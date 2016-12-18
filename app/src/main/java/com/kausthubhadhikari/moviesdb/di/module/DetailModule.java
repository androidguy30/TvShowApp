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
import com.kausthubhadhikari.moviesdb.model.manager.HorizontalItemDecorator;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.showdetails.DetailActivity;
import com.kausthubhadhikari.moviesdb.showdetails.DetailPresenter;
import com.kausthubhadhikari.moviesdb.utils.misc.AppUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

@Module
public class DetailModule {

    private DetailActivity activity;

    public DetailModule(DetailActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public DetailPresenter providesDetailsPresenter(DetailActivity activity, NetworkManager manager) {
        return new DetailPresenter(activity, manager);
    }

    @ActivityScope
    @Provides
    public DetailActivity providesDetailsActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    public LinearLayoutManager providesLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @ActivityScope
    @Provides
    public DefaultItemAnimator providesItemAnimator() {
        return new DefaultItemAnimator();
    }

    @ActivityScope
    @Provides
    public Context providesContext() {
        return activity;
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
    public HorizontalItemDecorator providesHorizontalItemDecorator() {
        return new HorizontalItemDecorator(AppUtils.dpTox(4));
    }

}
