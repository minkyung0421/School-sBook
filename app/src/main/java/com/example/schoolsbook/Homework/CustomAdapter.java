package com.example.schoolsbook.Homework;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolsbook.R;

import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */
public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Information> information;
    public CustomAdapter(Context c, ArrayList<Information> information) {
        this.c = c;
        this.information = information;
    }
    @Override
    public int getCount() {
        return information.size();
    }
    @Override
    public Object getItem(int position) {
        return information.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        TextView propTxt= (TextView) convertView.findViewById(R.id.timeTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.infoTxt);
        final Information i= (Information) this.getItem(position);
        nameTxt.setText(i.getName());
        propTxt.setText(i.getTime());
        descTxt.setText(i.getInfo());
        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,i.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
