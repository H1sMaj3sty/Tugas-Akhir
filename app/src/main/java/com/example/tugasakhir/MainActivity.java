package com.example.tugasakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScroll;
    private ImageView imageView;
    private int imageWidth;
    private int scrollRange;
    private boolean isAnimRunning = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalScroll = findViewById(R.id.horizontalScroll);
        imageView = findViewById(R.id.imageView);

        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageWidth = imageView.getWidth();
                scrollRange = imageWidth - horizontalScroll.getWidth();
                startAutoScroll();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showCustomAlert();
    }

    private void startAutoScroll() {
        final ValueAnimator animator = ValueAnimator.ofInt(0, scrollRange);
        animator.setDuration(10000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int newValue = (int) valueAnimator.getAnimatedValue();
                horizontalScroll.scrollTo(newValue, 0);

                if (newValue >= scrollRange && isAnimRunning) {
                    isAnimRunning = false;
                    animator.cancel();
                }
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {

            }

            @Override
            public void onAnimationCancel(@NonNull Animator animator) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {

            }
        });
        animator.start();
    }

    public void moveToSecond(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }

    private void showCustomAlert() {
        customAlertDialog alertDialog = new customAlertDialog();

        alertDialog.show(getSupportFragmentManager(), "CustomAlertDialog");
    }
}