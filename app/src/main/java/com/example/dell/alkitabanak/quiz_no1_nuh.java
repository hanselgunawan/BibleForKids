package com.example.dell.alkitabanak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class quiz_no1_nuh extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    TextView tx_view_quiz1;
    RadioGroup rg;
    RadioButton rb1,rb2;
    SharedPreferences pref;
    MediaPlayer mediaPlayer,mediaPlayerSong;
    private final String KEY_SOAL_SATU="key_soal_satu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_no1_nuh);
        tx_view_quiz1=(TextView)findViewById(R.id.textViewQuizSoalSatu);

        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);
        mediaPlayer.start();

        rb1=(RadioButton)findViewById(R.id.radioButtonSoalSatuA);
        rb2=(RadioButton)findViewById(R.id.radioButtonSoalSatuB);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view_quiz1.setTypeface(myTypeface);
        rb1.setTypeface(myTypeface);
        rb2.setTypeface(myTypeface);

        rg=(RadioGroup)findViewById(R.id.radioGroupSoalSatu);
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        showSavedPick();

        rg.setOnCheckedChangeListener(this);

        getSupportActionBar().hide();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        if(checkedId==R.id.radioButtonSoalSatuA)
        {
            savedCheckedId(checkedId);
        }
        else if(checkedId==R.id.radioButtonSoalSatuB)
        {
            savedCheckedId(checkedId);
        }
    }

    public void showSavedPick(){
        int checked;
        checked=getChecked();
        rg.check(checked);
    }

    private int getChecked(){
        return pref.getInt(KEY_SOAL_SATU,R.id.home);//DEFAULT VALUE
    }

    private void savedCheckedId(int pilihan){
        SharedPreferences.Editor editor= pref.edit();
        editor.putInt(KEY_SOAL_SATU,pilihan);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayerSong.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayerSong=MediaPlayer.create(this,R.raw.quiz_theme_song);
        mediaPlayerSong.setLooping(true);
        mediaPlayerSong.start();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//ERROR HANDLING untuk click HOME dan BACK
        if(keyCode==KeyEvent.KEYCODE_HOME){
            SharedPreferences.Editor editor=pref.edit();
            editor.remove(KEY_SOAL_SATU);//untuk menghapus data yang ada di SharedPreference
            editor.commit();

            Intent intention=new Intent(Intent.ACTION_MAIN);//buat close app nya!
            intention.addCategory(Intent.CATEGORY_HOME);
            intention.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mediaPlayer.release();
            startActivity(intention);
            finish();
            System.exit(0);
        }
        else if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(quiz_no1_nuh.this, "Selesaikan Quiz Terlebih Dahulu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickLanjut(View v){
        Intent intent=new Intent(getApplicationContext(),quiz_no2_nuh.class);
        int checkedRadio=rg.getCheckedRadioButtonId();
        if(checkedRadio!=R.id.radioButtonSoalSatuA && checkedRadio!=R.id.radioButtonSoalSatuB)
        {
            Toast.makeText(quiz_no1_nuh.this,"Jawab Salah Satu",Toast.LENGTH_SHORT).show();
        }
        else {
            intent.putExtra("pilihan_nomor_satu", checkedRadio);
            mediaPlayer.release();
            startActivity(intent);
        }
    }
}
