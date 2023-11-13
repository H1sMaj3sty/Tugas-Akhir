package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class homePage extends AppCompatActivity {

    private static final String PREFS_ICON = "Prefs";
    EditText searchBar;
    private int count = 0;
    private String locationAdd = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        searchBar = findViewById(R.id.serach);

        loadButtonState();

        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String address = textView.getText().toString();
                    moveToMap(address);
                    return true;
                }
                return false;
            }
        });

        searchBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int DRAWABLE_RIGHT = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= (searchBar.getRight() - searchBar.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        String address = searchBar.getText().toString();
                        moveToMap(address);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void padarIsland(View view) {
        String title = "Padar Island";
        String desc = "Padar Island, nestled in Komodo National Park, is a paradise for nature enthusiasts. With white sandy beaches, lush hills, and stunning views, it offers an unforgettable adventure. Don't forget your camera!";
        String locAdd = "https://maps.app.goo.gl/jvY36VRma95umeJa6";

        moveToDesc(title, desc, locAdd, R.drawable.padar);
    }

    public void bromoMt(View view) {
        String title = "Bromo Mountain";
        String desc = "Iconic volcano in East Java, Indonesia, known for its surreal landscapes, volcanic craters, and stunning sunrise views.";
        String locAdd = "https://maps.app.goo.gl/rfoxck6Ww34ACUZ7A";

        moveToDesc(title, desc, locAdd, R.drawable.bromojuga );
    }

    public void rajaAmpat(View view) {
        String title = "Raja Ampat";
        String desc = "Indonesian paradise of pristine islands, clear waters, vibrant coral reefs, and diverse marine life. A dream for snorkelers and divers alike.";
        String locAdd = "https://maps.app.goo.gl/JZVpE3QjzkEvpYAK8";

        moveToDesc(title, desc, locAdd, R.drawable.raja_ampat );
    }

    public void danauToba(View view) {
        String title = "Danau Toba";
        String desc = "Indonesia's largest lake, nestled in Sumatra, surrounded by lush landscapes and the cultural richness of the Batak people.";
        String locAdd = "https://maps.app.goo.gl/fWQTcfezVVF6s8XP6";

        moveToDesc(title, desc, locAdd, R.drawable.danau_toba );
    }

    public void boroBudur(View view) {
        String title = "Borobudur Temple";
        String desc = "A magnificent Buddhist temple in Central Java, the world's largest, adorned with intricate carvings and stupas, showcasing Indonesia's rich history.";
        String locAdd = "https://maps.app.goo.gl/iuXCLNoyF3NVzoLj7";

        moveToDesc(title, desc, locAdd,R.drawable.borobudur );
    }

    public void wayKambas(View view) {
        String title = "Waykambas";
        String desc = "A national park on Sumatra, home to diverse wildlife, including endangered species like Sumatran elephants. A haven for nature enthusiasts.";
        String locAdd = "https://maps.app.goo.gl/19buYTaqmM4qFUpU6";

        moveToDesc(title, desc, locAdd, R.drawable.waykambas );
    }

    public void kawahIjen(View view) {
        String title = "Kawah Ijen";
        String desc = "A captivating volcanic crater in East Java, known for its electric-blue sulfur flames and turquoise lake, offering a surreal and unique natural spectacle.";
        String locAdd = "https://maps.app.goo.gl/7p58Y22Mpq5HXpDk6";

        moveToDesc(title, desc, locAdd, R.drawable.kawah_ijenn );
    }

    public void diamondBeach(View view) {
        String title = "Diamond Beach";
        String desc = "A hidden gem in Nusa Penida, Bali, featuring pristine white sands and azure waters, creating a picturesque and idyllic tropical paradise.";
        String locAdd = "https://maps.app.goo.gl/sEeKakbGN2xQjCMy5";

        moveToDesc(title, desc, locAdd, R.drawable.nusa_penida );
    }

    public void favFunc (View view) {
        Button currentClickedButton = (Button) view;

        if (currentClickedButton.getBackground().getConstantState().equals(
                ContextCompat.getDrawable(this, R.drawable.icon_love_fill).getConstantState()
        )) {
            currentClickedButton.setBackgroundResource(R.drawable.icon_love);
            Toast.makeText(this, "Removed from Favorites", Toast.LENGTH_LONG).show();
        } else if (currentClickedButton.getBackground().getConstantState().equals(
                ContextCompat.getDrawable(this, R.drawable.icon_love).getConstantState()
        )){
            currentClickedButton.setBackgroundResource(R.drawable.icon_love_fill);
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_LONG).show();
        }

        saveButtonState();
    }


    public void moveToDesc(String title, String desc, String address, int resourceImage) {
        Intent intent = new Intent(this,detailPage.class);
        intent.putExtra("placeTitle",title);
        intent.putExtra("placeDesc",desc);
        intent.putExtra("locationAddress",address);
        intent.putExtra("placeImage",resourceImage);

        startActivity(intent);
    }

    public void moveToMap(String locationAdd) {
        Uri location = Uri.parse("geo:0,0?q="+locationAdd);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);

        startActivity(intent);
    }

    private void saveButtonState() {
        int [] numOfButtons = {R.id.buttonLike1, R.id.buttonLike2, R.id.buttonLike3, R.id.buttonLike4, R.id.buttonLike5, R.id.buttonLike6, R.id.buttonLike7, R.id.buttonLike8};
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_ICON, MODE_PRIVATE).edit();

        for (int i = 0; i<8; i++) {
            Button button = findViewById(numOfButtons[i]);
            boolean isFavorited = button.getBackground().getConstantState().equals(
                    ContextCompat.getDrawable(this, R.drawable.icon_love_fill).getConstantState()
            );
            editor.putBoolean("button_"+i, isFavorited);
        }
        editor.apply();
    }

    private void loadButtonState() {
        int [] numOfButtons = {R.id.buttonLike1, R.id.buttonLike2, R.id.buttonLike3, R.id.buttonLike4, R.id.buttonLike5, R.id.buttonLike6, R.id.buttonLike7, R.id.buttonLike8};
        SharedPreferences prefs = getSharedPreferences(PREFS_ICON, MODE_PRIVATE);

        for (int i = 0; i < 8; i++) {
            Button button = findViewById(numOfButtons[i]);
            boolean isFavorited = prefs.getBoolean("button_" + i, false);

            if (isFavorited) {
                button.setBackgroundResource(R.drawable.icon_love_fill);
            } else {
                button.setBackgroundResource(R.drawable.icon_love);
            }
        }
    }
}