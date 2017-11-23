package com.example.schoolsbook;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by LG on 2017-11-07.
 */
public class FirstForm extends AppCompatActivity
{

    EditText editSchool, editGrade, editClasses, editKey, editMon_1, editMon_2, editMon_3, editMon_4, editMon_5, editMon_6, editMon_7, editTue_1,editTue_2,editTue_3,editTue_4,editTue_5, editTue_6,editTue_7,editWed_1,editWed_2, editWed_3, editWed_4, editWed_5, editWed_6,editWed_7,editThu_1,editThu_2,editThu_3,editThu_4,editThu_5,editThu_6,editThu_7,editFri_1,editFri_2,editFri_3,editFri_4,editFri_5,editFri_6,editFri_7;

    DatabaseReference databaseA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_first);

        databaseA = FirebaseDatabase.getInstance().getReference("new Group");
//        Intent intent = getIntent();
//        String code = intent.getStringExtra("code");
        editSchool = (EditText) findViewById(R.id.학교_e);
        editGrade = (EditText) findViewById(R.id.학년_e);
        editClasses = (EditText)findViewById(R.id.반_e);
        editKey = (EditText)findViewById(R.id.인증키_e);
        editMon_1=(EditText)findViewById(R.id.mon_1);
        editMon_2=(EditText)findViewById(R.id.mon_2);
        editMon_3=(EditText)findViewById(R.id.mon_3);
        editMon_4=(EditText)findViewById(R.id.mon_4);
        editMon_5=(EditText)findViewById(R.id.mon_5);
        editMon_6=(EditText)findViewById(R.id.mon_6);
        editMon_7=(EditText)findViewById(R.id.mon_7);
        editTue_1=(EditText)findViewById(R.id.tue_1);
        editTue_2=(EditText)findViewById(R.id.tue_2);
        editTue_3=(EditText)findViewById(R.id.tue_3);
        editTue_4=(EditText)findViewById(R.id.tue_4);
        editTue_5=(EditText)findViewById(R.id.tue_5);
        editTue_6=(EditText)findViewById(R.id.tue_6);
        editTue_7=(EditText)findViewById(R.id.tue_7);
        editWed_1=(EditText)findViewById(R.id.wed_1);
        editWed_2=(EditText)findViewById(R.id.wed_2);
        editWed_3=(EditText)findViewById(R.id.wed_3);
        editWed_4=(EditText)findViewById(R.id.wed_4);
        editWed_5=(EditText)findViewById(R.id.wed_5);
        editWed_6=(EditText)findViewById(R.id.wed_6);
        editWed_7=(EditText)findViewById(R.id.wed_7);
        editThu_1=(EditText)findViewById(R.id.thu_1);
        editThu_2=(EditText)findViewById(R.id.thu_2);
        editThu_3=(EditText)findViewById(R.id.thu_3);
        editThu_4=(EditText)findViewById(R.id.thu_4);
        editThu_5=(EditText)findViewById(R.id.thu_5);
        editThu_6=(EditText)findViewById(R.id.thu_6);
        editThu_7=(EditText)findViewById(R.id.thu_7);
        editFri_1=(EditText)findViewById(R.id.fri_1);
        editFri_2=(EditText)findViewById(R.id.fri_2);
        editFri_3=(EditText)findViewById(R.id.fri_3);
        editFri_4=(EditText)findViewById(R.id.fri_4);
        editFri_5=(EditText)findViewById(R.id.fri_5);
        editFri_6=(EditText)findViewById(R.id.fri_6);
        editFri_7=(EditText)findViewById(R.id.fri_7);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addForm();
                finish();
            }
        });
    }

    private void addForm() {
        //getting the values to save
        String school = editSchool.getText().toString().trim();
        String grade = editGrade.getText().toString().trim();
        String classes = editClasses.getText().toString().trim();
        String key = editKey.getText().toString().trim();
        String mon_1=editMon_1.getText().toString().trim();
        String mon_2=editMon_2.getText().toString().trim();
        String mon_3=editMon_3.getText().toString().trim();
        String mon_4=editMon_4.getText().toString().trim();
        String mon_5=editMon_5.getText().toString().trim();
        String mon_6=editMon_6.getText().toString().trim();
        String mon_7=editMon_7.getText().toString().trim();
        String tue_1=editTue_1.getText().toString().trim();
        String tue_2=editTue_2.getText().toString().trim();
        String tue_3=editTue_3.getText().toString().trim();
        String tue_4=editTue_4.getText().toString().trim();
        String tue_5=editTue_5.getText().toString().trim();
        String tue_6=editTue_6.getText().toString().trim();
        String tue_7=editTue_7.getText().toString().trim();
        String wed_1=editWed_1.getText().toString().trim();
        String wed_2=editWed_2.getText().toString().trim();
        String wed_3=editWed_3.getText().toString().trim();
        String wed_4=editWed_4.getText().toString().trim();
        String wed_5=editWed_5.getText().toString().trim();
        String wed_6=editWed_6.getText().toString().trim();
        String wed_7=editWed_7.getText().toString().trim();
        String thu_1=editThu_1.getText().toString().trim();
        String thu_2=editThu_2.getText().toString().trim();
        String thu_3=editThu_3.getText().toString().trim();
        String thu_4=editThu_4.getText().toString().trim();
        String thu_5=editThu_5.getText().toString().trim();
        String thu_6=editThu_6.getText().toString().trim();
        String thu_7=editThu_7.getText().toString().trim();
        String fri_1=editFri_1.getText().toString().trim();
        String fri_2=editFri_2.getText().toString().trim();
        String fri_3=editFri_3.getText().toString().trim();
        String fri_4=editFri_4.getText().toString().trim();
        String fri_5=editFri_5.getText().toString().trim();
        String fri_6=editFri_6.getText().toString().trim();
        String fri_7=editFri_7.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(key)) {
            String iid = databaseA.push().getKey();

            //creating an Artist Object
            Artist artist = new Artist(iid,school,grade,classes,key,mon_1,mon_2,mon_3,mon_4,mon_5,mon_6,mon_7,tue_1,tue_2,tue_3,tue_4,tue_5,tue_6,tue_7,wed_1,wed_2,wed_3,wed_4,wed_5,wed_6,wed_7,thu_1,thu_2,thu_3,thu_4,thu_5,thu_6,thu_7,fri_1,fri_2,fri_3,fri_4,fri_5,fri_6,fri_7);

            //Saving the Artist
            databaseA.child(key).setValue(artist);

            //setting edittext to blank again
            editSchool.setText("");
            editGrade.setText("");
            editClasses.setText("");
            editKey.setText("");
            editMon_1.setText("");
            editMon_2.setText("");
            editMon_3.setText("");
            editMon_4.setText("");
            editMon_5.setText("");
            editMon_6.setText("");
            editMon_7.setText("");
            editTue_1.setText("");
            editTue_2.setText("");
            editTue_3.setText("");
            editTue_4.setText("");
            editTue_5.setText("");
            editTue_6.setText("");
            editTue_7.setText("");
            editWed_1.setText("");
            editWed_2.setText("");
            editWed_3.setText("");
            editWed_4.setText("");
            editWed_5.setText("");
            editWed_6.setText("");
            editWed_7.setText("");
            editThu_1.setText("");
            editThu_2.setText("");
            editThu_3.setText("");
            editThu_4.setText("");
            editThu_5.setText("");
            editThu_6.setText("");
            editThu_7.setText("");
            editFri_1.setText("");
            editFri_2.setText("");
            editFri_3.setText("");
            editFri_4.setText("");
            editFri_5.setText("");
            editFri_6.setText("");
            editFri_7.setText("");
            //displaying a success toast

            Toast.makeText(this, "added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}