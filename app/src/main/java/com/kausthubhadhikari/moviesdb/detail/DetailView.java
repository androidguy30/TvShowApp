package com.kausthubhadhikari.moviesdb.detail;

import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.utils.base.BaseView;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public interface DetailView extends BaseView {

    void setupView();

    void showProgress();

    void hideProgress();

    void fetchError(int code);

    void deliverData(TVShowDetails data);

}
