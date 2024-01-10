package org.pattersonclippers.musicquizapptc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity
{

    Intent incomingIntent;
    TextView scoreTV;
    int score;
    Button sendBTN, showhighscoreBTN;
    EditText nameET;
    FirebaseDatabase database;
    DatabaseReference myRef;
    HighScore newHS;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);
        scoreTV.setText("" + score);
        sendBTN = (Button) findViewById(R.id.sendBTN);
        showhighscoreBTN = (Button) findViewById(R.id.showhighscoreBTN);
        nameET = (EditText) findViewById(R.id.nameET);
        name = "";

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nameET.getText().toString();
                newHS = new HighScore(score, name);

//                myRef.setValue(newHS);
                String key = myRef.push().getKey();
                myRef.child(key).setValue(newHS);
            }
        });

        showhighscoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ScoreActivity.this, HighScoreActivity.class);
                startActivity(myIntent);
            }
        });

       // myRef.setValue("Hello, World!");

    }

}