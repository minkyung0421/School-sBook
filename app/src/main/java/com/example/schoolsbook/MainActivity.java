package com.example.schoolsbook;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.schoolsbook.Homework.Homework;
import com.example.schoolsbook.Scheule.Schedule;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_bar);
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        Button btn_homepage = (Button) findViewById(R.id.btn_homepage);
        Button btn_schedule = (Button) findViewById(R.id.btn_schedule);
        Button btn_homework = (Button) findViewById(R.id.btn_homework);
        Button btn_gallery = (Button) findViewById(R.id.btn_gallery);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);

        View.OnClickListener movePageListener = new View.OnClickListener() {
            public void onClick(View view) {
                int tag = (int) view.getTag();
                pager.setCurrentItem(tag);
            }
        };

        btn_homepage.setOnClickListener(movePageListener);
        btn_homepage.setTag(0);
        btn_schedule.setOnClickListener(movePageListener);
        btn_schedule.setTag(1);
        btn_homework.setOnClickListener(movePageListener);
        btn_homework.setTag(2);
        btn_gallery.setOnClickListener(movePageListener);
        btn_gallery.setTag(3);
    }


    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Homepage();
                case 1:
                    return new Schedule();
                case 2:
                    return new Homework();
                case 3:
                    return new Gallery();
                default:
                    return null;
            }
        }

        public int getCount() {
            return 4;
        }
    }
}
