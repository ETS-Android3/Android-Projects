package com.example.thelife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_clicker;
    TextView txt_counter;
    int counter = 0;


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LifeCycle", "Starting Activity");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LifeCycle", "Stopping Activity");
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d("LifeCycle", "Destroying Activity");
    }
    @Override
    protected void onPause() {

        super.onPause();
        Log.d("LifeCycle", "Pausing Activity");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LifeCycle", "Resuming Activity");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LifeCycle", "Restarting Activity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycle", "Creating Activity");
        setContentView(R.layout.activity_main);
        btn_clicker = (Button) findViewById(R.id.btn_clicker);
        txt_counter = (TextView) findViewById(R.id.txt_counter);


        btn_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                txt_counter.setText(Integer.toString(counter));
            }
        });



    }
    protected void onSavedInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("LifeCycle", "Saving State");
        outState.putInt("a", counter);
    }
    protected void onRestoreInstanceState(@NonNull Bundle inState){
        super.onRestoreInstanceState(inState);
        Log.d("LifeCycle", "Restoring State");
        counter = inState.getInt("a");
        txt_counter.setText(Integer.toString(counter));

    }
}