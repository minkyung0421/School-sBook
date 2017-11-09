package com.example.schoolsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 최민경 on 2017-11-09.
 */

public class Memo_gallery extends AppCompatActivity {
    EditText mMemoEdit = null;
    Gallery mTextFileManager = new Gallery(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mMemoEdit = (EditText)findViewById(R.id.memo_edit);
    }
}
