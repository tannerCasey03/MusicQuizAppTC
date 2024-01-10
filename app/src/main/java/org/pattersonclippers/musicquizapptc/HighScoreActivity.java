package org.pattersonclippers.musicquizapptc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    TextView name1TV, highscore1TV,name2TV, highscore2TV,name3TV, highscore3TV;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<HighScore> highScores = new ArrayList<HighScore>();
    public static final String TAG="aaaaaaaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);


        name1TV = (TextView) findViewById(R.id.name1TV);
        highscore1TV = (TextView) findViewById(R.id.highscore1TV);
        name2TV = (TextView) findViewById(R.id.name2TV);
        highscore2TV = (TextView) findViewById(R.id.highscore2TV);
        name3TV = (TextView) findViewById(R.id.name3TV);
        highscore3TV = (TextView) findViewById(R.id.highscore3TV);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for (DataSnapshot hSsnapshot : dataSnapshot.getChildren()) {
                    //From our snapshot, get the value of our key/value pair. This value
                    //contains a customer object
                    HighScore myHighscore = hSsnapshot.getValue(HighScore.class);
                    highScores.add(myHighscore);

                    Log.d(TAG, "Value is: " + myHighscore);
                }



//                HighScore value = dataSnapshot.getValue(HighScore.class);
//                Log.d(TAG, "Value is: " + value);

                highscore1TV.setText("" + highScores.get(0).getScore());
                name1TV.setText(highScores.get(0).getName());
                highscore2TV.setText("" + highScores.get(1).getScore());
                name2TV.setText(highScores.get(1).getName());
                highscore3TV.setText("" + highScores.get(2).getScore());
                name3TV.setText(highScores.get(2).getName());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}