package com.example.itzhari.platzigram.view;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;

import com.example.itzhari.platzigram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showtoolbar("",true);
        //validacion de nuestra entrada para la transicion
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Fade());
        }

    }
    public void showtoolbar(String title, boolean upButton){
        Toolbar tolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tolbar);
       getSupportActionBar().setTitle(title);
      getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout =(CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);

    }

}
