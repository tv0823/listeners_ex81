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

    TextView redScoreTv, blueScoreTv, winnerTv;
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
        winnerTv = findViewById(R.id.winnerTv);

        Intent gi = getIntent();
        int blueScore = gi.getIntExtra("blueCounter",-1);
        int redScore = gi.getIntExtra("redCounter",-1);

        blueScoreTv.setText("The Blue score is:\n" + blueScore);
        redScoreTv.setText("The Red score is:\n" + redScore);

        if (blueScore > redScore) {
            winnerTv.setText("The winner is: Blue");
            main.setBackgroundColor(0xff0077b6);
        } else if (redScore > blueScore) {
            winnerTv.setText("The winner is: Red");
            main.setBackgroundColor(0xffe3242b);
        } else {
            winnerTv.setText("Its a Tie");
        }
    }

    public void gobackAction(View view) {
        finish();
    }
}