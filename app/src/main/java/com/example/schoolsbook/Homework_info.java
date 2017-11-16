package com.example.schoolsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework_info extends AppCompatActivity {
    EditText edithomework_name, editfinish_time, editinfo;

    long cnt = 0;

    DatabaseReference databaseA1;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mCountRef = mRootRef.child("Count");

    Button btn_ok;
    Button btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_info);

        Intent intent = getIntent();

        databaseA1 = FirebaseDatabase.getInstance().getReference("Homework_info");

        edithomework_name = (EditText) findViewById(R.id.homework_name);
        editfinish_time = (EditText) findViewById(R.id.finish_time);
        editinfo = (EditText) findViewById(R.id.info);

        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_no = (Button)findViewById(R.id.btn_no);

    }

    protected void onStart(){
        super.onStart();

        mCountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("되긴되니?", "ㅇ..ㅜ");
                cnt = dataSnapshot.getValue(Long.class);
                Log.i("여기들어아?", "ㅜㅜㅜㅜㅜ..ㅜ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mCountRef.setValue(++cnt);
                addForm();
                finish();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });


        }

    private void addForm() {
        Log.i("애드폼이다 제발 들어와", "제발들어오면안돼?");
        String h_n = edithomework_name.getText().toString().trim();
        String f_t = editfinish_time.getText().toString().trim();
        String in = editinfo.getText().toString().trim();

        String id = databaseA1.push().getKey();

        Information information = new Information(id, h_n, f_t, in);
        databaseA1.child("Info_Details" + cnt).setValue(information);

        Toast.makeText(this, "추가완료", Toast.LENGTH_LONG).show();
    }
}
