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
import android.widget.TextView;
import android.widget.Toast;


public class quiz_no4_nuh extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    TextView tx_view_quiz4;
    RadioGroup rg;
    RadioButton rb1,rb2;
    SharedPreferences pref;
    MediaPlayer mediaPlayer,mediaPlayerSong;
    private final String KEY_SOAL_SATU="key_soal_satu";
    private final String KEY_SOAL_DUA="key_soal_dua";
    private final String KEY_SOAL_TIGA="key_soal_tiga";
    private final String KEY_SOAL_EMPAT="key_soal_empat";
    Bundle extras;
    int pilihan_nomor_satu,pilihan_nomor_dua,pilihan_nomor_tiga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_no4_nuh);
        tx_view_quiz4=(TextView)findViewById(R.id.textViewQuizSoalEmpat);
        rb1=(RadioButton)findViewById(R.id.radioButtonSoalEmpatA);
        rb2=(RadioButton)findViewById(R.id.radioButtonSoalEmpatB);

        mediaPlayer=MediaPlayer.create(this,R.raw.page_flip);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"josefin.ttf");
        tx_view_quiz4.setTypeface(myTypeface);
        rb1.setTypeface(myTypeface);
        rb2.setTypeface(myTypeface);

        extras=getIntent().getExtras();
        pilihan_nomor_satu=extras.getInt("pilihan_nomor_satu");
        pilihan_nomor_dua=extras.getInt("pilihan_nomor_dua");
        pilihan_nomor_tiga=extras.getInt("pilihan_nomor_tiga");

        rg=(RadioGroup)findViewById(R.id.radioGroupSoalEmpat);
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        mediaPlayer.start();

        showSavedPick();

        rg.setOnCheckedChangeListener(this);

        getSupportActionBar().hide();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        if(checkedId==R.id.radioButtonSoalEmpatA)
        {
            savedCheckedId(checkedId);
        }
        else if(checkedId==R.id.radioButtonSoalEmpatB)
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
        return pref.getInt(KEY_SOAL_EMPAT,R.id.home);//DEFAULT VALUE
    }

    private void savedCheckedId(int pilihan){
        SharedPreferences.Editor editor= pref.edit();
        editor.putInt(KEY_SOAL_EMPAT,pilihan);
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
            editor.remove(KEY_SOAL_DUA);
            editor.remove(KEY_SOAL_TIGA);
            editor.remove(KEY_SOAL_EMPAT);
            editor.commit();

            Intent intention=new Intent(Intent.ACTION_MAIN);//buat close app nya!
            intention.addCategory(Intent.CATEGORY_HOME);
            intention.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intention);
            mediaPlayer.release();
            finish();
            System.exit(0);
        }
        else if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent in = new Intent(getApplicationContext(),quiz_no3_nuh.class);
            mediaPlayer.release();
            in.putExtra("pilihan_nomor_satu", pilihan_nomor_satu);//HARUS DIPAKE JUGA!
            in.putExtra("pilihan_nomor_dua", pilihan_nomor_dua);//HARUS DIPAKE JUGA!
            startActivity(in);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickLanjut(View v) {
        Intent intent = new Intent(getApplicationContext(), quiz_result_nuh.class);//jangan lupa ganti!
        int checkedRadio = rg.getCheckedRadioButtonId();
        if(checkedRadio!=R.id.radioButtonSoalEmpatA && checkedRadio!=R.id.radioButtonSoalEmpatB)
        {
            Toast.makeText(quiz_no4_nuh.this, "Jawab Salah Satu", Toast.LENGTH_SHORT).show();
        }
        else {
            intent.putExtra("pilihan_nomor_empat", checkedRadio);
            intent.putExtra("pilihan_nomor_satu", pilihan_nomor_satu);
            intent.putExtra("pilihan_nomor_dua", pilihan_nomor_dua);
            intent.putExtra("pilihan_nomor_tiga", pilihan_nomor_tiga);
            mediaPlayer.release();
            startActivity(intent);
        }
    }

    public void onClickKembali(View v){
        Intent intensi=new Intent(getApplicationContext(),quiz_no3_nuh.class);
        intensi.putExtra("pilihan_nomor_satu", pilihan_nomor_satu);//HARUS DIPAKE JUGA!
        intensi.putExtra("pilihan_nomor_dua", pilihan_nomor_dua);//HARUS DIPAKE JUGA!
        mediaPlayer.release();
        startActivity(intensi);
    }
}
