package com.example.dell.alkitabanak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;


public class quiz_result_daud extends ActionBarActivity {
    SharedPreferences pref;
    private final String KEY_SOAL_SATU_DAUD="key_soal_satu_daud";
    private final String KEY_SOAL_DUA_DAUD="key_soal_dua_daud";
    private final String KEY_SOAL_TIGA_DAUD="key_soal_tiga_daud";
    private final String KEY_SOAL_EMPAT_DAUD="key_soal_empat_daud";

    MediaPlayer mediaPlayer,mediaPlayerVictory;

    Bundle extras;
    ImageView imageViewResult;
    int pilihan_satu_daud,pilihan_dua_daud,pilihan_tiga_daud,pilihan_empat_daud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_result_daud);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResultDaud);
        mediaPlayer = MediaPlayer.create(this, R.raw.page_flip);

        extras = getIntent().getExtras();
        pilihan_satu_daud = extras.getInt("pilihan_nomor_satu_daud");
        pilihan_dua_daud = extras.getInt("pilihan_nomor_dua_daud");
        pilihan_tiga_daud = extras.getInt("pilihan_nomor_tiga_daud");
        pilihan_empat_daud = extras.getInt("pilihan_nomor_empat_daud");

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        getSupportActionBar().hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayerVictory.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //SERATUS POIN
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.seratus_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.seratus_poin_daud));
        }

        //TUJUH LIMA POIN
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin_daud));
        }
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin_daud));
        }
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin_daud));
        }

        //LIMA PULUH POIN
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin_daud));
        }

        //DUA LIMA POIN
        if(pilihan_satu_daud==R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud==R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud==R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin_daud));
        }
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud==R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin_daud));
        }

        //NOL POIN
        if(pilihan_satu_daud!=R.id.radioButtonSoalSatuADaud && pilihan_dua_daud!=R.id.radioButtonSoalDuaADaud && pilihan_tiga_daud!=R.id.radioButtonSoalTigaADaud
                && pilihan_empat_daud!=R.id.radioButtonSoalEmpatADaud){
            mediaPlayerVictory=MediaPlayer.create(this,R.raw.nol_theme_song);
            mediaPlayerVictory.setVolume(1.0f,1.0f);
            mediaPlayerVictory.start();
            imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.nol_poin_daud));
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//ERROR HANDLING untuk click HOME dan BACK
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent inten = new Intent(getApplicationContext(),quiz_no1_daud.class);
            SharedPreferences.Editor editor=pref.edit();
            editor.remove(KEY_SOAL_SATU_DAUD);
            editor.remove(KEY_SOAL_DUA_DAUD);
            editor.remove(KEY_SOAL_TIGA_DAUD);
            editor.remove(KEY_SOAL_EMPAT_DAUD);
            editor.commit();
            startActivity(inten);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickCobaLagi(View v){
        Intent intent = new Intent(getApplicationContext(),quiz_no1_daud.class);
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU_DAUD);
        editor.remove(KEY_SOAL_DUA_DAUD);
        editor.remove(KEY_SOAL_TIGA_DAUD);
        editor.remove(KEY_SOAL_EMPAT_DAUD);
        editor.commit();
        startActivity(intent);
    }

    public void onClickBacaUlang(View v){
        Intent intensi=new Intent(getApplicationContext(),homeDaud.class);//GANTIIIIIIII!!
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU_DAUD);//untuk menghapus data yang ada di SharedPreference
        editor.remove(KEY_SOAL_DUA_DAUD);//bisa pakai editor.clear() juga!
        editor.remove(KEY_SOAL_TIGA_DAUD);
        editor.remove(KEY_SOAL_EMPAT_DAUD);
        editor.commit();
        startActivity(intensi);
    }

    public void onClickMenuUtama(View v){
        Intent intention=new Intent(getApplicationContext(),MainActivity.class);
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU_DAUD);
        editor.remove(KEY_SOAL_DUA_DAUD);
        editor.remove(KEY_SOAL_TIGA_DAUD);
        editor.remove(KEY_SOAL_EMPAT_DAUD);
        editor.commit();
        startActivity(intention);
    }
}
