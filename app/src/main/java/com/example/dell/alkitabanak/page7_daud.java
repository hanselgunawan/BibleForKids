package com.example.dell.alkitabanak;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


public class page7_daud extends ActionBarActivity {
    TextView tx_view;
    MediaPlayer mediaPlayer,mediaPlayer2,mediaPlayerDubbing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page7_daud);//GANTI
        tx_view=(TextView)findViewById(R.id.textViewSevenDaud);//GANTI
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view.setTypeface(myTypeface);

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
        mediaPlayerDubbing=MediaPlayer.create(this,R.raw.dub7_daud);
        mediaPlayer2=MediaPlayer.create(this,R.raw.daud_page7);
        mediaPlayer2.setLooping(true);
        mediaPlayer2.setVolume(0.5f,0.5f);
        mediaPlayer2.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(getApplicationContext(),page6_daud.class);//GANTI
            if(mediaPlayerDubbing.isPlaying())
            {
                mediaPlayerDubbing.release();
            }
            mediaPlayer.release();
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

    public void onClickPrevPageSevenDaud(View v){//<<<<--------------------
        mediaPlayer.release();
        if(mediaPlayerDubbing.isPlaying())
        {
            mediaPlayerDubbing.release();
        }
        Intent intent=new Intent(getApplicationContext(),page6_daud.class);
        startActivity(intent);
    }

    public void onClickNextPageSevenDaud(View v){//<<<<--------------------
        mediaPlayer.release();
        mediaPlayerDubbing.release();
        Intent intensi=new Intent(getApplicationContext(),quiz_no1_daud.class);//<----JANGAN LUPA GANTI 4!
        startActivity(intensi);
    }
}
