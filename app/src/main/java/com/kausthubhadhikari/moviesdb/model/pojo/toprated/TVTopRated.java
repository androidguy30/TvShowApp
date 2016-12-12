
package com.kausthubhadhikari.moviesdb.model.pojo.toprated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TVTopRated {

    @SerializedName("page")
    @Expose
    public int page;
    @SerializedName("results")
    @Expose
    public ArrayList<Result> results = null;
    @SerializedName("total_results")
    @Expose
    public int totalResults;
    @SerializedName("total_pages")
    @Expose
    public int totalPages;

}
