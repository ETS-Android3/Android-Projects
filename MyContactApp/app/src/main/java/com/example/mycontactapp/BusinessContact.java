package com.example.mycontactapp;

import java.io.Serializable;

public class BusinessContact extends BaseContact implements Serializable {
    private String hours;
    private String url;
    public BusinessContact(String hours, String url, int number, String name, String phone, String photo
                           ) {
        super(number, name, phone, photo);
        this.hours = hours;
        this.url = url;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getDateOfBirth() {
        return null;
    }
}
