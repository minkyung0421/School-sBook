package com.example.schoolsbook;

/**
 * Created by 최민경 on 2017-11-14.
 */



public class Information {
    String id;
    String homework_name;
    String finish_time;
    String info;

    public Information(){}

    public Information(String id, String h_n, String f_t, String in){
        this.id = id;
        this.homework_name = h_n;
        this.finish_time = f_t;
        this.info = in;
    }

    public String getId(){return id;}
    public String getHomework_name(){return homework_name;}
    public String getFinish_time(){return finish_time;}
    public String getInfo(){return info;}
}


