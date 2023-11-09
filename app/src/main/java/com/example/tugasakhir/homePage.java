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
        String desc = "Padar Island is located on west side of indonesia ";

        moveToDesc(title, desc,R.drawable.padar);
    }

    public void moveToDesc(String title, String desc, int resourceImage) {
        Intent intent = new Intent(this,detailPage.class);
        intent.putExtra("placeTitle",title);
        intent.putExtra("placeDesc",desc);
        intent.putExtra("placeImage",resourceImage);

        startActivity(intent);
    }
}