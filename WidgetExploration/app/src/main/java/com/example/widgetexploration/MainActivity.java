package com.example.widgetexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton newZealand = findViewById(R.id.newZealand);
        RadioButton russia = findViewById(R.id.russia);
        RadioButton australia = findViewById(R.id.australia);
        RadioButton china = findViewById(R.id.china);

        TextClock tClock =
                findViewById(R.id.textClock);

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                switch (rb.getId()) {
                    case R.id.newZealand:
                        tClock.setTimeZone("Pacific/Auckland");
                        break;
                    case R.id.russia:
                        tClock.setTimeZone("Europe/Kaliningrad");
                        break;
                    case R.id.australia:
                        tClock.setTimeZone(
                                "Australia/Sydney");
                        break;
                    case R.id.china:
                        tClock.setTimeZone(
                                "Asia/Shanghai");
                        break;
                }// End switch block
            }
        });
    }
}