package com.kausthubhadhikari.moviesdb.utils.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kausthubhadhikari.moviesdb.AppController;
import com.kausthubhadhikari.moviesdb.di.injector.Injector;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((AppController) getActivity().getApplicationContext()).getDaggerInjector());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onViewCreated(savedInstanceState == null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().unsubscribe();
    }

    public abstract void inject(Injector injector);

    public abstract P getPresenter();
}
