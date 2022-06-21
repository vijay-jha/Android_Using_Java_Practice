package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    EditText factorialInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate);
        factorialInput = findViewById(R.id.factorial);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fact = Integer.parseInt(factorialInput.getText().toString().trim());
                for (int i = fact; i > 0; i--) {
                    fact *= i;
                }
                Intent i = new Intent(MainActivity.this, Activity.class);
                i.putExtra("fact", fact);
                startActivity(i);
            }
        });
    }
}