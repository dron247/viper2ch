package com.dgse.viperapp.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Андрей on 16.01.2017.
 */

public class AbuBoardModel {
    String id;
    String name;
    String category;
    int pageCount;
    @SerializedName("bump_limit")
    int bumpLimit;
    @SerializedName("sage")
    int sageEnabled;
    @SerializedName("tripcodes")
    int tripcodesEnabled;
    @SerializedName("enable_posting")
    int postingEnabled;
    @SerializedName("enable_thread_tags")
    int threadTagsEnabled;
    @SerializedName("enable_likes")
    int likesEnabled;
    @SerializedName("default_name")
    String defaultUsername;

    AbuBoardIcon[] icons;

    public int getBumpLimit() {
        return bumpLimit;
    }

    public String getCategory() {
        return category;
    }

    public String getDefaultUsername() {
        return defaultUsername;
    }

    public AbuBoardIcon[] getIcons() {
        return icons;
    }

    public String getId() {
        return id;
    }

    public boolean getLikesEnabled() {
        return likesEnabled > 0;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public boolean getPostingEnabled() {
        return postingEnabled > 0;
    }

    public boolean getSageEnabled() {
        return sageEnabled > 0;
    }

    public boolean getThreadTagsEnabled() {
        return threadTagsEnabled > 0;
    }

    public boolean getTripcodesEnabled() {
        return tripcodesEnabled > 0;
    }
}
