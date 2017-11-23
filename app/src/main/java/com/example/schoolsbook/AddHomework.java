package com.example.schoolsbook;

/**
 * Created by 최민경 on 2017-11-21.
 */

public class AddHomework {
    String name;
    String yy_time;
    String mm_time;
    String dd_time;
    String ww_time;
    String info;
    String id;

    public AddHomework() {
        //this constructor is required
    }

    public AddHomework(String id, String name, String yy_time, String mm_time, String dd_time, String ww_time, String info){
        this.id = id;
        this.name = name;
        this.yy_time = yy_time;
        this.mm_time = mm_time;
        this.dd_time = dd_time;
        this.ww_time = ww_time;
        this.info = info;
    }

    public String getId(){return id;}
    public String getName(){return name;}
    public String getYy_time(){return yy_time;}
    public String getMm_time(){return mm_time;}
    public String getDd_time(){return dd_time;}
    public String getWw_time(){return ww_time;}
    public String getInfo(){return info;}
}
