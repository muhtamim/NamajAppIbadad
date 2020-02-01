package org.atctech.al_quranbangla.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.atctech.al_quranbangla.Model.Ayat;
import org.atctech.al_quranbangla.Model.Surah;

import java.util.ArrayList;

public class GetAllSurahList {

    public static final String SURAH_ID = "id";
    public static final String SURAH_AYAT_NO = "ayat";
    public static final String SURAH_NAME = "name";
    public static final String SURAH_MEANING = "meaning";
    public static final String SURAH_NAME_AR = "name_ar";
    private Cursor cursor;
    private DatabaseHelper databaseHelper;


    public GetAllSurahList(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }


    public ArrayList<Surah> AllSurahList() {
        ArrayList<Surah> surahArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT id,name,meaning,ayat,name_ar FROM sura", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Surah surah = new Surah();
            surah.setId(cursor.getInt(cursor.getColumnIndex(SURAH_ID)));
            surah.setAyat(cursor.getString(cursor.getColumnIndex(SURAH_AYAT_NO)));
            surah.setName(cursor.getString(cursor.getColumnIndex(SURAH_NAME)));
            surah.setMeaning(cursor.getString(cursor.getColumnIndex(SURAH_MEANING)));
            surah.setName_ar(cursor.getString(cursor.getColumnIndex(SURAH_NAME_AR)));

            surahArrayList.add(surah);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return surahArrayList;
    }


    public ArrayList<Ayat> GetAyatBySurah(int sura_id) {
        ArrayList<Ayat> ayatArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM quran_verses WHERE sura_id =" + sura_id, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ayat ayat = new Ayat();
            ayat.setId(cursor.getString(cursor.getColumnIndex("id")));
            ayat.setSura_id(cursor.getString(cursor.getColumnIndex("sura_id")));
            ayat.setVerse_id(cursor.getString(cursor.getColumnIndex("verse_id")));
            ayat.setArabic_indopak(cursor.getString(cursor.getColumnIndex("arabic_indopak")));
            ayat.setTrans(cursor.getString(cursor.getColumnIndex("trans")));
            ayat.setBn_muhi(cursor.getString(cursor.getColumnIndex("bn_muhi")));
            ayat.setPages(cursor.getString(cursor.getColumnIndex("pages")));
            ayat.setPara(cursor.getString(cursor.getColumnIndex("para")));

            ayatArrayList.add(ayat);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return ayatArrayList;
    }

    public ArrayList<Ayat> GetAllAyat() {
        ArrayList<Ayat> ayatArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM quran_verses", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ayat ayat = new Ayat();
            ayat.setId(cursor.getString(cursor.getColumnIndex("id")));
            ayat.setSura_id(cursor.getString(cursor.getColumnIndex("sura_id")));
            ayat.setVerse_id(cursor.getString(cursor.getColumnIndex("verse_id")));
            ayat.setArabic_indopak(cursor.getString(cursor.getColumnIndex("arabic_indopak")));
            ayat.setTrans(cursor.getString(cursor.getColumnIndex("trans")));
            ayat.setBn_muhi(cursor.getString(cursor.getColumnIndex("bn_muhi")));
            ayat.setPages(cursor.getString(cursor.getColumnIndex("pages")));
            ayat.setPara(cursor.getString(cursor.getColumnIndex("para")));
            ayatArrayList.add(ayat);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        return ayatArrayList;
    }

}
