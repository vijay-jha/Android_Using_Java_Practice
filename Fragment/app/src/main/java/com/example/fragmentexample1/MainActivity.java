package com.example.fragmentexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String[] users = new String[] {"Vijay", "Vinay", "Akshay"};
    String[] roll = new String[] {"45", "12", "25"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Configuration config = getResources().getConfiguration();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Lmode lm = new Lmode();
            fragmentTransaction.replace(R.id.fragment, lm);
        } else {
            Pmode pm = new Pmode();
            fragmentTransaction.replace(R.id.fragment, pm);
        }
        fragmentTransaction.commit();

//        ListView listView = findViewById(R.id.list_item);
//
//        DetailsInfo df = new DetailsInfo();
//        fragmentTransaction.replace(R.id.frameFragment, df).commit();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                df.change(
//                     "Name" + users[i],
//                      "Roll " +  roll[i]
//                );
//            }
//        });
    }
}