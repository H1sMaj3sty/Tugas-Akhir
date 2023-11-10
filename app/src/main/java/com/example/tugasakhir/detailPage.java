package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detailPage extends AppCompatActivity {
    TextView placeTitle,placeDesc;
    ImageView image;
    String locationAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        placeTitle = findViewById(R.id.namaDestinasi);
        placeDesc = findViewById(R.id.deskripsiDestinasi);
        image = findViewById(R.id.imageDetail);

        Intent intent = getIntent();
            if(intent.hasExtra("placeTitle")&&intent.hasExtra("placeDesc")&&intent.hasExtra("placeImage")&&intent.hasExtra("locationAddress")){
                String title = intent.getStringExtra("placeTitle");
                String desc = intent.getStringExtra("placeDesc");
                locationAddress = intent.getStringExtra("locationAddress");
                int imageResource = intent.getIntExtra("placeImage", 0);

                placeTitle.setText(title);
                placeDesc.setText(desc);
                image.setImageResource(imageResource);

            }
     }

     public void gotoMap(View view) {
        Uri location = Uri.parse(locationAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(intent);
     }

    public void arrowBack(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }
}





