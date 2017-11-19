package com.example.schoolsbook.Homework;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.schoolsbook.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*
1.INITIALIZE FIREBASE DB
2.INITIALIZE UI
3.DATA INPUT
 */
public class InputHomework extends AppCompatActivity {

    Homework hhh = new Homework(this);

//    DatabaseReference db;
//    FirebaseHelper helper;
//    CustomAdapter adapter;
//    ListView lv;
//    EditText nameEditTxt, timeTxt, infoTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

//        lv = (ListView) findViewById(R.id.lv);
//        //INITIALIZE FIREBASE DB
//        db = FirebaseDatabase.getInstance().getReference();
//        helper = new FirebaseHelper(db);
//        //ADAPTER
//        adapter = new CustomAdapter(this, helper.retrieve());
//        lv.setAdapter(adapter);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                displayInputDialog();
//            }
//        });
    }
//    //DISPLAY INPUT DIALOG
//    private void displayInputDialog() {
//        Dialog d = new Dialog(this);
//        d.setTitle("과제추가");
//        d.setContentView(R.layout.input_dialog);
//        nameEditTxt = (EditText) d.findViewById(R.id.nameEditText);
//        timeTxt = (EditText) d.findViewById(R.id.timeEditText);
//        infoTxt = (EditText) d.findViewById(R.id.infoEditText);
//        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);
//        //SAVE
//        saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //GET DATA
//                String name = nameEditTxt.getText().toString();
//                String time = timeTxt.getText().toString();
//                String info = infoTxt.getText().toString();
//                //SET DATA
//                Information i = new Information();
//                i.setName(name);
//                i.setTime(time);
//                i.setInfo(info);
//                //SIMPLE VALIDATION
//                if (name != null && name.length() > 0) {
//                    //THEN SAVE
//                    if (helper.save(i)) {
//                        //IF SAVED CLEAR EDITXT
//                        nameEditTxt.setText("");
//                        timeTxt.setText("");
//                        infoTxt.setText("");
//                        adapter = new CustomAdapter(InputHomework.this, helper.retrieve());
//                        lv.setAdapter(adapter);
//                    }
//                } else {
//                    Toast.makeText(InputHomework.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        d.show();
//    }

}