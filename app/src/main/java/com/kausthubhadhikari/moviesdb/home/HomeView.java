package com.kausthubhadhikari.moviesdb.home;

import com.kausthubhadhikari.moviesdb.utils.base.BaseView;

/**
 * Created by kausthubhadhikari on 11/12/16.
 */

public interface HomeView extends BaseView {

    void fetchError(int code);

    void showProgress();

    void hideProgress();

    void setupViews();

    //void showTvShows();
}
