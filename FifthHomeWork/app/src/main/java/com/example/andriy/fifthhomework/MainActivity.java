package com.example.andriy.fifthhomework;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.andriy.fifthhomework.adapters.ChannelAdapter;
import com.example.andriy.fifthhomework.interfaces.ChannelService;
import com.example.andriy.fifthhomework.models.Channel;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ChannelAdapter channelAdapter;
    private RecyclerView recyclerView;
    private List<Channel> channels;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channels = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ChannelService channelService = ChannelService.retrofit.create(ChannelService.class);
        Call<List<Channel>> call = channelService.listOfChannels();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        call.enqueue(new Callback<List<Channel>>() {
            @Override
            public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                channels = response.body();
                channelAdapter = new ChannelAdapter(channels);
                recyclerView.setAdapter(channelAdapter);
            }
            @Override
            public void onFailure(Call<List<Channel>> call, Throwable t) {
            }
        });
    }
}
