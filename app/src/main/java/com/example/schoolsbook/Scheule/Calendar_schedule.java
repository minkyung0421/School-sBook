package com.example.schoolsbook.Scheule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.example.schoolsbook.Gallery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 최민경 on 2017-11-10.
 */


public class Calendar_schedule extends AppCompatActivity {
    Schedule mTextFileManager = new Schedule(this);

    BaseActivity_schedule bs = new BaseActivity_schedule(this);
}
