package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences prefs = getSharedPreferences("MY_SP_EDIT", MODE_PRIVATE);
        String name = prefs.getString("ValueKey", "null");
        String pwd_b = prefs.getString("PwdKey", "null");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                Intent mainIntent;
                if (name!=null && pwd_b!=null){

                    mainIntent = new Intent(SplashActivity.this, DashboardActivity.class);
                }else {
                    mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();


            }
        }, SPLASH_DISPLAY_LENGTH);



    }


}