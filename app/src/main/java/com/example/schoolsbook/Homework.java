package com.example.schoolsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by 최민경 on 2017-11-08.
 */

public class Homework extends Fragment{
    Button addwork;

    public Homework(){

    }

    public Homework(Context context){};

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_homework, container, false);
        addwork =(Button)layout.findViewById(R.id.addwork);
        addwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("좀비", "짜증나ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
                try {
                    Intent intent1 = new Intent(getActivity(), Homework_info.class);
                    startActivity(intent1);
                }catch (NullPointerException ne){
                    ne.printStackTrace();
                }
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dref = database.getReference("Homework_info").child("Info_Details");
        

        ListAdapter workAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);


        return layout;
    }
}


