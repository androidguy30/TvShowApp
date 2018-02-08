package com.kausthubhadhikari.moviesdb.showdetails;

import android.os.Bundle;

import com.kausthubhadhikari.moviesdb.model.manager.NetworkManager;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;
import com.kausthubhadhikari.moviesdb.utils.misc.AppConstants;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class DetailPresenter extends BasePresenter {

    private final DetailView view;
    private NetworkManager manager;
    private PageState pageState;
    private final String SAVE_PAGE_STATE = "SAVE_PAGE_STATE";

    enum PageState {
        FETCHING,
        DISPLAYING,
        ERROR
    }

    public PageState getPageState() {
        return pageState;
    }

    public void setPageState(PageState pageState) {
        this.pageState = pageState;
    }


    public DetailPresenter(DetailView view, NetworkManager manager) {
        super(view);
        this.view = view;
        this.manager = manager;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        view.setupView();
        if (isLaunched) {
            setPageState(PageState.FETCHING);
            showProgress();
            Map<String, String> params = new HashMap<>();
            params.put(AppConstants.QUERY_PARAM_API_KEY, AppConstants.APIKEY);

            Disposable disposable = manager.getShowDetails(params, view.retrieveShowId())
                    .subscribe(this::onDetailsFetched, this::onHandleErrors);
            addSubcription(disposable);
        }
    }

    private void onDetailsFetched(TVShowDetails data) {
        hideProgress();
        setPageState(PageState.DISPLAYING);
        if (data != null) {
            view.deliverData(data);
        }
    }

    private void onHandleErrors(Throwable throwable) {
        hideProgress();
        try {
            view.fetchError(throwable);
        } catch (Exception e) {
            view.fetchError(e.getCause());
        }
    }

    public void showProgress() {
        view.showProgress();
    }

    public void hideProgress() {
        view.hideProgress();
    }

    public void onSaveState(Bundle savedInstanceState) {
        savedInstanceState.putString(SAVE_PAGE_STATE, getPageState().name());
    }

    public void onRestoreState(Bundle savedInstanceState) {
        if (savedInstanceState.get(SAVE_PAGE_STATE) != null) {
            setPageState(PageState.valueOf((String) savedInstanceState.get(SAVE_PAGE_STATE)));
        }
        switch (getPageState()) {

            case FETCHING:
                onViewCreated(true);
                break;

            case ERROR:

                break;

            case DISPLAYING:
                onViewCreated(true);
                break;

        }
    }

}
