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
        String desc = "Padar Island, nestled in Komodo National Park, is a paradise for nature enthusiasts. With white sandy beaches, lush hills, and stunning views, it offers an unforgettable adventure. Don't forget your camera!";

        moveToDesc(title, desc, R.drawable.padar);
    }

    public void bromoMt(View view) {
        String title = "Bromo Mountain";
        String desc = "Iconic volcano in East Java, Indonesia, known for its surreal landscapes, volcanic craters, and stunning sunrise views.";

        moveToDesc(title, desc, R.drawable.bromojuga );
    }

    public void rajaAmpat(View view) {
        String title = "Raja Ampat";
        String desc = "Indonesian paradise of pristine islands, clear waters, vibrant coral reefs, and diverse marine life. A dream for snorkelers and divers alike.";

        moveToDesc(title, desc, R.drawable.raja_ampat );
    }

    public void danauToba(View view) {
        String title = "Danau Toba";
        String desc = "Indonesia's largest lake, nestled in Sumatra, surrounded by lush landscapes and the cultural richness of the Batak people.";

        moveToDesc(title, desc, R.drawable.danau_toba );
    }

    public void boroBudur(View view) {
        String title = "Borobudur Temple";
        String desc = "A magnificent Buddhist temple in Central Java, the world's largest, adorned with intricate carvings and stupas, showcasing Indonesia's rich history.";

        moveToDesc(title, desc, R.drawable.borobudur );
    }

    public void wayKambas(View view) {
        String title = "Waykambas";
        String desc = "A national park on Sumatra, home to diverse wildlife, including endangered species like Sumatran elephants. A haven for nature enthusiasts.";

        moveToDesc(title, desc, R.drawable.waykambas );
    }

    public void kawahIjen(View view) {
        String title = "Kawah Ijen";
        String desc = "A captivating volcanic crater in East Java, known for its electric-blue sulfur flames and turquoise lake, offering a surreal and unique natural spectacle.";

        moveToDesc(title, desc, R.drawable.kawah_ijen );
    }

    public void diamondBeach(View view) {
        String title = "Diamond Beach";
        String desc = "A hidden gem in Nusa Penida, Bali, featuring pristine white sands and azure waters, creating a picturesque and idyllic tropical paradise.";

        moveToDesc(title, desc, R.drawable.nusa_penida );
    }


    public void moveToDesc(String title, String desc, int resourceImage) {
        Intent intent = new Intent(this,detailPage.class);
        intent.putExtra("placeTitle",title);
        intent.putExtra("placeDesc",desc);
        intent.putExtra("placeImage",resourceImage);

        startActivity(intent);
    }





}