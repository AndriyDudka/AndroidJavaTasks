package com.example.andriy.fifthhomework.interfaces;

import com.example.andriy.fifthhomework.models.Channel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andriy on 05.10.2016.
 */

public interface ChannelService {

    @GET("users")
    Call<List<Channel>> listOfChannels();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
