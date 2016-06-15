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


public class quiz_result_nuh extends ActionBarActivity {
    SharedPreferences pref;
    private final String KEY_SOAL_SATU="key_soal_satu";
    private final String KEY_SOAL_DUA="key_soal_dua";
    private final String KEY_SOAL_TIGA="key_soal_tiga";
    private final String KEY_SOAL_EMPAT="key_soal_empat";

    MediaPlayer mediaPlayer,mediaPlayerVictory;

    Bundle extras;
    ImageView imageViewResult;
    int pilihan_satu,pilihan_dua,pilihan_tiga,pilihan_empat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_result_nuh);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResultNuh);
        mediaPlayer = MediaPlayer.create(this, R.raw.page_flip);

        extras = getIntent().getExtras();
        pilihan_satu = extras.getInt("pilihan_nomor_satu");
        pilihan_dua = extras.getInt("pilihan_nomor_dua");
        pilihan_tiga = extras.getInt("pilihan_nomor_tiga");
        pilihan_empat = extras.getInt("pilihan_nomor_empat");

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
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.seratus_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.seratus_poin));
            }

            //TUJUH LIMA POIN
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin));
            }
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin));
            }
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.tujuhlima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.tujuhlima_poin));
            }

            //LIMA PULUH POIN
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.limapuluh_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.limapuluh_poin));
            }

            //DUA LIMA POIN
            if(pilihan_satu==R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua==R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga==R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin));
            }
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat==R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.dualima_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.dualima_poin));
            }

            //NOL POIN
            if(pilihan_satu!=R.id.radioButtonSoalSatuA && pilihan_dua!=R.id.radioButtonSoalDuaA && pilihan_tiga!=R.id.radioButtonSoalTigaA
                    && pilihan_empat!=R.id.radioButtonSoalEmpatA){
                mediaPlayerVictory=MediaPlayer.create(this,R.raw.nol_theme_song);
                mediaPlayerVictory.setVolume(1.0f,1.0f);
                mediaPlayerVictory.start();
                imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.nol_poin));
            }
        }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//ERROR HANDLING untuk click HOME dan BACK
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent inten = new Intent(getApplicationContext(),quiz_no1_nuh.class);
            SharedPreferences.Editor editor=pref.edit();
            editor.remove(KEY_SOAL_SATU);
            editor.remove(KEY_SOAL_DUA);
            editor.remove(KEY_SOAL_TIGA);
            editor.remove(KEY_SOAL_EMPAT);
            editor.commit();
            startActivity(inten);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClickCobaLagi(View v){
        Intent intent = new Intent(getApplicationContext(),quiz_no1_nuh.class);
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU);
        editor.remove(KEY_SOAL_DUA);
        editor.remove(KEY_SOAL_TIGA);
        editor.remove(KEY_SOAL_EMPAT);
        editor.commit();
        startActivity(intent);
    }

    public void onClickBacaUlang(View v){
        Intent intensi=new Intent(getApplicationContext(),homeNuh.class);
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU);//untuk menghapus data yang ada di SharedPreference
        editor.remove(KEY_SOAL_DUA);//bisa pakai editor.clear() juga!
        editor.remove(KEY_SOAL_TIGA);
        editor.remove(KEY_SOAL_EMPAT);
        editor.commit();
        startActivity(intensi);
    }

    public void onClickMenuUtama(View v){
        Intent intention=new Intent(getApplicationContext(),MainActivity.class);
        SharedPreferences.Editor editor=pref.edit();
        editor.remove(KEY_SOAL_SATU);
        editor.remove(KEY_SOAL_DUA);
        editor.remove(KEY_SOAL_TIGA);
        editor.remove(KEY_SOAL_EMPAT);
        editor.commit();
        startActivity(intention);
    }
}
