package com.kausthubhadhikari.moviesdb.showdetails;

import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.utils.base.BaseView;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public interface DetailView extends BaseView {

    void setupView();

    void showProgress();

    void hideProgress();

    void fetchError(Throwable throwable);

    void deliverData(TVShowDetails data);

    int retrieveShowId();

}
