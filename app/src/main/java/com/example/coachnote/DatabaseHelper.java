package com.example.coachnote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Club.db";
    private static final int DATABASE_VERSION      = 1;

    /* Club members table details */
    public static final String CLUBMEMBERS_TABLE_NAME = "ClubMembers";
    public static final String CLUBMEMBERS_COL_1 = "ID";
    public static final String CLUBMEMBERS_COL_2 = "MemberName";
    public static final String CLUBMEMBERS_COL_3 = "PassStartDate";
    public static final String CLUBMEMBERS_COL_4 = "PassEndDate";
    public static final String CLUBMEMBERS_COL_5 = "AssistingMember";


    private static final String DATABASE_CREATE_CLUBMEMBERS = "create table "
            + CLUBMEMBERS_TABLE_NAME + "(" + CLUBMEMBERS_COL_1 + " integer primary key autoincrement, "
            + CLUBMEMBERS_COL_2 + " string, "
            + CLUBMEMBERS_COL_3 + " string, "
            + CLUBMEMBERS_COL_4 + " string, "
            + CLUBMEMBERS_COL_5 + " string);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CLUBMEMBERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CLUBMEMBERS_TABLE_NAME);
        onCreate(db);
        /***********************************************/
        /* In the final version it has to be modified. */
        /***********************************************/
    }

    public List<ClubMember> allPlayers() {
        List<ClubMember> clubMemberList = new ArrayList<>();
        String selectQuery = "SELECT  ID, MemberName FROM " + CLUBMEMBERS_TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ClubMember clubMember = new ClubMember();
                clubMember.setClubMemberID(cursor.getInt(0));
                clubMember.setClubMemberName(cursor.getString(1));
                clubMemberList.add(clubMember);
            } while (cursor.moveToNext());
        }

        db.close();
        return clubMemberList;
    }

    public boolean insertClubMember(String name,String startDate,String endDate, String assistingMember) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLUBMEMBERS_COL_2,name);
        contentValues.put(CLUBMEMBERS_COL_3,startDate);
        contentValues.put(CLUBMEMBERS_COL_4,endDate);
        contentValues.put(CLUBMEMBERS_COL_5,assistingMember);
        long result = db.insert(CLUBMEMBERS_TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}
