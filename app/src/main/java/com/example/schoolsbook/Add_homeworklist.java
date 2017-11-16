package com.example.schoolsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 최민경 on 2017-11-15.
 */

public class Add_homeworklist extends AppCompatActivity {
    Homework hh = new Homework(this);
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = database.getReference("Homework_info");

    ArrayList<String> name = new ArrayList<>();
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        listView = (ListView) findViewById(R.id.listView1);
    }

    //RETRIEVE
    private void retrieveData(){
        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("여기 들어와?", "여기이이이이이이이이이이이");
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void getUpdates(DataSnapshot ds) {
        name.clear();

        if(name.size() > 0){
            ArrayAdapter adapter = new ArrayAdapter(Add_homeworklist.this, R.layout.listitem_homework, name);
            listView.setAdapter(adapter);
        }else{
            Toast.makeText(Add_homeworklist.this, "No data", Toast.LENGTH_SHORT).show();
        }
    }


}


