package com.example.schoolsbook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Homework_info extends Activity {
    private static final String TAG = "Homework_info";

    FirebaseDatabase database;

    DatabaseReference myRef;


    TextView name_t;
    EditText homework_name;
    TextView end_t;
    EditText finish_time;
    TextView de_t;
    EditText de;
    Button btn_ok;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_info);

        name_t = (TextView)findViewById(R.id.name_t);
        homework_name = (EditText)findViewById(R.id.homework_name);
        end_t = (TextView)findViewById(R.id.end_t);
         finish_time= (EditText)findViewById(R.id.finish_time);
         de_t = (TextView)findViewById(R.id.de_t);
        de = (EditText)findViewById(R.id.de);
        btn_ok = (Button)findViewById(R.id.btn_ok);

        database = FirebaseDatabase.getInstance();
        database = FirebaseDatabase.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef =database.getReference("homework");
        myRef =database.getReference("finish");
        myRef =database.getReference("det");

        //버튼 이벤트
        btn_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newMessage1 = homework_name.getText().toString();
                String newMessage2 = finish_time.getText().toString();
                String newMessage3 = de.getText().toString();
                myRef.setValue(newMessage1);
                myRef.setValue(newMessage2);
                myRef.setValue(newMessage3);

            }
        });

//        //Read from the database
//        //그리고 데이터베이스에 변경사항이 있으면 실행된다.
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //This method is called once with the initial value and again
//                //whenever data at this loction is updated.
//                String value = dataSnapshot.getValue(String.class);
//                //데이터를 화면에 출력해 준다.
//                homework_name.setText(value);
//                Log.d(TAG, "Value is : " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //Failed to read value
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//        });
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //This method is called once with the initial value and again
//                //whenever data at this loction is updated.
//                String value = dataSnapshot.getValue(String.class);
//                //데이터를 화면에 출력해 준다.
//                finish_time.setText(value);
//                Log.d(TAG, "Value is : " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //Failed to read value
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//        });
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //This method is called once with the initial value and again
//                //whenever data at this loction is updated.
//                String value = dataSnapshot.getValue(String.class);
//                //데이터를 화면에 출력해 준다.
//                de.setText(value);
//                Log.d(TAG, "Value is : " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //Failed to read value
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//        });


    }
}
