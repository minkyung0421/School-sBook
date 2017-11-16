package com.example.schoolsbook;

/**
 * Created by 최민경 on 2017-11-13.
 */

public class GetSet_gallery {
    int id;
    String name;
    String memo;
    String imageName;
    String day;

    public GetSet_gallery(int id, String name, String memo, String imageName, String day){
        this.id = id;
        this.name = name;
        this.memo = memo;
        this.imageName = imageName;
        this.day = day;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getDay(){
        return day;
    }

    public void setDay(){
        this.day = day;
    }

    public String getImageName(){
        return imageName;
    }

    public void setImageName(String ImageName){
        this.imageName = imageName;
    }


}
