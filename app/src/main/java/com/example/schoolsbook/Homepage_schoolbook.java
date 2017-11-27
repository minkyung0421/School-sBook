package com.example.schoolsbook;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Homepage_schoolbook extends AppCompatActivity {

    EditText editName,editPhone;

    DatabaseReference databasePhones;

    ListView listViewPhones;


    List<Phone> phoneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Intent intent = getIntent();
        String code  = intent.getStringExtra("code");
        //  String id = databasePhones.push().getKey();
        databasePhones = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("phone");
        Log.d("하하",code);
        Log.d("하하",code);Log.d("하하",code);
        Log.d("하하",code);

        editName = (EditText)findViewById(R.id.name);
        editPhone = (EditText)findViewById(R.id.phone);

        listViewPhones = (ListView)findViewById(R.id.listViewPhones);

        phoneList = new ArrayList<>();

        Button enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("하은", "before addPhone");
                addPhone();
            }
        });
        listViewPhones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Phone phone = phoneList.get(i);
                showUpdateDeleteDialog(phone.getId(), phone.getPhonename());
                return true;
            }
        });

        ImageButton homework = (ImageButton) findViewById(R.id.homework);
        homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String code  = intent.getStringExtra("code");
                Intent i = new Intent(Homepage_schoolbook.this, Homework.class);
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
                Intent i = new Intent(Homepage_schoolbook.this, InputGallery.class);
                i.putExtra("code",code);
                startActivity(i);
                finish();
            }
        });

        FirebaseDatabase.getInstance().getReference("new Group").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intent intent = getIntent();
                String code = intent.getStringExtra("code");
                String mon1 = (String) dataSnapshot.child(code).child("mon_1").getValue();
                String mon2 = (String) dataSnapshot.child(code).child("mon_2").getValue();
                String mon3 = (String) dataSnapshot.child(code).child("mon_3").getValue();
                String mon4 = (String) dataSnapshot.child(code).child("mon_4").getValue();
                String mon5 = (String) dataSnapshot.child(code).child("mon_5").getValue();
                String mon6 = (String) dataSnapshot.child(code).child("mon_6").getValue();
                String mon7 = (String) dataSnapshot.child(code).child("mon_7").getValue();
                String tue1 = (String) dataSnapshot.child(code).child("tue_1").getValue();
                String tue2 = (String) dataSnapshot.child(code).child("tue_2").getValue();
                String tue3 = (String) dataSnapshot.child(code).child("tue_3").getValue();
                String tue4 = (String) dataSnapshot.child(code).child("tue_4").getValue();
                String tue5 = (String) dataSnapshot.child(code).child("tue_5").getValue();
                String tue6 = (String) dataSnapshot.child(code).child("tue_6").getValue();
                String tue7 = (String) dataSnapshot.child(code).child("tue_7").getValue();
                String wed1 = (String) dataSnapshot.child(code).child("wed_1").getValue();
                String wed2 = (String) dataSnapshot.child(code).child("wed_2").getValue();
                String wed3 = (String) dataSnapshot.child(code).child("wed_3").getValue();
                String wed4 = (String) dataSnapshot.child(code).child("wed_4").getValue();
                String wed5 = (String) dataSnapshot.child(code).child("wed_5").getValue();
                String wed6 = (String) dataSnapshot.child(code).child("wed_6").getValue();
                String wed7 = (String) dataSnapshot.child(code).child("wed_7").getValue();
                String thu1 = (String) dataSnapshot.child(code).child("thu_1").getValue();
                String thu2 = (String) dataSnapshot.child(code).child("thu_2").getValue();
                String thu3 = (String) dataSnapshot.child(code).child("thu_3").getValue();
                String thu4 = (String) dataSnapshot.child(code).child("thu_4").getValue();
                String thu5 = (String) dataSnapshot.child(code).child("thu_5").getValue();
                String thu6 = (String) dataSnapshot.child(code).child("thu_6").getValue();
                String thu7 = (String) dataSnapshot.child(code).child("thu_7").getValue();
                String fri1 = (String) dataSnapshot.child(code).child("fri_1").getValue();
                String fri2 = (String) dataSnapshot.child(code).child("fri_2").getValue();
                String fri3 = (String) dataSnapshot.child(code).child("fri_3").getValue();
                String fri4 = (String) dataSnapshot.child(code).child("fri_4").getValue();
                String fri5 = (String) dataSnapshot.child(code).child("fri_5").getValue();
                String fri6 = (String) dataSnapshot.child(code).child("fri_6").getValue();
                String fri7 = (String) dataSnapshot.child(code).child("fri_7").getValue();



                Log.d("미미a",mon1);
                TextView mon_1 = (TextView) findViewById(R.id.mon_1);
                TextView mon_2 = (TextView) findViewById(R.id.mon_2);
                TextView mon_3 = (TextView) findViewById(R.id.mon_3);
                TextView mon_4 = (TextView) findViewById(R.id.mon_4);
                TextView mon_5 = (TextView) findViewById(R.id.mon_5);
                TextView mon_6 = (TextView) findViewById(R.id.mon_6);
                TextView mon_7 = (TextView) findViewById(R.id.mon_7);
                TextView tue_1 = (TextView) findViewById(R.id.tue_1);
                TextView tue_2 = (TextView) findViewById(R.id.tue_2);
                TextView tue_3 = (TextView) findViewById(R.id.tue_3);
                TextView tue_4 = (TextView) findViewById(R.id.tue_4);
                TextView tue_5 = (TextView) findViewById(R.id.tue_5);
                TextView tue_6 = (TextView) findViewById(R.id.tue_6);
                TextView tue_7 = (TextView) findViewById(R.id.tue_7);
                TextView wed_1 = (TextView) findViewById(R.id.wed_1);
                TextView wed_2 = (TextView) findViewById(R.id.wed_2);
                TextView wed_3 = (TextView) findViewById(R.id.wed_3);
                TextView wed_4 = (TextView) findViewById(R.id.wed_4);
                TextView wed_5 = (TextView) findViewById(R.id.wed_5);
                TextView wed_6 = (TextView) findViewById(R.id.wed_6);
                TextView wed_7 = (TextView) findViewById(R.id.wed_7);
                TextView thu_1 = (TextView) findViewById(R.id.thu_1);
                TextView thu_2 = (TextView) findViewById(R.id.thu_2);
                TextView thu_3 = (TextView) findViewById(R.id.thu_3);
                TextView thu_4 = (TextView) findViewById(R.id.thu_4);
                TextView thu_5 = (TextView) findViewById(R.id.thu_5);
                TextView thu_6 = (TextView) findViewById(R.id.thu_6);
                TextView thu_7 = (TextView) findViewById(R.id.thu_7);
                TextView fri_1 = (TextView) findViewById(R.id.fri_1);
                TextView fri_2 = (TextView) findViewById(R.id.fri_2);
                TextView fri_3 = (TextView) findViewById(R.id.fri_3);
                TextView fri_4 = (TextView) findViewById(R.id.fri_4);
                TextView fri_5 = (TextView) findViewById(R.id.fri_5);
                TextView fri_6 = (TextView) findViewById(R.id.fri_6);
                TextView fri_7 = (TextView) findViewById(R.id.fri_7);


                Log.d("미미",code);
                mon_1.setText(mon1);
                mon_2.setText(mon2);
                mon_3.setText(mon3);
                mon_4.setText(mon4);
                mon_5.setText(mon5);
                mon_6.setText(mon6);
                mon_7.setText(mon7);
                tue_1.setText(tue1);
                tue_2.setText(tue2);
                tue_3.setText(tue3);
                tue_4.setText(tue4);
                tue_5.setText(tue5);
                tue_6.setText(tue6);
                tue_7.setText(tue7);
                wed_1.setText(wed1);
                wed_2.setText(wed2);
                wed_3.setText(wed3);
                wed_4.setText(wed4);
                wed_5.setText(wed5);
                wed_6.setText(wed6);
                wed_7.setText(wed7);
                thu_1.setText(thu1);
                thu_2.setText(thu2);
                thu_3.setText(thu3);
                thu_4.setText(thu4);
                thu_5.setText(thu5);
                thu_6.setText(thu6);
                thu_7.setText(thu7);
                fri_1.setText(fri1);
                fri_2.setText(fri2);
                fri_3.setText(fri3);
                fri_4.setText(fri4);
                fri_5.setText(fri5);
                fri_6.setText(fri6);
                fri_7.setText(fri7);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databasePhones.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                phoneList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Phone phone = postSnapshot.getValue(Phone.class);
                    //adding artist to the list
                    phoneList.add(phone);
                }

                //creating adapter
                PhoneList artistAdapter = new PhoneList(Homepage_schoolbook.this, phoneList);
                //attaching adapter to the listview
                listViewPhones.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void showUpdateDeleteDialog(final String PhoneId, String phonename) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.modify_phone, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextname);
        final EditText editTextPhone = (EditText) dialogView.findViewById(R.id.editTextphone);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Updatinng Phones");
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    updatePhone(PhoneId, name, phone);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePhone(PhoneId);
                b.dismiss();
            }
        });

    }
    /*
    * This method is saving a new artist to the
    * Firebase Realtime Database
    * */
    private boolean deletePhone(String id) {
        //getting the specified artist reference
        Intent intent = getIntent();
        String code  = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("phone").child(id);

        //removing artist
        dR.removeValue();

        Toast.makeText(getApplicationContext(), "전화번호 삭제 완료!", Toast.LENGTH_LONG).show();

        return true;
    }

    private boolean updatePhone(String id, String name, String phone) {
        //getting the specified artist reference
        Intent intent = getIntent();
        String code  = intent.getStringExtra("code");
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("new Group").child(code).child("phone").child(id);

        //updating artist
        Phone p = new Phone(id,name,phone);
        dR.setValue(p);
        Toast.makeText(getApplicationContext(), "전화번호 업데이트 완료!", Toast.LENGTH_LONG).show();
        return true;
    }
    private void addPhone() {

        //getting the values to save
        String name = editName.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(phone)) {
            Intent intent = getIntent();
            String code  = intent.getStringExtra("code");
            //creating an Artist Object
            String id = databasePhones.push().getKey();
            Phone p = new Phone(id, name, phone);
            databasePhones.child(id).setValue(p);

            //setting edittext to blank again
            editName.setText("");
            editPhone.setText("");

            //displaying a success toast
            Toast.makeText(this, "추가 완료", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_LONG).show();
        }


    }
}