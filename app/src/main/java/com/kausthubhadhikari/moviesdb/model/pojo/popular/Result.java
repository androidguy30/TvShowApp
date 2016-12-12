
package com.kausthubhadhikari.moviesdb.model.pojo.popular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {

    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("popularity")
    @Expose
    public float popularity;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("vote_average")
    @Expose
    public float voteAverage;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("origin_country")
    @Expose
    public ArrayList<String> originCountry = new ArrayList<>();
    @SerializedName("genre_ids")
    @Expose
    public ArrayList<Integer> genreIds = null;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("vote_count")
    @Expose
    public int voteCount;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("original_name")
    @Expose
    public String originalName;

}
