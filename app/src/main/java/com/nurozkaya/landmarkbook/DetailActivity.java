package com.nurozkaya.landmarkbook;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // resmi ve yazıları tanımladık

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.landmarkNameText);
        TextView countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent(); // isimleri aldık (görselleri intent le yollayamıyoruz)
        String landmarkName = intent.getStringExtra("name");
        landmarkNameText.setText(landmarkName);

        String countryName = intent.getStringExtra("country"); // countryleri aldık
        countryNameText.setText(countryName);

        //imageView.setImageBitmap(selectedImage);
        Singleton singleton =Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());



    }
}