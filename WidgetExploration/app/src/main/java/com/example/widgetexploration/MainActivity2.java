package com.example.widgetexploration;

import android.graphics.Color;
import android.graphics.PorterDuff;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // Get a reference to all our widgets
        RadioGroup radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup);
        final EditText editText =
                (EditText) findViewById(R.id.editText);
        final Button button =
                (Button) findViewById(R.id.button);
        final TextClock tClock =
                (TextClock) findViewById(R.id.textClock);
        tClock.setFormat12Hour("HH:mm a");
        final CheckBox cbTransparency =
                (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint =
                (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize =
                (CheckBox) findViewById(R.id.checkBoxReSize);
        final ImageView imageView =
                (ImageView) findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        TextView textView =
                (TextView) findViewById(R.id.textView);
        // Hide the TextView at the start of the app
        textView.setVisibility(View.INVISIBLE);

        // First the check boxes using an anonymous class
        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(
                    CompoundButton buttonView, boolean isChecked){
                if(cbTransparency.isChecked()){
                    // Set some transparency
                    imageView.setAlpha(.1f);
                }else{
                    imageView.setAlpha(1f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new
                                                  CompoundButton.OnCheckedChangeListener() {
                                                      public void onCheckedChanged(CompoundButton
                                                                                           buttonView, boolean isChecked) {
                                                          if (cbTint.isChecked()) {
                                                              // Checked so set some tint
                                                              imageView.setColorFilter(
                                                                      Color.argb(150, 255, 0, 0));
                                                          } else {
                                                              // No tint needed
                                                              imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                                                          }
                                                      }
                                                  });

        // And the last check box
        cbReSize.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {
                        if (cbReSize.isChecked()) {
                            // It's checked so make bigger
                            imageView.setScaleX(2);
                            imageView.setScaleY(2);
                        } else {
                            // It's not checked make regular size
                            imageView.setScaleX(1);
                            imageView.setScaleY(1);
                        }
                    }
                });

        // Now for the radio buttons
// Uncheck all buttons
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton)
                        group.findViewById(checkedId);

                switch (rb.getId()) {
                    case R.id.radioButtonLondon:
                        tClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        tClock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:

                        tClock.setTimeZone(
                                "America/New_York");
                        break;
                    case R.id.radioButtonEuropeanEmpire:
                        tClock.setTimeZone(
                                "Europe/Brussels");
                        break;

                }// End switch block
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We only handle one button
                // So, no switching required

                // Change the text on the TextView
// to whatever is currently in the EditText
                textView.setText(editText.getText());
            }
        });

        // Show or hide the TextView
        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            textView.setVisibility(View.VISIBLE);
                        }else{
                            textView.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }
}