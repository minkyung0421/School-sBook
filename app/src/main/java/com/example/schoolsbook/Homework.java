package com.example.schoolsbook;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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
    EditText nameeddit, yy_edit, mm_edit, dd_edit, ww_edit, infoedit;

    DatabaseReference databaseHomework;

    ListView listViewWork;

    List<AddHomework> workList;

    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        Intent intent = getIntent();
        String code  = intent.getStringExtra("code");

        databaseHomework = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework");

        nameeddit = (EditText)findViewById(R.id.nameedit);
        yy_edit = (EditText)findViewById(R.id.yy_edit);
        mm_edit = (EditText)findViewById(R.id.mm_edit);
        dd_edit = (EditText)findViewById(R.id.dd_edit);
        ww_edit = (EditText)findViewById(R.id.ww_edit);
        infoedit = (EditText)findViewById(R.id.infoedit);
        infoedit.setHorizontallyScrolling(false);


        listViewWork = (ListView)findViewById(R.id.listViewWorks);

        workList = new ArrayList<>();
        Log.i("버튼 누르기 전", "전입니당");
        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWork();
            }
        });
        listViewWork.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AddHomework home = workList.get(i);
                showUpdateDeleteDialog(home.getId(), home.getName());
                return true;
            }
        });

        Button cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameeddit.setText("");
                yy_edit.setText("");
                mm_edit.setText("");
                dd_edit.setText("");
                ww_edit.setText("");
                infoedit.setText("");
            }
        });

        ImageButton homepage = (ImageButton)findViewById(R.id.homepage);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String code  = intent.getStringExtra("code");
                Intent i = new Intent(Homework.this, Homepage_schoolbook.class);
                i.putExtra("code",code);
                startActivity(i);
                finish();
            }
        });

        ImageButton gallery = (ImageButton)findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String code  = intent.getStringExtra("code");
                Intent i = new Intent(Homework.this, InputGallery.class);
                i.putExtra("code",code);
                startActivity(i);
                finish();
            }
        });

    }

    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseHomework.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                workList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddHomework home = postSnapshot.getValue(AddHomework.class);
                    //adding artist to the list
                    workList.add(home);
                }

                //creating adapter
                AddHomeworkList list = new AddHomeworkList(Homework.this, workList);
                //attaching adapter to the listview
                listViewWork.setAdapter(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDeleteDialog(final String id, String name){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.modify_homework, null);
        dialogBuilder.setView(dialogView);

        final EditText editText5 = (EditText) dialogView.findViewById(R.id.editText5);
        final EditText yy_e = (EditText)dialogView.findViewById(R.id.yy_e);
        final EditText mm_e = (EditText)dialogView.findViewById(R.id.mm_e);
        final EditText dd_e = (EditText)dialogView.findViewById(R.id.dd_e);
        final EditText ww_e = (EditText)dialogView.findViewById(R.id.ww_e);
        final EditText infoEdit = (EditText)dialogView.findViewById(R.id.infoEdit);
        final Button Update = (Button)dialogView.findViewById(R.id.Update);
        final Button Delete = (Button)dialogView.findViewById(R.id.Delete);


        dialogBuilder.setTitle("Updatinng Homework");
        final AlertDialog b = dialogBuilder.create();
        b.show();

        Update.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name = editText5.getText().toString().trim();
                String yy = yy_e.getText().toString().trim();
                String mm = mm_e.getText().toString().trim();
                String dd = dd_e.getText().toString().trim();
                String ww = ww_e.getText().toString().trim();
                String info = infoEdit.getText().toString().trim();

                if(!TextUtils.isEmpty(name)){
                    updateWork(id, name, yy, mm, dd, ww, info);
                    b.dismiss();
                }
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteWork(id);
                b.dismiss();
            }
        });
    }

    private boolean deleteWork(String id){
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework").child(id);

        dR.removeValue();

        Toast.makeText(getApplicationContext(), "과제 삭제 완료!", Toast.LENGTH_LONG).show();

        return true;
    }

    private boolean updateWork(String id, String name, String yy, String mm ,String dd, String ww, String info){
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("homework").child(id);

        AddHomework home = new AddHomework(id, name, yy, mm, dd, ww, info);
        dR.setValue(home);
        Toast.makeText(getApplicationContext(), "과제 업데이트 완료!", Toast.LENGTH_LONG).show();
        return true;
    }

    private void addWork(){
        String name = nameeddit.getText().toString().trim();
        String yy = yy_edit.getText().toString().trim();
        String mm = mm_edit.getText().toString().trim();
        String dd = dd_edit.getText().toString().trim();
        String ww = ww_edit.getText().toString().trim();
        String info = infoedit.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {
            Intent intent = getIntent();
            String code = intent.getStringExtra("code");

            String id = databaseHomework.push().getKey();
            AddHomework home = new AddHomework(id, name, yy, mm, dd, ww, info);
            databaseHomework.child(id).setValue(home);

            nameeddit.setText("");
            yy_edit.setText("");
            mm_edit.setText("");
            dd_edit.setText("");
            ww_edit.setText("");
            infoedit.setText("");
            Toast.makeText(this, "과제추가되었습니다! 화이팅..", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "과제명을 입력해 주세요!", Toast.LENGTH_LONG).show();
        }
    }
}


