package com.example.schoolsbook;

public class Phone {
    String phonename;
    String phone;
    String id;

    public Phone() {
        //this constructor is required
    }

    public Phone(String id, String phonename, String phone) {
        this.id = id;
        this.phonename = phonename;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getPhonename() {
        return phonename;
    }

    public String getPhone() {
        return phone;
    }
}
