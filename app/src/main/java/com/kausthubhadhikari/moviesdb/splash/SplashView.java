package com.kausthubhadhikari.moviesdb.splash;

import com.kausthubhadhikari.moviesdb.model.pojo.configuration.ConfigurationPOJO;
import com.kausthubhadhikari.moviesdb.utils.base.BaseView;

/**
 * Created by kausthubhadhikari on 16/12/16.
 */

public interface SplashView extends BaseView {

    public void onSetupView();

    public void onConfigFetched(ConfigurationPOJO data);

    public void onError(Throwable throwable);

}
