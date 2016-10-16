package com.example.andriy.fifthhomework.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andriy on 05.10.2016.
 */

public class Channel {

    @SerializedName("login")
    String name;
    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
