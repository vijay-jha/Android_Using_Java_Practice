package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.onStart();
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"On create method called",Toast.LENGTH_SHORT).show();
    }
    protected void onStart() {
        // It will show a message on the screen
        // then onStart is invoked
        super.onStart();
        Toast.makeText(getApplicationContext(),"On start method called",Toast.LENGTH_SHORT).show();
    }
    protected void onRestart() {
        // It will show a message on the screen
        // then onRestart is invoked

        super.onRestart();
        Toast.makeText(getApplicationContext(),"On restart method called",Toast.LENGTH_SHORT).show();

    }
    protected void onResume() {
        // It will show a message on the screen
        // then onResume is invoked
        super.onResume();
        Toast.makeText(getApplicationContext(),"On resume method called",Toast.LENGTH_SHORT).show();
    }
    protected void onPause() {
        // It will show a message on the screen
        // then onPause is invoked
        super.onPause();
        Toast.makeText(getApplicationContext(), "On pause method called", Toast.LENGTH_SHORT).show();
    }
    protected void onStop() {
        // It will show a message on the screen
        // then onStop is invoked
        super.onStop();
        Toast.makeText(getApplicationContext(), "On stop method called", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy() {
        // It will show a message on the screen
        // then onDestroy is invoked
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"On destroy method called",Toast.LENGTH_SHORT).show();;
    }
}