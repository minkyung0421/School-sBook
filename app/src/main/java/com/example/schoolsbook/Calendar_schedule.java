package com.example.schoolsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by 최민경 on 2017-11-10.
 */

public class Calendar_schedule extends AppCompatActivity{

    Schedule calendar_s = new Schedule(this);
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth){
                Toast.makeText(Calendar_schedule.this, "" + year + "/" + (month + 1) + "/" + dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });

    }
}
