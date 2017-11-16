package com.example.schoolsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by 최민경 on 2017-11-15.
 */

public class Add_homeworklist extends AppCompatActivity {

    public Add_homeworklist(Homework homework){};

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_homework);

        //빈 데이터 리스트 생성
        final ArrayList<String> items = new ArrayList<String>();
        //ArrayAdapter생성 아이템 view를 선택(single choice) 가능하도록 만듬
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simplae_list_item_single_choice, items);

        //listView 생성 및 adapter지정
        final ListView listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");

        FirebaseDatabase.getInstance().getReference("Homework_info").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intent intent = getIntent();
                String code = intent.getStringExtra("code");
                String homework_name = (String)dataSnapshot.child(code).child("homework_info").getValue();
                String finish_time = (String)dataSnapshot.child(code).child("finish_time").getValue();
                String info = (String)dataSnapshot.child(code).child("info").getValue();

                Log.i("값을 받아오자!", homework_name);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })
    }
}
