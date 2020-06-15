package com.example.coachnote;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InsertNewClubMember extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editStartDate,editEndDate,placeholderAssistant;
    Button btnSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_new_club_member);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.insertName);
        editStartDate = (EditText)findViewById(R.id.insertStartDate);
        editEndDate = (EditText)findViewById(R.id.insertEndDate);
        /* It is temporal it has to be the place of croll list */
        placeholderAssistant = null;

        btnSaveData = (Button)findViewById(R.id.commitInsertsButton);
        btnSaveData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
/*        viewAll();
        UpdateData();
        DeleteData();*/
    }

    public  void AddData() {
        btnSaveData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertClubMember(
                                editName.getText().toString(),
                                editStartDate.getText().toString(),
                                editEndDate.getText().toString(),
                                null
                        );

                        if (isInserted == true)
                            Toast.makeText(InsertNewClubMember.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(InsertNewClubMember.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
