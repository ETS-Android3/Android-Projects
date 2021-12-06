package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_name, et_age, et_picturenumber;
    int positionToEdit =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);
        btn_ok = findViewById(R.id.btn_ok);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_picturenumber = findViewById(R.id.et_picturenumber);

        String newName = et_name.getText().toString();
        String newAge = et_age.getText().toString();
        String newPictureNumber = et_picturenumber.getText().toString();

        Bundle incomingMessages = getIntent().getExtras();
        if(incomingMessages != null){
            String name = incomingMessages.getString("name");
            int age = incomingMessages.getInt("age");
            int picturenumber = incomingMessages.getInt("picturenumber");

            positionToEdit = incomingMessages.getInt("edit");
            Person p = new Person(name, age, picturenumber);
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_picturenumber.setText(Integer.toString(picturenumber));

        }


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                i.putExtra("edit", positionToEdit);
                i.putExtra("name", newName);
                i.putExtra("age", newAge);
                i.putExtra("picturenumber", newPictureNumber);
                startActivity(i);

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}