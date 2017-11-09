package com.example.schoolsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
/**
 * Created by 최민경 on 2017-11-08.
 */

public class Homework extends Fragment{

    Button addhome;
    public Homework(){

    }
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_homework, container, false);
        View view = inflater.inflate(R.layout.activity_homework, container, false);

        addhome = (Button)view.findViewById(R.id.addhome);

//        addhome.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                ((MainActivity)getActivity()).changeActivity(R.layout.activity_homework_info);
//            }
//        });

//        return view;
        return layout;
    }
}


