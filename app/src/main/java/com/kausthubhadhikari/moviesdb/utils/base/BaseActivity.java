package com.kausthubhadhikari.moviesdb.utils.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((AppController) getApplicationContext()).getDaggerInjector());
        getPresenter().onViewCreated(savedInstanceState == null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().unsubscribe();
    }

    public abstract void inject(Injector component);

    public abstract
    @NonNull
    P getPresenter();
}
