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


public class quiz_no1_daud extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    TextView tx_view_quiz1;
    RadioGroup rg;
    RadioButton rb1,rb2;
    SharedPreferences pref;
    MediaPlayer mediaPlayer,mediaPlayerSong;
    private final String KEY_SOAL_SATU_DAUD="key_soal_satu_daud";//GANTI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_no1_daud);//GANTI
        tx_view_quiz1=(TextView)findViewById(R.id.textViewQuizSoalSatuDaud);//GANTI

        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);
        mediaPlayer.start();

        rb1=(RadioButton)findViewById(R.id.radioButtonSoalSatuADaud);//GANTI
        rb2=(RadioButton)findViewById(R.id.radioButtonSoalSatuBDaud);//GANTI

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view_quiz1.setTypeface(myTypeface);
        rb1.setTypeface(myTypeface);
        rb2.setTypeface(myTypeface);

        rg=(RadioGroup)findViewById(R.id.radioGroupSoalSatuDaud);//GANTI
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        showSavedPick();

        rg.setOnCheckedChangeListener(this);

        getSupportActionBar().hide();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        if(checkedId==R.id.radioButtonSoalSatuADaud)//GANTI
        {
            savedCheckedId(checkedId);
        }
        else if(checkedId==R.id.radioButtonSoalSatuBDaud)//GANTI
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
        return pref.getInt(KEY_SOAL_SATU_DAUD,R.id.home);//DEFAULT VALUE    //GANTI
    }

    private void savedCheckedId(int pilihan){
        SharedPreferences.Editor editor= pref.edit();
        editor.putInt(KEY_SOAL_SATU_DAUD,pilihan);//GANTI
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
            editor.remove(KEY_SOAL_SATU_DAUD);//untuk menghapus data yang ada di SharedPreference   //GANTI
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
            Toast.makeText(quiz_no1_daud.this, "Selesaikan Quiz Terlebih Dahulu", Toast.LENGTH_SHORT).show();//GANTI
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickLanjut(View v){
        Intent intent=new Intent(getApplicationContext(),quiz_no2_daud.class);//GANTI
        int checkedRadio=rg.getCheckedRadioButtonId();
        if(checkedRadio!=R.id.radioButtonSoalSatuADaud && checkedRadio!=R.id.radioButtonSoalSatuBDaud)//GANTI
        {
            Toast.makeText(quiz_no1_daud.this,"Jawab Salah Satu",Toast.LENGTH_SHORT).show();//GANTI
        }
        else {
            intent.putExtra("pilihan_nomor_satu_daud", checkedRadio);//GANTI
            mediaPlayer.release();
            startActivity(intent);
        }
    }
}
