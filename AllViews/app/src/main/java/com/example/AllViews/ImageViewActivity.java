package com.example.AllViews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    boolean isSeen = false;

    public void switchPhotos( View view) {
        ImageView image = findViewById(R.id.imageView);
        if (!isSeen){
            image.setImageResource(R.drawable.ic_launcher_background);
            isSeen = true;
        } else {
            image.setImageResource(R.drawable.ic_launcher_foreground);
            isSeen = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view);
    }
}