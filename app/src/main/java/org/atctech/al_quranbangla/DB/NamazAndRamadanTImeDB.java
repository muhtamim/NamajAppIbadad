package org.atctech.al_quranbangla.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.atctech.al_quranbangla.Model.CityName;
import org.atctech.al_quranbangla.Model.Division;
import org.atctech.al_quranbangla.Model.NamazTimes;
import org.atctech.al_quranbangla.Model.RamadanTimes;

import java.util.ArrayList;

public class NamazAndRamadanTImeDB {
    private Cursor cursor;
    private DatabaseHelper2 databaseHelper;

    public NamazAndRamadanTImeDB(Context context) {
        databaseHelper = new DatabaseHelper2(context);
    }

    public ArrayList<CityName> GetAllCityName() {
        ArrayList<CityName> cityNameArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM city", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CityName cityName = new CityName();
            cityName.setId(cursor.getString(cursor.getColumnIndex("id")));
            cityName.setName(cursor.getString(cursor.getColumnIndex("name")));

            cityNameArrayList.add(cityName);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return cityNameArrayList;
    }

    public ArrayList<NamazTimes> GetAllCitysNamazTime(int cityID) {
        ArrayList<NamazTimes> namazTimes = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM namaz_time WHERE city_id =" + cityID, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NamazTimes times = new NamazTimes();
            times.setId(cursor.getString(cursor.getColumnIndex("id")));
            times.setCity_id(cursor.getString(cursor.getColumnIndex("city_id")));
            times.setFajr(cursor.getString(cursor.getColumnIndex("fajr")));
            times.setDhuhr(cursor.getString(cursor.getColumnIndex("dhuhr")));
            times.setAsr(cursor.getString(cursor.getColumnIndex("asr")));
            times.setMaghrib(cursor.getString(cursor.getColumnIndex("maghrib")));
            times.setIsha(cursor.getString(cursor.getColumnIndex("isha")));

            namazTimes.add(times);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return namazTimes;
    }

    public ArrayList<RamadanTimes> GetAllCitysRamadanTime(int cityID) {
        ArrayList<RamadanTimes> ramadanTimesArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ramadan_times WHERE city_id =" + cityID, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            RamadanTimes ramadanTimes = new RamadanTimes();
            ramadanTimes.setId(cursor.getString(cursor.getColumnIndex("id")));
            ramadanTimes.setCity_id(cursor.getString(cursor.getColumnIndex("city_id")));
            ramadanTimes.setDate(cursor.getString(cursor.getColumnIndex("date")));
            ramadanTimes.setDay(cursor.getString(cursor.getColumnIndex("day")));
            ramadanTimes.setSeheri(cursor.getString(cursor.getColumnIndex("seheri")));
            ramadanTimes.setIftar(cursor.getString(cursor.getColumnIndex("iftar")));


            ramadanTimesArrayList.add(ramadanTimes);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return ramadanTimesArrayList;
    }


    public ArrayList<Division> GetAllDivisionName() {
        ArrayList<Division> divisionNameArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT id,c_id,name FROM division", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Division divisions = new Division();
            divisions.setId(cursor.getInt(cursor.getColumnIndex("id")));
            divisions.setC_id(cursor.getInt(cursor.getColumnIndex("c_id")));
            divisions.setName(cursor.getString(cursor.getColumnIndex("name")));

            divisionNameArrayList.add(divisions);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return divisionNameArrayList;
    }


}
