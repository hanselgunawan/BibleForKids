package com.example.dell.alkitabanak;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class splash_screen extends Activity {

    //Set waktu lama splashscreen
    private static int splashInterval = 3000;//dalam milisekon

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//untuk menghilangkan Title di atas Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//agar bisa full screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(splash_screen.this, MainActivity.class);
                startActivity(i);


                //menunggu untuk Splashscreen selesai, baru masuk ke MainActivity dgn memanggil fungsi finish()
                this.finish();
            }

            private void finish() {
            }
        }, splashInterval);

    };

}