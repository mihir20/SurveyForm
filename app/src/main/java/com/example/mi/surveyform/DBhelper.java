package com.example.mi.surveyform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mi on 26/8/17.
 */

public class DBhelper extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static final String DATABASE_NAME = "SurveyDataBase.db";
    public static final String TABLE_SURVEYDATA = "surveydatabase";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_ADDRESS = "Adress";
    public static final String COLUMN_AGE = "Age";
    public static final String COLUMN_MARRIED = "Married";
    public static final String COLUMN_PWD = "PWD";
    public static final String COLUMN_EDUCATION = "Education";
    public static final String COLUMN_INCOME = "Income";
    public static final String COLUMN_AGE1 = "age1";
    public static final String COLUMN_AGE2 = "age2";
    public static final String COLUMN_AGE3 = "age3";
    public static final String COLUMN_AGE4 = "age4";
    public static final String COLUMN_AGE5 = "age5";
    public static final String COLUMN_TOTAL = "total";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_SURVEYDATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," + COLUMN_ADDRESS + " TEXT," + COLUMN_AGE + " TEXT," +
                COLUMN_MARRIED + " TEXT," + COLUMN_PWD + " TEXT," + COLUMN_EDUCATION + " TEXT," +
                COLUMN_INCOME + " TEXT," + COLUMN_AGE1 + " TEXT," + COLUMN_AGE2 + " TEXT," +
                COLUMN_AGE3 + " TEXT," + COLUMN_AGE4 + " TEXT," + COLUMN_AGE5 + " TEXT," +
                COLUMN_TOTAL + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SURVEYDATA);
        onCreate(sqLiteDatabase);
    }

    public void addToSurveyDatabase(SurveyFormData data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.getName());
        values.put(COLUMN_ADDRESS, data.getAddress());
        values.put(COLUMN_AGE, data.getAge());
        values.put(COLUMN_MARRIED, data.getMarriedStatus());
        values.put(COLUMN_PWD, data.getPwdStatus());
        values.put(COLUMN_EDUCATION, data.getEducationStatus());
        values.put(COLUMN_INCOME, data.getIncome());
        values.put(COLUMN_AGE1, data.getAge1());
        values.put(COLUMN_AGE2, data.getAge2());
        values.put(COLUMN_AGE3, data.getAge3());
        values.put(COLUMN_AGE4, data.getAge4());
        values.put(COLUMN_AGE5, data.getAge5());
        values.put(COLUMN_TOTAL, data.getTotal());

        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert(TABLE_SURVEYDATA, null, values);
        Log.d("ID:", String.valueOf(id));
        db.close();
    }

    public Cursor getDataFromDatabase() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + TABLE_SURVEYDATA + " ",
                null);
    }
}
