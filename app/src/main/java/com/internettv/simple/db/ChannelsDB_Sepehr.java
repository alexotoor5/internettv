package com.internettv.simple.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChannelsDB_Sepehr extends SQLiteOpenHelper {

    public ChannelsDB_Sepehr(Context c) {
        super(c, "sepehr.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE sepehr (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, code TEXT)");

        insert(db, "یک", "tv1");
        insert(db, "دو", "tv2");
        insert(db, "سه", "tv3");
        insert(db, "چهار", "tv4");
        insert(db, "پنج", "tv5");
        insert(db, "خبر", "khabar");
        insert(db, "مستند", "mostanad");
        insert(db, "ورزش", "varzesh");
        insert(db, "آموزش", "amoozesh");
        insert(db, "نسیم", "nasim");
        insert(db, "پویا", "pooya");
        insert(db, "قرآن", "quran");
        insert(db, "نمایش", "namayesh");
        insert(db, "سلامت", "salamat");
        insert(db, "افق", "ofogh");
        insert(db, "امید", "omid");
        insert(db, "ایران‌کالا", "irankala");

        insert(db, "تهران", "tehran");
        insert(db, "اصفهان", "esfahan");
        insert(db, "فارس", "fars");
        insert(db, "گیلان", "gilan");
        insert(db, "یزد", "yazd");
        insert(db, "مازندران", "mazandaran");
        insert(db, "کرمان", "kerman");
    }

    private void insert(SQLiteDatabase db, String name, String code) {
        db.execSQL("INSERT INTO sepehr (name, code) VALUES ('" + name + "','" + code + "')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sepehr");
        onCreate(db);
    }
}
