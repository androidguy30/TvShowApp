
package com.kausthubhadhikari.moviesdb.model.pojo.configuration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigurationPOJO {

    @SerializedName("images")
    @Expose
    public Images images;
    @SerializedName("change_keys")
    @Expose
    public List<String> changeKeys = null;

}
