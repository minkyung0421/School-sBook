package com.example.schoolsbook;


import android.content.Context;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Locale;


/**
 * Created by 최민경 on 2017-11-08.
 */

public class Schedule extends Fragment {


    public Schedule() {
    }

    public Schedule(Calendar_schedule calendar_schedule) {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_schedule, container, false);
        return layout;
    }

}

