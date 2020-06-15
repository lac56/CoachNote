package com.example.coachnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button goToClubMembers;
    private Button gotoMembersStatuses;
    private Button goToGymStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*This part controls the first button goToClubMembers*/
        goToClubMembers = (Button) findViewById(R.id.goToClubMembersButton);
        goToClubMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClubMembersActivity();
            }
        });

        /*This part controls the second button goToGymStatistics*/
        goToGymStatistics = (Button) findViewById(R.id.gotoMembersStatusesButton);
        goToGymStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGymStatisticsActivity();
            }
        });

        /*This part controls the third button gotoMembersStatuses*/
        gotoMembersStatuses = (Button) findViewById(R.id.goToGymStatisticsButton);
        gotoMembersStatuses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMembersStatusesActivity();
            }
        });

    }

    public void  openClubMembersActivity() {
        /* This part need to be modifcated */
        Intent clubMembersIntent = new Intent(this, ClubMembers.class);
        startActivity(clubMembersIntent);
    }

    public void openMembersStatusesActivity(){
        /* This part need to be modifcated */
        Intent membersStatusesIntent = new Intent(this, MembersStatuses.class);
        startActivity(membersStatusesIntent);
    }

    public void openGymStatisticsActivity(){
        /* This part need to be modifcated */
        Intent gymStatisticsIntent = new Intent(this, GymStatistics.class);
        startActivity(gymStatisticsIntent);
    }

}
