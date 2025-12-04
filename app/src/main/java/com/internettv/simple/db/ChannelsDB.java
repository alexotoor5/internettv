package com.internettv.simple.db;

import android.content.Context;

public class ChannelsDB {

    Context ctx;

    public ChannelsDB(Context c) {
        ctx = c;
    }

    public String[][] getAll() {

        return new String[][]{
                {"ورزش","varzesh"},
                {"نسیم","nasim"},
                {"پویا","pooya"},
                {"مستند","mostanad"},
                {"آموزش","amozesh"},
                {"افق","ofogh"},
                {"تهران","tehran"},
                {"iFilm","ifilm"},
                {"تماشا","tamasha"},

                {"DW","dw"},
                {"Red Bull TV","redbull"},
                {"Euronews","euronews"}
        };
    }
}
