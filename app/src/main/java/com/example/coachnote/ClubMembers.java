package com.example.coachnote;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ClubMembers extends AppCompatActivity {

    private Context context;

    public void  openInsertNewClubMemberActivity() {
        Intent insertNewClubMemberIntent = new Intent(this, InsertNewClubMember.class);
        startActivity(insertNewClubMemberIntent);
    }

    public void  openDeleteClubMemberActivity() {
        Intent deleteClubMemberIntent = new Intent(this, DeleteClubMember.class);
        startActivity(deleteClubMemberIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_members);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fab Buttons - Add member
        FloatingActionButton addNewMembersFab = findViewById(R.id.fab_action_add_member);

        addNewMembersFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsertNewClubMemberActivity();
            }
        });

        // Delete member
        FloatingActionButton deleteMembersFab = findViewById(R.id.fab_action_delete_member);

        deleteMembersFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteClubMemberActivity();
            }
        });

        //
        context=this;

        // Create DatabaseHelper instance
        DatabaseHelper dataHelper = new DatabaseHelper(context);
        // Reference to TableLayout
        TableLayout tableLayout=(TableLayout)findViewById(R.id.showMembersTableLayout);

        // Add header row
        TableRow rowHeader = new TableRow(context);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText={"ID","Name","StartDate","EndDate","Assist"};

        // Build the header row
        for(String c:headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);

        // Get data from sqlite database and add them to the table
        // Open the database for reading
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        // Start the transaction.
        db.beginTransaction();

        try
        {
            // Build the query
            String selectQuery = "SELECT * FROM "+ DatabaseHelper.CLUBMEMBERS_TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery,null);
            if(cursor.getCount() >0)
            {
                while (cursor.moveToNext()) {
                    // Read columns data
                    int clubmember_id = cursor.getInt(cursor.getColumnIndex("ID"));
                    String clubmember_member_name = cursor.getString(cursor.getColumnIndex("MemberName"));
                    String clubmember_pass_start_date = cursor.getString(cursor.getColumnIndex("PassStartDate"));
                    String clubmember_pass_end_date = cursor.getString(cursor.getColumnIndex("PassEndDate"));
                    String clubmember_assisting_member = cursor.getString(cursor.getColumnIndex("AssistingMember"));

                    // data rows
                    TableRow row = new TableRow(context);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    // We make the same process like before at Header row
                    String[] colText={clubmember_id+"",clubmember_member_name,clubmember_pass_start_date,clubmember_pass_end_date,clubmember_assisting_member};
                    for(String text:colText) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(16);
                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tableLayout.addView(row);

                }

            }
            db.setTransactionSuccessful();

        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }
        finally
        {
            db.endTransaction();
            // End the transaction.
            db.close();
        }
    }

}
