package com.rodolfo.mtgarenasettracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SetDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_SETS =
            "CREATE TABLE " + SetContract.SetEntry.TABLE_NAME + " (" +
                    SetContract.SetEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    SetContract.SetEntry.COLUMN_NAME_OBJECT + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_CODE + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_ARENA_CODE + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_TCQPLAYER_ID + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_URI + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_SCRYFALL_URI + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_SEARCH_URI + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_RELEASED_AT + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_SET_TYPE + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_CARD_COUNT + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_PRINTED_SIZE + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_DIGITAL + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_NONFOIL_ONLY + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_FOIL_ONLY + INTEGER_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_BLOC_CODE + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_BLOCK + TEXT_TYPE + COMMA_SEP +
                    SetContract.SetEntry.COLUMN_NAME_ICON_SVG_URI + TEXT_TYPE + " )";

    private static final String SQL_DELETE_SETS =
            "DROP TABLE IF EXISTS " + SetContract.SetEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Set.db";

    public SetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SETS);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_SETS);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
