package com.example.schoolsbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 최민경 on 2017-11-21.
 */

public class AddHomeworkList extends ArrayAdapter<AddHomework> {
    private Activity context;
    List<AddHomework> workList;

    public AddHomeworkList(Activity context, List<AddHomework> workList){
        super(context, R.layout.work_item,workList);
        this.context = context;
        this.workList = workList;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.work_item, null, true);

        TextView nameTxt = (TextView)listViewItem.findViewById(R.id.nameTxt);
        TextView yyTxt = (TextView)listViewItem.findViewById(R.id.yy);
        TextView mmTxt = (TextView)listViewItem.findViewById(R.id.mm);
        TextView ddTxt = (TextView) listViewItem.findViewById(R.id.dd);
        TextView wwTxt = (TextView) listViewItem.findViewById(R.id.ww);
        TextView infoTxt = (TextView)listViewItem.findViewById(R.id.infoTxt);

        AddHomework homework = workList.get(position);
        nameTxt.setText(homework.getName());
        yyTxt.setText(homework.getYy_time());
        mmTxt.setText(homework.getMm_time());
        ddTxt.setText(homework.getDd_time());
        wwTxt.setText(homework.getWw_time());
        infoTxt.setText(homework.getInfo());

        return listViewItem;
    }
}
