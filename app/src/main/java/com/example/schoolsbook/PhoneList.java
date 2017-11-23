package com.example.schoolsbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LG on 2017-11-15.
 */

public class PhoneList extends ArrayAdapter<Phone> {
    private Activity context;
    List<Phone> phoneList;

    public PhoneList(Activity context, List<Phone> phoneList) {
        super(context, R.layout.list_layout, phoneList);
        this.context = context;
        this.phoneList = phoneList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.name);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.phone);

        Phone phone = phoneList.get(position);
        textViewName.setText(phone.getPhonename());
        textViewPhone.setText(phone.getPhone());

        return listViewItem;
    }
}