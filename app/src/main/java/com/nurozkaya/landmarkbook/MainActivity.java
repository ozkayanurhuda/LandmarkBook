package com.nurozkaya.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        //Data

        final ArrayList <String> landmarkNames = new ArrayList<>(); // bunu arrayin içinde sadece string olucak ve daha içine bişey koymadım
        landmarkNames.add("Pisa"); // 0
        landmarkNames.add("Eiffel"); // 1
        landmarkNames.add("Colesseo"); // 2
        landmarkNames.add("London Bridge"); // 3


        final ArrayList<String>countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        // resimlerin arrayi

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landMarkImages = new ArrayList<>();
        landMarkImages.add(pisa);
        landMarkImages.add(eiffel);
        landMarkImages.add(colesseo);
        landMarkImages.add(londonBridge);



        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames); // sadece metin kullanıcağım için simple list dedik
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // tıkladığım sıfır oluyor
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // itema tıklannıca ne olucak
                //System.out.println(landmarkNames.get(i));
                //System.out.println(countryNames.get(i));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(i));// isimleri koyduk
                intent.putExtra("country",countryNames.get(i));  // countryleri koyduk

                //selectedImage = landMarkImages.get(i); // static oluşturmak çok da mantıklı değil

                Singleton singleton = Singleton.getInstance(); // hem public hem static
                singleton.setChosenImage(landMarkImages.get(i));


                startActivity(intent);

            }
        }); // dinleyici beklyior


    }
}