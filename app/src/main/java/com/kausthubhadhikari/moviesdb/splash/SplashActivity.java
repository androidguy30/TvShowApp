package com.kausthubhadhikari.moviesdb.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.model.pojo.configuration.ConfigurationPOJO;
import com.kausthubhadhikari.moviesdb.utils.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @NonNull
    @Override
    public SplashPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showHttpError() {

    }

    @Override
    public void onSetupView() {

    }

    @Override
    public void onConfigFetched(ConfigurationPOJO data) {
        if (!data.images.secureBaseUrl.equals(null)) {
            ((AppController) getApplicationContext()).setBaseURL(data.images.secureBaseUrl);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

}
