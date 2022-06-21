package com.example.burgertoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int burgerPrice = 120;
    int coffeePrice = 50;
    int pizzaPrice = 250;

    CheckBox burger, pizza, coffee;
    Button order;
    String[] items = new String[3];
    String total = "";
    int j = 3, amount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burger = findViewById(R.id.burger);
        coffee = findViewById(R.id.coffee);
        pizza = findViewById(R.id.pizza);
        order = findViewById(R.id.orderBtn);

        burger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (burger.isChecked())
                    items[0] = burger.getText().toString() + ": " + burgerPrice + "\n";
                else
                    items[0] = "";
            }
        });

        coffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (coffee.isChecked())
                    items[1] = coffee.getText().toString() + ": " + coffeePrice + "\n";
                else
                    items[1] = "";
            }
        });

        pizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pizza.isChecked())
                    items[2] = pizza.getText().toString() + ": " + pizzaPrice + "\n";
                else
                    items[2] = "";
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < j; i++) {
                    if (items[i] != null && !items[i].isEmpty()) {
                        String numOnly = items[i].replaceAll("[^0-9]", "");
                        amount += Integer.parseInt(numOnly);
                        total = total + "\n" + items[i];
                    }
                }
                total = total + "\n" + "---------" + "\nTotal: " + amount;
                Toast.makeText(getApplicationContext(), total, Toast.LENGTH_SHORT).show();
                total = "";
                amount = 0;
            }
        });

    }
}