package com.kausthubhadhikari.moviesdb.di.component;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.di.module.AppModule;
import com.kausthubhadhikari.moviesdb.model.api.APIService;
import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.utils.misc.AppUtils;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    public MaterialDialog providesMaterialDialogLoader();

    public AppUtils providesAppUtils();

    public APIService providesApiService();

    public NetworkManager providesNetworkManager();

    public Picasso providesPicasso();

}
