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


public class page3_nuh extends ActionBarActivity {
    TextView tx_view3;
    MediaPlayer mediaPlayer,mediaPlayer2,mediaPlayerDubbing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3_nuh);

        tx_view3=(TextView)findViewById(R.id.textViewPageThree);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view3.setTypeface(myTypeface);

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
        mediaPlayerDubbing=MediaPlayer.create(this,R.raw.dub3_new);
        mediaPlayer2=MediaPlayer.create(this,R.raw.animal);//kasih suara Page Flip
        mediaPlayer2.setLooping(true);
        mediaPlayer2.setVolume(0.2f,0.2f);//atur volume disini!
        mediaPlayer2.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            mediaPlayer.release();
            if(mediaPlayerDubbing.isPlaying())
            {
                mediaPlayerDubbing.release();
            }
            Intent intent = new Intent(getApplicationContext(), page2_nuh.class);
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

    public void onClickPrevPageThree(View view){
        Intent intent = new Intent(getApplicationContext(), page2_nuh.class);
        mediaPlayer.release();
        if(mediaPlayerDubbing.isPlaying())
        {
            mediaPlayerDubbing.release();
        }
        startActivity(intent);
    }

    public void onClickNextPageThree(View view){
        Intent intensi = new Intent(getApplicationContext(), page4_nuh.class);
        mediaPlayer.release();
        mediaPlayerDubbing.release();
        startActivity(intensi);
    }
}
