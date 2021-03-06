package com.kausthubhadhikari.moviesdb.model.manager;

import com.kausthubhadhikari.moviesdb.model.api.APIService;
import com.kausthubhadhikari.moviesdb.model.pojo.configuration.ConfigurationPOJO;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.model.pojo.onair.OnAirPojo;
import com.kausthubhadhikari.moviesdb.model.pojo.popular.PopularPOJO;
import com.kausthubhadhikari.moviesdb.model.pojo.toprated.TVTopRated;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public class NetworkManager {

    private APIService apiService;

    public NetworkManager(APIService apiService) {
        this.apiService = apiService;
    }

    /**
     * Query Params
     * api_key
     * language
     * <p>
     * Path Parameter
     * tv_id
     *
     * @param params
     * @param showId
     * @return
     */
    public Flowable<TVShowDetails> getShowDetails(Map<String, String> params, int showId) {
        return apiService.getShowDetails(showId, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Query Params
     * api_key
     * language
     * page
     *
     * @param params
     * @return
     */
    public Flowable<OnAirPojo> getOnAirShows(Map<String, String> params) {
        return apiService.getOnAir(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Query Params
     * api_key
     * language
     * page
     *
     * @param params
     * @return
     */
    public Flowable<PopularPOJO> getPopularShows(Map<String, String> params) {
        return apiService.getPopular(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Query Params
     * api_key
     * language
     * page
     *
     * @param params
     * @return
     */
    public Flowable<TVTopRated> getTopRated(Map<String, String> params) {
        return apiService.getTopRated(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * Query Param
     * api_key
     *
     * @param apiKey
     * @return
     */
    public Flowable<ConfigurationPOJO> getConfiguration(String apiKey) {
        return apiService.getConfigurationS(apiKey)
                .debounce(1200, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
