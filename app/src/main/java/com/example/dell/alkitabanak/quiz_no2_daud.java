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


public class quiz_no2_daud extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    TextView tx_view_quiz2;
    RadioGroup rg;
    RadioButton rb1,rb2;
    SharedPreferences pref;
    MediaPlayer mediaPlayer,mediaPlayerSong;
    private final String KEY_SOAL_SATU_DAUD="key_soal_satu_daud";//GANTI
    private final String KEY_SOAL_DUA_DAUD="key_soal_dua_daud";//GANTI
    Bundle extras;
    int pilihan_nomor_satu_daud;//GANTI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_no2_daud);//GANTI
        tx_view_quiz2=(TextView)findViewById(R.id.textViewQuizSoalDuaDaud);//GANTI
        rb1=(RadioButton)findViewById(R.id.radioButtonSoalDuaADaud);//GANTI
        rb2=(RadioButton)findViewById(R.id.radioButtonSoalDuaBDaud);//GANTI

        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);
        mediaPlayer.start();

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view_quiz2.setTypeface(myTypeface);
        rb1.setTypeface(myTypeface);
        rb2.setTypeface(myTypeface);

        extras=getIntent().getExtras();
        pilihan_nomor_satu_daud=extras.getInt("pilihan_nomor_satu_daud");//GANTI

        rg=(RadioGroup)findViewById(R.id.radioGroupSoalDuaDaud);//GANTI
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        showSavedPick();

        rg.setOnCheckedChangeListener(this);

        getSupportActionBar().hide();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        if(checkedId==R.id.radioButtonSoalDuaADaud)//GANTI
        {
            savedCheckedId(checkedId);
        }
        else if(checkedId==R.id.radioButtonSoalDuaBDaud)//GANTI
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
        return pref.getInt(KEY_SOAL_DUA_DAUD,R.id.home);//DEFAULT VALUE     //GANTI
    }

    private void savedCheckedId(int pilihan){
        SharedPreferences.Editor editor= pref.edit();
        editor.putInt(KEY_SOAL_DUA_DAUD,pilihan);//GANTI
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
            editor.remove(KEY_SOAL_SATU_DAUD);//untuk menghapus data yang ada di SharedPreference      //GANTI
            editor.remove(KEY_SOAL_DUA_DAUD);//GANTI
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
            mediaPlayer.release();
            Intent in = new Intent(getApplicationContext(),quiz_no1_daud.class);//GANTI
            startActivity(in);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickLanjut(View v){
        Intent intent=new Intent(getApplicationContext(),quiz_no3_daud.class);//GANTI
        int checkedRadio=rg.getCheckedRadioButtonId();

        if(checkedRadio!=R.id.radioButtonSoalDuaADaud && checkedRadio!=R.id.radioButtonSoalDuaBDaud)//GANTI
        {
            Toast.makeText(quiz_no2_daud.this, "Jawab Salah Satu", Toast.LENGTH_SHORT).show();//GANTI
        }
        else {
            intent.putExtra("pilihan_nomor_dua_daud", checkedRadio);//GANTI
            intent.putExtra("pilihan_nomor_satu_daud", pilihan_nomor_satu_daud);//GANTI
            mediaPlayer.release();
            startActivity(intent);
        }
    }

    public void onClickKembali(View v){
        Intent intensi=new Intent(getApplicationContext(),quiz_no1_daud.class);//GANTI
        mediaPlayer.release();
        startActivity(intensi);
    }

}
