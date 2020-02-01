package org.atctech.al_quranbangla.DB;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseHelper2 extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "quran_2.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, null, DATABASE_VERSION);
    }
}
