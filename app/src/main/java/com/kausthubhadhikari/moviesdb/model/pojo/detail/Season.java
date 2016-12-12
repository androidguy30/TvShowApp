
package com.kausthubhadhikari.moviesdb.model.pojo.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season {

    @SerializedName("air_date")
    @Expose
    public String airDate;
    @SerializedName("episode_count")
    @Expose
    public int episodeCount;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("poster_path")
    @Expose
    public Object posterPath;
    @SerializedName("season_number")
    @Expose
    public int seasonNumber;

}
