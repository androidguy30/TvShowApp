package com.kausthubhadhikari.moviesdb.showdetails;

import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;

import java.util.HashMap;
import java.util.Map;

import rx.Subscription;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class DetailPresenter extends BasePresenter {

    private final DetailView view;
    private NetworkManager manager;

    public DetailPresenter(DetailView view, NetworkManager manager) {
        super(view);
        this.view = view;
        this.manager = manager;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        view.setupView();
        if (isLaunched) {
            view.showProgress();
            Map<String, String> params = new HashMap<>();
            params.put(AppConstants.QUERY_PARAM_API_KEY, AppConstants.APIKEY);

            Subscription subscription = manager.getShowDetails(params, view.retrieveShowId())
                    .subscribe(this::onDetailsFetched, this::onHandleErrors);
            addSubcription(subscription);
        }
    }

    private void onDetailsFetched(TVShowDetails data) {
        view.hideProgress();
        if (data != null) {
            view.deliverData(data);
        }
    }

    private void onHandleErrors(Throwable throwable) {
        view.hideProgress();
        try {
            view.fetchError(throwable);
        } catch (Exception e) {
            view.fetchError(e.getCause());
        }
    }
}
