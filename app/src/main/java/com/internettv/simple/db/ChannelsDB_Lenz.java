package com.internettv.simple.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChannelsDB_Lenz extends SQLiteOpenHelper {

    public ChannelsDB_Lenz(Context c) {
        super(c, "lenz.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE lenz (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, code TEXT)");

        insert(db, "یک", "tv1");
        insert(db, "سه", "tv3");
        insert(db, "ورزش", "varzesh");
        insert(db, "خبر", "khabar");
    }

    private void insert(SQLiteDatabase db, String name, String code) {
        db.execSQL("INSERT INTO lenz (name, code) VALUES ('" + name + "','" + code + "')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS lenz");
        onCreate(db);
    }
}
