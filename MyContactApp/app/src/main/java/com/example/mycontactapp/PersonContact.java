package com.example.mycontactapp;

import java.io.Serializable;

public class PersonContact extends BaseContact implements Serializable {
    private String dateOfBirth;



    public PersonContact(String dateOfBirth, int number, String name,
                         String phone, String photo) {
        super(number, name, phone, photo);
        this.dateOfBirth = dateOfBirth;



    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
