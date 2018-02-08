package com.kausthubhadhikari.moviesdb.model.api;

import com.kausthubhadhikari.moviesdb.model.pojo.configuration.ConfigurationPOJO;
import com.kausthubhadhikari.moviesdb.model.pojo.detail.TVShowDetails;
import com.kausthubhadhikari.moviesdb.model.pojo.onair.OnAirPojo;
import com.kausthubhadhikari.moviesdb.model.pojo.popular.PopularPOJO;
import com.kausthubhadhikari.moviesdb.model.pojo.toprated.TVTopRated;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by kausthubhadhikari on 12/12/16.
 */

public interface APIService {

    /**
     * Show details
     *
     * @param query
     * @param tvShowId
     * @return
     */
    @GET("tv/{tv_id}")
    Flowable<TVShowDetails> getShowDetails(@Path("tv_id") int tvShowId, @QueryMap Map<String, String> query);

    /**
     * Retrieve Top rated shows.
     *
     * @param queryParam
     * @return
     */
    @GET("tv/top_rated")
    Flowable<TVTopRated> getTopRated(@QueryMap Map<String, String> queryParam);

    /**
     * Retrieve OnAir
     *
     * @param queryParams
     * @return
     */
    @GET("tv/on_the_air")
    Flowable<OnAirPojo> getOnAir(@QueryMap Map<String, String> queryParams);

    /**
     * Retrieve Popular Tv Shows
     *
     * @param queryParams
     * @return
     */
    @GET("tv/popular")
    Flowable<PopularPOJO> getPopular(@QueryMap Map<String, String> queryParams);

    /**
     * Query the configuration.
     *
     * @param apiKey
     * @return
     */
    @GET("configuration")
    Flowable<ConfigurationPOJO> getConfigurationS(@Query("api_key") String apiKey);

}
