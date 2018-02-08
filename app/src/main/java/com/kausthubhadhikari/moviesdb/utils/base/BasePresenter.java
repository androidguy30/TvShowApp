package com.kausthubhadhikari.moviesdb.utils.base;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public abstract class BasePresenter {

    private final BaseView view;
    private final CompositeDisposable compositeDisposable;
    public static String TAG = "BasePresenter";

    protected BasePresenter(BaseView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @CallSuper
    protected void unsubscribe() {
        compositeDisposable.clear();
    }

    protected void addSubcription(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public abstract void onViewCreated(boolean isLaunched);
}
