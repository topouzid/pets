package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
            PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PetEntry.COLUMN_NAME + " TEXT NOT NULL, " +
            PetEntry.COLUMN_BREED + " TEXT, " +
            PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, " +
            PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0" +
            ");";

    // Database Version. If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    /* Database Name */
    private static final String DATABASE_NAME = "shelter.db";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public PetDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
