package com.example.mi.surveyform;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mi on 26/8/17.
 */

public class DBhelper extends SQLiteOpenHelper {

    private static int dbVersion = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_SURVEYDATA = "surveydata";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_ADDRESS="Adress";
    public static final String COLUMN_AGE="Age";
    public static final String COLUMN_MARRIED="Married";
    public static final String COLUMN_PWD="PWD";
    public static final String COLUMN_EDUCATION = "Max. Education";
    public static final String COLUMN_INCOME = "Monthly Income";
    public static final String COLUMN_AGE1 ="0-6";
    public static final String COLUMN_AGE2 ="7-15";
    public static final String COLUMN_AGE3 ="16-23";
    public static final String COLUMN_AGE4 ="24-60";
    public static final String COLUMN_AGE5 ="60+";
    public static final String COLUMN_TOTAL ="total";



    public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_SURVEYDATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT " + COLUMN_ADDRESS + " TEXT " + COLUMN_AGE + " TEXT " +
                COLUMN_MARRIED + " TEXT " + COLUMN_PWD + " TEXT " + COLUMN_EDUCATION + " TEXT " +
                COLUMN_INCOME + " TEXT " + COLUMN_AGE1+ " TEXT " + COLUMN_AGE2 + " TEXT " +
                COLUMN_AGE3 + " TEXT " + COLUMN_AGE4 + " TEXT " + COLUMN_AGE5 + " TEXT " +
                COLUMN_TOTAL + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
