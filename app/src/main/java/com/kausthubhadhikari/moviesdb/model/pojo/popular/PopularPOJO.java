
package com.kausthubhadhikari.moviesdb.model.pojo.popular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kausthubhadhikari.moviesdb.model.pojo.common.Result;

import java.util.ArrayList;

public class PopularPOJO {

    @SerializedName("page")
    @Expose
    public int page;
    @SerializedName("results")
    @Expose
    public ArrayList<Result> results = new ArrayList<>();
    @SerializedName("total_results")
    @Expose
    public int totalResults;
    @SerializedName("total_pages")
    @Expose
    public int totalPages;

}
