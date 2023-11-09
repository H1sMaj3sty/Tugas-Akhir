package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailPage extends AppCompatActivity {
    TextView placeTitle,placeDesc;
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        placeTitle = findViewById(R.id.namaDestinasi);
        placeDesc = findViewById(R.id.deskripsiDestinasi);
        image = findViewById(R.id.imageDetail);

        Intent intent = getIntent();
            if(intent.hasExtra("placeTitle")&&intent.hasExtra("placeDesc")&&intent.hasExtra("placeImage")){
                String title = intent.getStringExtra("placeTitle");
                String desc = intent.getStringExtra("placeDesc");
                int imageResource = intent.getIntExtra("image", R.drawable.padar);

                placeTitle.setText(title);
                placeDesc.setText(desc);
                image.setImageResource(imageResource);

            }
     }
}





