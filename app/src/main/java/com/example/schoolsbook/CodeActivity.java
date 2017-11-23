package com.example.schoolsbook;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CodeActivity extends AppCompatActivity {

    EditText editcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        editcode = (EditText)findViewById(R.id.코드_e);
        Button btn01 = (Button)findViewById(R.id.button);
        Button btn02 = (Button)findViewById(R.id.button2);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodeActivity.this, FirstForm.class);
                startActivity(intent);
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String code = editcode.getText().toString().trim();

                FirebaseDatabase.getInstance().getReference("new Group").addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String code = editcode.getText().toString().trim();
                                String nn = (String) dataSnapshot.child(code).child("key").getValue();

                                // Log.d("이거는nn", nn);
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    String kk = (String) snapshot.getKey();
                                    Log.d("오오오오", kk);
                                    if (!(kk.equals(code))) {
                                        Log.d("이거이거이거", "으헝");
                                        Toast.makeText(CodeActivity.this, "없는 키입니다!", Toast.LENGTH_LONG);
                                    }
                                }
                                if (nn.equals(code)) {
                                    Intent intent = new Intent(CodeActivity.this, Homepage_schoolbook.class);
                                    intent.putExtra("code",code);
                                    startActivity(intent);
                                    Log.d("이거는2nn", nn);

                                }

                                Log.d("오오", code);


                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });



    }

}
