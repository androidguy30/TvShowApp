package com.kausthubhadhikari.moviesdb.home;

import android.os.Bundle;

import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public class HomePresenter extends BasePresenter {

    private HomeView homeView;
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

    public HomePresenter(HomeView view) {
        super(view);
        this.homeView = view;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        if (isLaunched) {
            setHomeView();
        }
    }

    public void showProgressDialog() {

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
                setHomeView();
                break;

            case ERROR:

                break;

            case DISPLAYING:

                break;

        }

    }

    public void setHomeView() {
        setPageState(PageState.FETCHING);
        homeView.setupViews();
    }

}
