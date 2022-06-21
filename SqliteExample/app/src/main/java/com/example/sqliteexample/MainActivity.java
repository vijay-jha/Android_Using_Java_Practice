package com.example.sqliteexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText name, surname, marks, id;
    Button add, view, update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        surname = findViewById(R.id.surname);
        marks = findViewById(R.id.marks);
        add = findViewById(R.id.addbtn);
        view = findViewById(R.id.viewbtn);
        update = findViewById(R.id.updatebtn);
        delete = findViewById(R.id.delete);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isInserted = myDb.insertData(name.getText().toString(), surname.getText().toString(), marks.getText().toString());
               if (isInserted)
                   Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(MainActivity.this, "Inserted unsuccessfully", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.viewData();
                if (res.getCount() == 0) {
                    showMessage("Empty", "Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("id: " + res.getString(0) + "\n");
                    buffer.append("name: " + res.getString(1) + "\n");
                    buffer.append("surname: " + res.getString(2) + "\n");
                    buffer.append("marks: " + res.getString(3) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
        
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = myDb.updateData(id.getText().toString(), name.getText().toString(), surname.getText().toString(), marks.getText().toString());
                if (isUpdated)
                    Toast.makeText(MainActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Updated Unsuccessfully", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows =  myDb.deleteData(id.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}