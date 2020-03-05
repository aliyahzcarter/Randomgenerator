package com.example.random2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    // Database contract
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "infodb";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_COLOR = "color";
    private static final String KEY_NUMBER = "number";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    //constructor
    @Override
    public void onCreate(SQLiteDatabase db) {

        //create database
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_COLOR + " INTEGER,"
                + KEY_NUMBER + " TEXT"+")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }


    // Adding information to database
    void insertUserDetails(int color, String number) {

        //database  in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_COLOR, color);
        cValues.put(KEY_NUMBER, number);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users, null, cValues);

        //close database connection
        db.close();
    }

}