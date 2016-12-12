package com.kausthubhadhikari.moviesdb.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import com.kausthubhadhikari.moviesdb.R;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.utils.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject(Injector injector) {
        injector.inject(this);
    }

    @NonNull
    @Override
    public DetailPresenter getPresenter() {
        return null;
    }

    @Override
    public void setupView() {
        setSupportActionBar(toolbar);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void fetchError(int code) {

    }

    @Override
    public void deliverData(TVShowDetails data) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showHttpError() {

    }
}
