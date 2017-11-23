package com.example.schoolsbook;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 최민경 on 2017-11-23.
 */

public class imageListAdapter extends ArrayAdapter<ImageUpload> {
   private Activity context;
    private int resource;
    private List<ImageUpload> listImage;

    public imageListAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<ImageUpload> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        listImage = objects;
    }

    public imageListAdapter(Activity context, List<ImageUpload> listImage) {
        super(context, R.layout.image_item, listImage);
        this.context = context;
        this.listImage = listImage;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.image_item, null, true);

        TextView tvName = (TextView) listViewItem.findViewById(R.id.tvImageName);
        ImageView img = (ImageView) listViewItem.findViewById(R.id.imgView);

        ImageUpload imgup = listImage.get(position);
        tvName.setText(imgup.getName());
        Glide.with(context).load(imgup.getUri()).into(img);

        return listViewItem;
    }
}
