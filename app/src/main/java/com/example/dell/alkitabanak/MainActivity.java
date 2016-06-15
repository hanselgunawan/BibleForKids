package com.example.dell.alkitabanak;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//buat hilangin title bar di ActionBarActivity
    }

    public void onClickNuh(View v){
        Intent intent=new Intent(getApplicationContext(),homeNuh.class);
        startActivity(intent);
    }

    public void onClickDaud(View v){
        Intent intent=new Intent(getApplicationContext(),homeDaud.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intention=new Intent(Intent.ACTION_MAIN);//buat close app nya!
            intention.addCategory(Intent.CATEGORY_HOME);
            intention.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intention);
            finish();
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }

}
