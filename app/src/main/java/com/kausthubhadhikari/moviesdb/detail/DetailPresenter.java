package com.kausthubhadhikari.moviesdb.detail;

import com.kausthubhadhikari.moviesdb.utils.base.BasePresenter;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class DetailPresenter extends BasePresenter {

    private final DetailView view;

    public DetailPresenter(DetailView view) {
        super(view);
        this.view = view;

    }

    @Override
    public void onViewCreated(boolean isLaunched) {
        view.setupView();
        if(isLaunched){

        }
    }
}
