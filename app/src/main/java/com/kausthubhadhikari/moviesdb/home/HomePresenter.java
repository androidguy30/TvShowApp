package com.kausthubhadhikari.moviesdb.home;

import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public class HomePresenter extends BasePresenter {

    HomeView homeView;

    public HomePresenter(HomeView view) {
        super(view);
        this.homeView = view;
    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        if(isLaunched){
            homeView.setupViews();
        }
    }

    public void showProgressDialog(){

    }

}
