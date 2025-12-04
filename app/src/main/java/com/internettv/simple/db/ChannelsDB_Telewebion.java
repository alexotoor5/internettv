package com.internettv.simple.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChannelsDB_Telewebion extends SQLiteOpenHelper {

    public ChannelsDB_Telewebion(Context c) {
        super(c, "telewebion.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tele (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, code TEXT)");

        insert(db, "یک", "1");
        insert(db, "دو", "2");
        insert(db, "سه", "3");
        insert(db, "مستند", "mostanad");
        insert(db, "ورزش", "varzesh");
        insert(db, "خبر", "khabar");
        insert(db, "پویا", "pooya");
        insert(db, "تهران", "tehran");
    }

    private void insert(SQLiteDatabase db, String name, String code) {
        db.execSQL("INSERT INTO tele (name, code) VALUES ('" + name + "','" + code + "')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS tele");
        onCreate(db);
    }
}
