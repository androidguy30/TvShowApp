package com.kausthubhadhikari.moviesdb.drawerfragment;

import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;

import java.util.HashMap;
import java.util.Map;

import rx.Subscription;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */

public class DrawerFragmentPresenter extends BasePresenter {

    private DrawerFragmentView fragment;
    private NetworkManager manager;

    public DrawerFragmentPresenter(DrawerFragmentView view, NetworkManager manager) {
        super(view);
        this.fragment = view;
        this.manager = manager;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        fragment.setupView();
        if (isLaunched) {
            fragment.showProgress();
            fetchData();
        }
    }


    public void onDataLoaded(Object data) {
        fragment.hideProgress();
        fragment.deliverData(data);
    }

    public void onErrorOccured(Throwable throwable) {
        fragment.hideProgress();
        fragment.deliverError(throwable);
    }

    public void fetchData() {
        fragment.endInfiniteLoading();
        if (fragment.getMethodName().equals("popular")) {
            Map<String, String> params = new HashMap<>();
            params.put(AppConstants.QUERY_PARAM_API_KEY, AppConstants.APIKEY);
            params.put(AppConstants.QUERY_PARAM_LANG_KEY, AppConstants.QUERY_PARAM_LANG_VAL);
            params.put(AppConstants.QUERY_PARAM_PAGE, "" + fragment.getPageNumber());

            Subscription subscription = manager.getPopularShows(params).subscribe(this::onDataLoaded, this::onErrorOccured);
            addSubcription(subscription);

        } else if (fragment.getMethodName().equals("top_rated")) {
            Map<String, String> params = new HashMap<>();
            params.put(AppConstants.QUERY_PARAM_API_KEY, AppConstants.APIKEY);
            params.put(AppConstants.QUERY_PARAM_LANG_KEY, AppConstants.QUERY_PARAM_LANG_VAL);
            params.put(AppConstants.QUERY_PARAM_PAGE, "" + fragment.getPageNumber());

            Subscription subscription = manager.getTopRated(params).subscribe(this::onDataLoaded, this::onErrorOccured);
            addSubcription(subscription);
        } else if (fragment.getMethodName().equals("on_air")) {
            Map<String, String> params = new HashMap<>();
            params.put(AppConstants.QUERY_PARAM_API_KEY, AppConstants.APIKEY);
            params.put(AppConstants.QUERY_PARAM_PAGE, "" + fragment.getPageNumber());
            params.put(AppConstants.QUERY_PARAM_LANG_KEY, AppConstants.QUERY_PARAM_LANG_VAL);

            Subscription subscription = manager.getOnAirShows(params).subscribe(this::onDataLoaded, this::onErrorOccured);
            addSubcription(subscription);
        }
    }

    public void loadNextPage() {
        fetchData();
    }

}
