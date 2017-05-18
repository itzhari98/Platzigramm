package com.example.itzhari.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.itzhari.platzigram.R;

public class CreateaccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        showtoolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
    }
    public void showtoolbar(String title, boolean upButton){
        Toolbar tolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
