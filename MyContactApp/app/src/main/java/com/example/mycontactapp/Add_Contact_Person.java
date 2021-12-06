package com.example.mycontactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Add_Contact_Person extends AppCompatActivity {

    Button btn_cancel, btn_done, btn_delete;
    EditText et_name, et_phone, et_photo;
    CalendarView cv_dob;
    String dateOfBirth;
    TextView tv_editDOB, tv_editIDnum;
    int id;

    ArrayList<BaseContact> listOfContacts;
    MyApplication myApplication = (MyApplication) getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__person);

        listOfContacts = myApplication.getListOfContacts();

        btn_cancel = findViewById(R.id.person_btn_cancel);
        btn_done = findViewById(R.id.person_btn_done);
        btn_delete = findViewById(R.id.person_btn_delete);

        et_name = findViewById(R.id.person_et_name);
        et_phone = findViewById(R.id.person_et_phone);
        et_photo = findViewById(R.id.person_et_photo);

        tv_editDOB = findViewById(R.id.tv_editDOB);
        cv_dob = findViewById(R.id.person_cv_dob);

        tv_editIDnum = findViewById(R.id.tv_editIDnum);




        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);





        PersonContact personContact = null;

        if(id >= 0){
        for(BaseContact p : listOfContacts){
            if(p.getNumber() == id){
                personContact = (PersonContact)p;
            }

        }
        et_name.setText(personContact.getName());
        et_phone.setText(personContact.getPhone());
        et_photo.setText(personContact.getPhoto());
        tv_editDOB.setText("Current DOB: "+personContact.getDateOfBirth()+"\nIf unchanged, set it once more, please.");
        tv_editIDnum.setText(String.valueOf(personContact.getNumber()));

        }
        else {

        }

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int pos =0;
               int box = 0;
                for(BaseContact p : listOfContacts) {
                    if (p.getNumber() == id) {
                        box = pos;
                    }
                    pos++;
                }
                listOfContacts.remove(box);

                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);

            }
        });
        cv_dob.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dateOfBirth = (month+1)+ "/" + dayOfMonth +"/" + year;

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id >=0){
                    //update
                    PersonContact p = new PersonContact(listOfContacts.get(id).getDateOfBirth(), id,et_name.getText().toString(), et_phone.getText().toString(),et_photo.getText().toString());
                    listOfContacts.set(id, p);
                }
                else{
                    //add new person
                    // create person contact obj
                    int nextId = myApplication.getNextId();
                    PersonContact p = new PersonContact(dateOfBirth, nextId, et_name.getText().toString(), et_phone.getText().toString(), et_photo.getText().toString());


                    // add the obj to global list
                    listOfContacts.add(p);
                    myApplication.setNextId(nextId++);
                }


                // go to main activity
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}