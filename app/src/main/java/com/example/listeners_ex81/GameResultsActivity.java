package com.example.listeners_ex81;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameResultsActivity extends AppCompatActivity {

    TextView redScoreTv, blueScoreTv;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_results);

        findWinner();

    }

    public void findWinner() {
        main = findViewById(R.id.main);
        redScoreTv = findViewById(R.id.redScoreTv);
        blueScoreTv = findViewById(R.id.blueScoreTv);

        Intent gi = getIntent();
        int blueScore = gi.getIntExtra("blueCounter",-1);
        int redScore = gi.getIntExtra("redCounter",-1);

        if (blueScore >= redScore) {
            main.setBackgroundColor(0xff0077b6);
            blueScoreTv.setText("The blue score is: " + blueScore);
            redScoreTv.setText("The red score is: " + redScore);
        } else {
            main.setBackgroundColor(0xffe3242b);
            redScoreTv.setText("The red score is: " + redScore);
            blueScoreTv.setText("The blue score is: " + blueScore);
        }
    }

    public void gobackAction(View view) {
        finish();
    }
}