
package com.kausthubhadhikari.moviesdb.model.pojo.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TVShowDetails {

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("created_by")
    @Expose
    public ArrayList<CreatedBy> createdBy = new ArrayList<>();
    @SerializedName("episode_run_time")
    @Expose
    public ArrayList<Integer> episodeRunTime = null;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("genres")
    @Expose
    public ArrayList<Genre> genres = null;
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("in_production")
    @Expose
    public boolean inProduction;
    @SerializedName("languages")
    @Expose
    public ArrayList<String> languages = null;
    @SerializedName("last_air_date")
    @Expose
    public String lastAirDate;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("networks")
    @Expose
    public ArrayList<Network> networks = null;
    @SerializedName("number_of_episodes")
    @Expose
    public int numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    public int numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    public ArrayList<String> originCountry = null;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("popularity")
    @Expose
    public float popularity;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("production_companies")
    @Expose
    public ArrayList<ProductionCompany> productionCompanies = null;
    @SerializedName("seasons")
    @Expose
    public ArrayList<Season> seasons = null;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("vote_average")
    @Expose
    public int voteAverage;
    @SerializedName("vote_count")
    @Expose
    public int voteCount;

}
