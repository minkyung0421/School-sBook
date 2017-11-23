package com.example.schoolsbook.Homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.schoolsbook.AddHomework;
import com.example.schoolsbook.AddHomeworkList;
import com.example.schoolsbook.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 최민경 on 2017-11-08.
 */

public class Homework extends AppCompatActivity {
    EditText editName, editTime, editInfo;

    DatabaseReference databasehomework;

    ListView listViewhomework;
    ScrollView scrollview;

    List<AddHomework> homeworkList;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_homework);
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        databasehomework = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework");
        Log.i("여기는 여기입니당", "여이이이");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });
    }
        listViewhomework.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AddHomework homework = homeworkList.get(i);
                showUpdateDeleteDialog(homework.getId(), homework.getName());
                return true;
            }
        });
        listViewhomework.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                scrollview.requestDisallowInterceptTouchEvent(true);

                return false;

            }

        });
    }

    protected void onStart() {
        super.onStart();
        databasehomework.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                homeworkList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddHomework homework = postSnapshot.getValue(AddHomework.class);
                    homeworkList.add(homework);
                }
                AddHomeworkList home = new AddHomeworkList(Homework.this, homeworkList);
                listViewhomework.setAdapter(home);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    //    //DISPLAY INPUT DIALOG
    private void displayInputDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.input_dialog, null);
        dialogBuilder.setView(dialogView);

        editName = (EditText) dialogView.findViewById(R.id.nameEditText);
        editTime = (EditText) dialogView.findViewById(R.id.timeEditText);
        editInfo = (EditText) dialogView.findViewById(R.id.infoEditText);

        listViewhomework = (ListView) findViewById(R.id.lv);

        dialogBuilder.setTitle("과제추가");
        final AlertDialog b = dialogBuilder.create();
        b.show();

        homeworkList = new ArrayList<>();

        Button saveBtn = (Button) dialogView.findViewById(R.id.saveBtn);
        //SAVE

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHomework();
            }
        });
    }

    private void showUpdateDeleteDialog(final String id, String name) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.modify_homework, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.nameEditText);
        final EditText editTextTime = (EditText) dialogView.findViewById(R.id.timeEditText);
        final EditText editTextInfo = (EditText) dialogView.findViewById(R.id.infoEditText);

        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.Update);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.Delete);

        dialogBuilder.setTitle("Updatinng Homwork" + name);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String yy = editTextTime.getText().toString().trim();
                String info = editTextInfo.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    updateHomework(id, name, yy, mm, dd, info);
                    b.dismiss();
                }
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                deleteHomework(id);
                b.dismiss();
            }
        });
    }

    private boolean deleteHomework(String id) {
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework").child(id);

        //remove
        dR.removeValue();

        Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();

        return true;
    }

    private boolean updateHomework(String id, String name, String yy, String mm, String dd, String info) {
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework").child(id);

        //updating
        AddHomework ad = new AddHomework(id, name, yy, mm, dd, info);
        dR.setValue(ad);
        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void addHomework() {
        String name = editName.getText().toString().trim();
        String time = editTime.getText().toString().trim();
        String info = editInfo.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {
            Intent intent = getIntent();
            String code = intent.getStringExtra("code");

            String id = databasehomework.push().getKey();
            AddHomework ad = new AddHomework(id, name, yy, mm ,dd, info);
            databasehomework.child(id).setValue(ad);

            editName.setText("");
            editTime.setText("");
            editInfo.setText("");

            Toast.makeText(this, "add", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }

        FirebaseDatabase.getInstance().getReference("new Group").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intent intent = getIntent();
                String code = intent.getStringExtra("code");
                String name = (String) dataSnapshot.child(code).child("name").getValue();
                String time = (String) dataSnapshot.child(code).child("time").getValue();
                String info = (String) dataSnapshot.child(code).child("info").getValue();

                TextView nameTxt = (TextView) findViewById(R.id.nameTxt);
                TextView timeTxt = (TextView) findViewById(R.id.timeTxt);
                TextView infoTxt = (TextView) findViewById(R.id.infoTxt);

                nameTxt.setText(name);
                timeTxt.setText(time);
                infoTxt.setText(info);
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}


