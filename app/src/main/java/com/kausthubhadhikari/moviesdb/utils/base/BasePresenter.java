package com.kausthubhadhikari.moviesdb.utils.base;

import android.support.annotation.CallSuper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public abstract class BasePresenter {

    private final BaseView view;
    private final CompositeSubscription compositeSubscription;
    public static String TAG = "BasePresenter";

    protected BasePresenter(BaseView view) {
        this.view = view;
        compositeSubscription = new CompositeSubscription();
    }

    @CallSuper
    protected void unsubscribe() {
        compositeSubscription.clear();
    }

    protected void addSubcription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public abstract void onViewCreated(boolean isLaunched);
}
