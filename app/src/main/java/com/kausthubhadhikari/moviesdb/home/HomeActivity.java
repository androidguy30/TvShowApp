package com.kausthubhadhikari.moviesdb.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.utils.base.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    HomePresenter presenter;

    @Inject
    MaterialDialog progressDialog;

    @Inject
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @Override
    public HomePresenter getPresenter() {
        return presenter;
    }


    @Override
    public void fetchError(int code) {

    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setupViews() {
        setSupportActionBar(toolbar);

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showHttpError() {

    }
}
