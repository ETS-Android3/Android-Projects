package com.example.mycontactapp;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    private static ArrayList<BaseContact> listOfContacts = new ArrayList<BaseContact>();
    private static int nextId = listOfContacts.size();


    public MyApplication(){
        fillContactList();
        nextId = listOfContacts.size();
    }
    public void fillContactList(){

        PersonContact p0 = new PersonContact("10/10/10", 0, "Mac Demarco", "200-200-2220", "https://images.thebrag.com/tio/uploads/2018/08/Mac-DeMarco-768x576.jpg" );
        PersonContact p1 = new PersonContact("10/10/10", 1, "Will Toledo", "200-200-2220", "https://variety.com/wp-content/uploads/2017/12/car-seat-headrest-will-toledo1.jpg" );
        PersonContact p2 = new PersonContact("10/10/10", 2, "Jakob Ogawa", "200-200-2220", "https://images.sk-static.com/images/media/profile_images/artists/8693093/huge_avatar" );
        PersonContact p3 = new PersonContact("10/10/10", 3, "Kanye West", "200-200-2220", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5ed00f17d4a99d0006d2e738%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D154%26cropX2%3D4820%26cropY1%3D651%26cropY2%3D5314" );
        PersonContact p4 = new PersonContact("10/10/10", 4, "Mac Miller", "200-200-2220", "https://pyxis.nymag.com/v1/imgs/f64/d14/ce3f3a568c6511537d537050da8a5000fe-04-mac-miller-1.rvertical.w1200.jpg" );

        listOfContacts.add(p0);
        listOfContacts.add(p1);
        listOfContacts.add(p2);
        listOfContacts.add(p3);
        listOfContacts.add(p4);


    }

    public static ArrayList<BaseContact> getListOfContacts() {
        return listOfContacts;
    }

    public static void setListOfContacts(ArrayList<BaseContact> listOfContacts) {
        MyApplication.listOfContacts = listOfContacts;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
