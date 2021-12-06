package com.example.mycontactapp;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BaseContact implements Serializable {
    private int number;
    private String name;
    private String phone;
    private String photo;

    public BaseContact(int number, String name, String phone, String photo) {
        this.number = number;
        this.name = name;
        this.phone = phone;
        this.photo = photo;

    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public abstract String getDateOfBirth();
}
