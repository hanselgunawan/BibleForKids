package com.example.dell.alkitabanak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class homeNuh extends ActionBarActivity {
    MediaPlayer mediaPlayer,mediaPlayer2;
    Intent intent;
    ImageView imageView_homeNuh;
    SharedPreferences pref;
    private final String KEY_SOAL_SATU="key_soal_satu";
    private final String KEY_SOAL_DUA="key_soal_dua";
    private final String KEY_SOAL_TIGA="key_soal_tiga";
    private final String KEY_SOAL_EMPAT="key_soal_empat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nuh);
        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);//kasih suara Page Flip
        mediaPlayer.start();

        intent = new Intent(getApplicationContext(),page1_nuh.class);
        imageView_homeNuh=(ImageView)findViewById(R.id.imageViewHomeNuh);
        imageView_homeNuh.setImageDrawable(getResources().getDrawable(R.drawable.cover_nuh));

        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU);
        editor.remove(KEY_SOAL_DUA);
        editor.remove(KEY_SOAL_TIGA);
        editor.remove(KEY_SOAL_EMPAT);
        editor.commit();

        getSupportActionBar().hide();
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//untuk menghilangkan Title di atas Screen
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//agar bisa full screen
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer2.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer2=MediaPlayer.create(this,R.raw.cover_page_nuh);//kasih suara Page Flip
        mediaPlayer2.setLooping(true);
        mediaPlayer2.setVolume(1.0f,1.0f);
        mediaPlayer2.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            mediaPlayer.release();
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickMulaiBaca(View v){
        mediaPlayer.release();
        startActivity(intent);
        //imageView_homeNuh.setImageDrawable(null);
    }

}
