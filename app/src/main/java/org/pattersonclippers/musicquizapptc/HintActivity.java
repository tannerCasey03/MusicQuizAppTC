package org.pattersonclippers.musicquizapptc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    Intent incomingIntent;
    String hint;
    TextView hintTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint2);
        hintTV = (TextView) findViewById(R.id.hintTV);

        incomingIntent = getIntent();
        hint = incomingIntent.getStringExtra("hint");
        hintTV.setText(hint);

    }
}