package com.kausthubhadhikari.moviesdb.splash;

import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.model.pojo.configuration.ConfigurationPOJO;
import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;

import rx.Subscription;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public class SplashPresenter extends BasePresenter {

    private SplashView splashView;
    private NetworkManager manager;

    public SplashPresenter(SplashView view, NetworkManager manager) {
        super(view);
        this.splashView = view;
        this.manager = manager;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        splashView.onSetupView();
        if (isLaunched) {
            Subscription subscription = manager.getConfiguration(AppConstants.APIKEY)
                    .subscribe(this::onConfigReceived, this::onError);
            addSubcription(subscription);
        }
    }

    public void onConfigReceived(ConfigurationPOJO configurationPOJO) {
        splashView.onConfigFetched(configurationPOJO);
    }

    public void onError(Throwable throwable) {
        splashView.onError(throwable);
    }

}
