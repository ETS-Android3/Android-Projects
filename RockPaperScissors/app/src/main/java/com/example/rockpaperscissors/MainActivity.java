package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_paper, btn_scissors;
    TextView tv_score;
    ImageView iv_HumanChoice, iv_ComputerChoice;

    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);

        iv_HumanChoice = (ImageView) findViewById(R.id.iv_HumanChoice);
        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);


        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " +Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));


            }
        });
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " +Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " +Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });


    }

    public String play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3)+1;
        if(computer_choice_number ==1){
            computer_choice = "rock;";
        }
        if(computer_choice_number ==2){
            computer_choice = "scissors";
        }
        if(computer_choice_number ==3){
            computer_choice = "paper";
        }

        if(computer_choice =="rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        } else
        if(computer_choice =="scissors"){
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        } else
        if(computer_choice =="paper"){
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }

        if(computer_choice == player_choice){
            return "Draw. Nobody won.";
        }
        else if(player_choice == "rock" && computer_choice == "scissors"){
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if(player_choice == "rock" && computer_choice == "paper"){
            ComputerScore++;
            return "Paper covers rock. Computer wins!";
        }
        else if(player_choice == "scissors" && computer_choice == "rock"){
            ComputerScore++;
            return "Rock crushes scissors. Computer wins!";
        }
        else if(player_choice == "scissors" && computer_choice == "paper"){
            HumanScore++;
            return "Scissors cuts paper. You win!";
        }
        else if(player_choice == "paper" && computer_choice == "rock"){
            HumanScore++;
            return "Paper covers rock. You win!";
        }
        else if(player_choice == "paper" && computer_choice == "scissors"){
            ComputerScore++;
            return "Scissors cuts paper. Computer wins!";
        }
        else return "Not sure";

    }
}