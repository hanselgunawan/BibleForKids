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


public class homeDaud extends ActionBarActivity {
    MediaPlayer mediaPlayer,mediaPlayer2;
    Intent intent;
    SharedPreferences pref;
    private final String KEY_SOAL_SATU_DAUD="key_soal_satu_daud";
    private final String KEY_SOAL_DUA_DAUD="key_soal_dua_daud";
    private final String KEY_SOAL_TIGA_DAUD="key_soal_tiga_daud";
    private final String KEY_SOAL_EMPAT_DAUD="key_soal_empat_daud";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_daud);
        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);//kasih suara Page Flip

        mediaPlayer.start();

        intent = new Intent(getApplicationContext(),page1_daud.class);

        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU_DAUD);
        editor.remove(KEY_SOAL_DUA_DAUD);
        editor.remove(KEY_SOAL_TIGA_DAUD);
        editor.remove(KEY_SOAL_EMPAT_DAUD);
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
        mediaPlayer2=MediaPlayer.create(this,R.raw.daud_cover);//kasih suara Page Flip
        mediaPlayer2.setLooping(true);
        mediaPlayer2.setVolume(0.5f,0.5f);
        mediaPlayer2.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickMulaiBaca(View v){
        mediaPlayer.release();
        startActivity(intent);
    }

}
