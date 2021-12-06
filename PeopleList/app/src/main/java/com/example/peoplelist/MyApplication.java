package com.example.peoplelist;

import android.app.Application;

public class MyApplication extends Application {
    public MyFriends getMyFriends(){
        return myFriends;
    }

    public void setMyFriends(MyFriends myFriends) {
        this.myFriends = myFriends;
    }

    private MyFriends myFriends = new MyFriends();
}
