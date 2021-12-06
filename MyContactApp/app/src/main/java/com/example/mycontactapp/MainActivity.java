package com.example.mycontactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_search;
    MyApplication myApplication = (MyApplication) this.getApplication();
    ArrayList<BaseContact> listOfContacts;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfContacts = myApplication.getListOfContacts();

        btn_add = findViewById(R.id.home_btn_add);
        btn_search = findViewById(R.id.home_btn_search);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(v.getContext(), Add_Contact_Person.class);
            startActivity(i);

            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Contact_Search.class);
                startActivity(i);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.lv_contactList);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecycleViewAdapter(listOfContacts, MainActivity.this) {
        };
        recyclerView.setAdapter(mAdapter);
    }


}