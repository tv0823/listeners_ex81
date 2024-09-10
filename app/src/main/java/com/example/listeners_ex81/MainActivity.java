package com.example.listeners_ex81;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button blueBtn, redBtn;
    int blueCounter, redCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueBtn = findViewById(R.id.blueBtn);
        redBtn = findViewById(R.id.redBtn);
        blueCounter = 0;
        redCounter = 0;

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueCounter ++;
            }
        });

        redBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                redCounter += 2;
                return true;
            }
        });

    }

    public void resultbtn(View view) {
        Intent si = new Intent(this,GameResultsActivity.class);
        si.putExtra("blueCounter",blueCounter);
        si.putExtra("redCounter",redCounter);
        blueCounter = 0;
        redCounter = 0;
        startActivity(si);
    }
}