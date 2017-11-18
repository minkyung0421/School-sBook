package com.example.schoolsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 최민경 on 2017-11-08.
 */

public class Homework extends Fragment {
    Button addwork;
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProuctList;


    public Homework() {

    }

    public Homework(Context context) {
    }

    ;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_homework, container, false);
        addwork = (Button) layout.findViewById(R.id.addwork);
        addwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("좀비", "짜증나ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
                try {
                    Intent intent1 = new Intent(getActivity(), Homework_info.class);
                    startActivity(intent1);
                } catch (NullPointerException ne) {
                    ne.printStackTrace();
                }
            }
        });

        lvProduct = (ListView)layout.findViewById(R.id.listview_product);

        mProuctList = new ArrayList<>();

        //Add sample data for List
        //we can get data from Db




        return layout;
    }

}


