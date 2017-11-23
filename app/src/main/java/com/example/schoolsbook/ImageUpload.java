package com.example.schoolsbook;

/**
 * Created by 최민경 on 2017-11-20.
 */

public class ImageUpload {

    //public String id;
    public String name;
    public String uri;
    String id;

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
    public String getId(){return id;}

    public ImageUpload(String name, String uri) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public ImageUpload(){}
}
