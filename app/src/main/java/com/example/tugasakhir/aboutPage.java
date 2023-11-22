package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class aboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
    }

    public void faceBook(View view) {
        String fbUrl = "https://www.facebook.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fbUrl));
        startActivity(intent);
    }

    public void instaGram(View view) {
        String igUrl = "https://www.instagram.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl));
        startActivity(intent);
    }

    public void youTube(View view) {
        String ytUrl = "https://www.youtube.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ytUrl));
        startActivity(intent);
    }
    public void arrowBack(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }
}