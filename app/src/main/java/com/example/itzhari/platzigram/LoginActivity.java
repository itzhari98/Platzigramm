package com.example.itzhari.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.itzhari.platzigram.view.ContainerActivity;
import com.example.itzhari.platzigram.view.CreateaccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void  gocreateaccount(View view){
        Intent intent= new Intent(this, CreateaccountActivity.class);
        startActivity(intent);

    }
    public void  loginaccount (View view){
        Intent intent= new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }
    public void navegador(View logo) throws Exception{
        String link= "http:www.platzigram.com";
        Intent intent = null;
        intent= new Intent(intent.ACTION_VIEW,Uri.parse(link));
        startActivity(intent);
    }
}
