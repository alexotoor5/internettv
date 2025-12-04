package com.internettv.simple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;
import com.internettv.simple.db.ChannelsDB;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    PlayerView playerView;
    ExoPlayer player;
    TextView currentChannel;

    // سرور Koyeb شما
    String BASE = "https://pleased-linea-alexooro-715f0557.koyeb.app/api/watch/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerView);
        playerView = findViewById(R.id.playerView);
        currentChannel = findViewById(R.id.currentChannel);

        // ساخت پلیر
        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        loadChannels();
    }

    void loadChannels() {

        ChannelsDB db = new ChannelsDB(this);

        ArrayList<String[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(db.getAll()));

        rv.setLayoutManager(new GridLayoutManager(this, 3));

        ChannelsAdapter adapter = new ChannelsAdapter(
                this,
                list,
                (id, name) -> playChannel(id, name)
        );

        rv.setAdapter(adapter);
    }

    void playChannel(String id, String name) {

        currentChannel.setText(name);

        String url = BASE + id;

        MediaItem item = MediaItem.fromUri(Uri.parse(url));

        player.setMediaItem(item);
        player.prepare();
        player.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) player.release();
    }
}
