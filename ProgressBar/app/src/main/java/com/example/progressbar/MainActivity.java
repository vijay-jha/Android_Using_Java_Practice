package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    ProgressBar bar;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        bar = findViewById(R.id.progressBar);
        Button btn = findViewById(R.id.button);
        TextView txt = findViewById(R.id.inputDigit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt.getText().length() != 0) {
                     count = Integer.parseInt(txt.getText().toString());
                        try {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    bar.setProgress(count);
                                    count += 10;
                                    if (count > 100) {
                                        handler.removeCallbacks(this);
                                    }
                                    handler.postDelayed(this, 200);
                                }
                            }, 200);
                        } catch (Exception e) {
                        }
                    }
                }
        });
    }
}