package com.example.schoolsbook.Homework;

import android.util.Log;

import com.example.schoolsbook.TestHomework.Spacecraft;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by 최민경 on 2017-11-19.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<Information> informations=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(Information information)
    {
        if(information==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Homework_info").push().setValue(information);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        informations.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Information information=ds.getValue(Information.class);
            informations.add(information);
        }
    }
    //RETRIEVE
    public ArrayList<Information> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
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
        return informations;
    }
}
