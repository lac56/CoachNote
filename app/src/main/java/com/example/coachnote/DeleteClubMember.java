package com.example.coachnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DeleteClubMember extends AppCompatActivity {

    private SQLiteDatabase clubMemberDatabase;
    private ClubMemberAdapter clubMemberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_club_member);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        clubMemberDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.showClubMembersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        clubMemberAdapter = new ClubMemberAdapter(this, getAllItems());
        recyclerView.setAdapter(clubMemberAdapter);

    }

    private Cursor getAllItems() {
        return clubMemberDatabase.query(
                DatabaseHelper.CLUBMEMBERS_TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DatabaseHelper.CLUBMEMBERS_COL_1 + " ASC"
        );
    }
}