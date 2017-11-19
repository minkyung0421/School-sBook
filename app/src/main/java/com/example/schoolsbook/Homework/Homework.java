package com.example.schoolsbook.Homework;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.schoolsbook.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by 최민경 on 2017-11-08.
 */

public class Homework extends Fragment {
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;
    EditText nameEditTxt, timeTxt, infoTxt;

    public Homework() {

    }

    public Homework(Context context) {
    }

    ;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_homework, container, false);

        lv = (ListView) layout.findViewById(R.id.lv);
        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        //ADAPTER
        adapter = new CustomAdapter(getActivity(), helper.retrieve());
        lv.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) layout.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });

        return layout;
    }

    //DISPLAY INPUT DIALOG
    private void displayInputDialog() {
        Dialog d = new Dialog(getActivity());
        d.setTitle("과제추가");
        d.setContentView(R.layout.input_dialog);
        nameEditTxt = (EditText) d.findViewById(R.id.nameEditText);
        timeTxt = (EditText) d.findViewById(R.id.timeEditText);
        infoTxt = (EditText) d.findViewById(R.id.infoEditText);
        Button saveBtn = (Button) d.findViewById(R.id.saveBtn);
        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name = nameEditTxt.getText().toString();
                String time = timeTxt.getText().toString();
                String info = infoTxt.getText().toString();
                //SET DATA
                Information i = new Information();
                i.setName(name);
                i.setTime(time);
                i.setInfo(info);
                //SIMPLE VALIDATION
                if (name != null && name.length() > 0) {
                    //THEN SAVE
                    if (helper.save(i)) {
                        //IF SAVED CLEAR EDITXT
                        nameEditTxt.setText("");
                        timeTxt.setText("");
                        infoTxt.setText("");
                        adapter = new CustomAdapter(getActivity(), helper.retrieve());
                        lv.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getActivity(), "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }
}


