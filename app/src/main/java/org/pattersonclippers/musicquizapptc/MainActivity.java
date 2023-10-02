package org.pattersonclippers.musicquizapptc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity
{

    TextView questionTV;
    Button trueBTN, falseBTN, scoreBTN;
    String showAnswer;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = (TextView) findViewById(R.id.questionTV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        showAnswer = "";
        score = 0;
        scoreBTN = (Button) findViewById(R.id.scoreBTN);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                showAnswer = "Right";
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
                score = score + 1;
            }
        });
            falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                showAnswer = "Wrong";
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
            }
        });


        scoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }
        });
    }
}