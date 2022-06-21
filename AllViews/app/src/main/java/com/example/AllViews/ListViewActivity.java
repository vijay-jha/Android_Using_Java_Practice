package com.example.AllViews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView = findViewById(R.id.listview);

        String[] languageNames = {"Java", "C++", "Python", "C", "JavaScript", "C#", "Ruby", "Perl", "PostScript", "Flutter", "Dart", "React Native", "Pascal", "Cobol", "Fortran", "Php"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languageNames);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adapter);


    }
}