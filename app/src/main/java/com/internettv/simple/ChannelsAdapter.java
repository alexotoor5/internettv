package com.internettv.simple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.ViewHolder> {

    Context context;
    ArrayList<String[]> channels;
    OnChannelClick listener;

    public interface OnChannelClick {
        void onPlay(String id, String name);
    }

    public ChannelsAdapter(Context context, ArrayList<String[]> channels, OnChannelClick listener) {
        this.context = context;
        this.channels = channels;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.channel_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {

        String name = channels.get(pos)[0];
        String id = channels.get(pos)[1];

        h.title.setText(name);
        h.logo.setImageResource(R.drawable.ic_default);

        h.card.setOnClickListener(v -> listener.onPlay(id, name));
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        ImageView logo;
        TextView title;

        public ViewHolder(View v) {
            super(v);
            card = v.findViewById(R.id.channelCard);
            logo = v.findViewById(R.id.channelLogo);
            title = v.findViewById(R.id.channelName);
        }
    }
}
