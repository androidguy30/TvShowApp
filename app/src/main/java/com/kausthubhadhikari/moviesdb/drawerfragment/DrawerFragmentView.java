package com.kausthubhadhikari.moviesdb.drawerfragment;

import com.kausthubhadhikari.moviesdb.utils.base.BaseView;

/**
 * Created by kausthubhadhikari on 14/12/16.
 */

public interface DrawerFragmentView extends BaseView {

    public void setupView();

    public String getMethodName();

    public void deliverData(Object data);

    public void showProgress();

    public void hideProgress();

    public int getPageNumber();

    public void deliverError(Throwable throwable);

    public void endInfiniteLoading();
}
