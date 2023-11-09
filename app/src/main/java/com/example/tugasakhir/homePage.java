package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class homePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void padarIsland(View view) {
        String title = "Padar Island";
        String desc = "Padar Island, nestled in Komodo National Park, is a paradise for nature enthusiasts. With white sandy beaches, lush hills, and stunning views, it offers an unforgettable adventure. Don't forget your camera";
        moveToDesc(title, desc,R.drawable.padar);
    }

    public void bromo(View view) {
        String title = "Bromo";
        String desc = "Bromo is a Iconic volcano in East Java, Indonesia, known for its surreal landscapes, volcanic craters, and stunning sunrise views.";
        moveToDesc(title, desc,R.drawable.danau_toba);
    }

    public void moveToDesc(String title, String desc, int resourceImage) {
        Intent intent = new Intent(this,detailPage.class);
        intent.putExtra("placeTitle",title);
        intent.putExtra("placeDesc",desc);
        intent.putExtra("placeImage",resourceImage);

        startActivity(intent);
    }
}