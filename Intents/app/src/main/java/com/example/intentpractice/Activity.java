package com.example.intentpractice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        textView = findViewById(R.id.textView);

        Intent i = getIntent();
        int fact = i.getIntExtra("fact", 0);
        textView.setText("Factorial"+fact);
    }
}
