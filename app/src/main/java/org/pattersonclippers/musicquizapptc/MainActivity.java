package org.pattersonclippers.musicquizapptc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity
{

    TextView questionTV;
    Button trueBTN, falseBTN, scoreBTN, nextBTN, hindBTN;
    String showAnswer;
    int score, currentIndex;
    Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10 ,currentQ;
    Question[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = (TextView) findViewById(R.id.questionTV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        hindBTN = (Button) findViewById(R.id.hintBTN);
        showAnswer = "";
        score = 0;

        q1 = new Question(getString(R.string.q1text), getString(R.string.hint1), true);
        q2 = new Question(getString(R.string.q2text), getString(R.string.hint2), false);
        q3 = new Question(getString(R.string.q3text), getString(R.string.hint3), false);
        q4 = new Question(getString(R.string.q4text), getString(R.string.hint4), true);
        q5 = new Question(getString(R.string.q5text), getString(R.string.hint5), true);
        q6 = new Question(getString(R.string.q6text), getString(R.string.hint6),true);
        q7 = new Question(getString(R.string.q7text), getString(R.string.hint7), false);
        q8 = new Question(getString(R.string.q8text), getString(R.string.hint8), true);
        q9 = new Question(getString(R.string.q9text), getString(R.string.hint9), true);
        q10 = new Question(getString(R.string.q10text), getString(R.string.hint10), false);
        questions = new Question[] {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};
        currentIndex = 0;
        currentQ = questions[currentIndex];

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(currentQ.getCorrectAnswer()==true)
                {
                    showAnswer = getString(R.string.correctMSG);
                    score = score + 1;
                }
                else
                {
                    showAnswer = getString(R.string.wrongMSG);
                }
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
            }
        });
            falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(currentQ.getCorrectAnswer()==false)
                {
                    showAnswer = getString(R.string.correctMSG);
                    score = score + 1;
                }
                else
                {
                    showAnswer = getString(R.string.wrongMSG);
                }
                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();
            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if(currentIndex <10)
                {
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getqText());
                }
                else
                {
                    Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    myIntent.putExtra("score", score);
                    startActivity(myIntent);
               }
            }
        });
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
//        intent.putExtra(Intent.EXTRA_SUBJECT, "this is the score");
//        intent.putExtra(Intent.EXTRA_TEXT, "BODY");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        hindBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HintActivity.class);

                String hintFQ = currentQ.getHint();
                myIntent.putExtra("hint", hintFQ);
                startActivity(myIntent);
            }
        });
    }
}