package com.example.schoolsbook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 최민경 on 2017-11-18.
 */

public class ProductListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Product> mProductList;

    //Constructor


    public ProductListAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_product_list, null);
        TextView tvName = (TextView)v.findViewById(R.id.tv_name);
        TextView tvTime = (TextView)v.findViewById(R.id.tv_finish);
        TextView tvInfo = (TextView)v.findViewById(R.id.tv_info);

        //set text for TextView
        tvName.setText(mProductList.get(position).getName());
        tvTime.setText(mProductList.get(position).getPrice());
        tvInfo.setText(mProductList.get(position).getDescription());

        //Save product id to tag
        v.setTag(mProductList.get(position).getId());

        return v;
    }
}
