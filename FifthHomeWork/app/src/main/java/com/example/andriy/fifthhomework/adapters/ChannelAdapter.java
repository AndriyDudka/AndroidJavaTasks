package com.example.andriy.fifthhomework.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andriy.fifthhomework.R;
import com.example.andriy.fifthhomework.models.Channel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andriy on 06.10.2016.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelHolder> {

    private List<Channel> channels;

    public ChannelAdapter(List<Channel> channels){
        this.channels = channels;

    }

    @Override
    public ChannelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);

        return new ChannelHolder(view);
    }

    @Override
    public void onBindViewHolder(ChannelHolder holder, int position) {
        Channel channel = channels.get(position);

        holder.id.setText(channel.getId());
        holder.name.setText(channel.getName());
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public static class ChannelHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;

        public ChannelHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.textviewid);
            name = (TextView) itemView.findViewById(R.id.textviewname);
        }
    }
}
