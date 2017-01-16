package com.dgse.viperapp.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Андрей on 16.01.2017.
 */

public class AbuBoardIcon {
    @SerializedName("name")
    String name;
    @SerializedName("url")
    String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
