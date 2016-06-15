package com.example.dell.alkitabanak;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class page4_nuh extends ActionBarActivity {
    TextView tx_view4;
    MediaPlayer mediaPlayer,mediaPlayer2,mediaPlayerDubbing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_nuh);
        tx_view4=(TextView)findViewById(R.id.textViewPageFour);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view4.setTypeface(myTypeface);
        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);//kasih suara Page Flip
        mediaPlayer.start();

        getSupportActionBar().hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayerDubbing.release();
        mediaPlayer2.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayerDubbing=MediaPlayer.create(this,R.raw.dub4_new);
        mediaPlayer2=MediaPlayer.create(this,R.raw.thunderstorm);//kasih suara Page Flip
        mediaPlayer2.setLooping(true);
        mediaPlayer2.setVolume(0.4f,0.4f);//atur volume disini!
        mediaPlayer2.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            mediaPlayer.release();
            mediaPlayer2.release();
            if(mediaPlayerDubbing.isPlaying())
            {
                mediaPlayerDubbing.release();
            }
            Intent intent = new Intent(getApplicationContext(), page3_nuh.class);//jangan lupa ubah
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickDub(View v){
        if(mediaPlayerDubbing.isPlaying())
        {
            mediaPlayerDubbing.seekTo(0);
        }
        else {
            mediaPlayerDubbing.setVolume(1.0f, 1.0f);
            mediaPlayerDubbing.start();
        }
    }

    public void onClickPrevPageFour(View view){
        Intent intent = new Intent(getApplicationContext(), page3_nuh.class);
        mediaPlayer.release();
        mediaPlayer2.release();
        if(mediaPlayerDubbing.isPlaying())
        {
            mediaPlayerDubbing.release();
        }
        startActivity(intent);
    }

    public void onClickNextPageFour(View view){
        Intent intensi = new Intent(getApplicationContext(), page5_nuh.class);
        mediaPlayer.release();
        mediaPlayer2.release();
        mediaPlayerDubbing.release();
        startActivity(intensi);
    }
}

