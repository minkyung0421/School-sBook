package com.example.schoolsbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 최민경 on 2017-11-08.
 */

public class Gallery extends Fragment{
    private static final String FILE_NAME = "Memo.txt";
    //메모내용을 저장할 파일 이름
    Context mContext = null;

    public Gallery(){}

    public Gallery(Context context){
        mContext = context;
    }

    //파일에 메모를 저장하는 함수
    public void save(String strData){
        if(strData == null || strData.equals("")){
            return;
        }
        FileOutputStream fosMemo = null;

        try{
            //파일에 데이터를 쓰기 위해서 output 스트림생성
            fosMemo = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            //파일에 메모적기
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //저장된 메모를 불러오는 함수
    public String load(){
        try{
            //파일에서 데이터를 읽기 위해서 input 스트림 생성
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);

            //데이터를 읽어온 뒤, String 타입 객체로 반환
            byte[] memoData = new byte[fisMemo.available()];
            while(fisMemo.read(memoData)!=-1){}
            return new String(memoData);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //저장된 메모를 삭제하는 함수
    public void delete(){
        mContext.deleteFile(FILE_NAME);
    }
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_gallery, container, false);

        return layout;
    }

}


