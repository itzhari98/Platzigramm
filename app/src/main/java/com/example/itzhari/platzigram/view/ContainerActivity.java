package com.example.itzhari.platzigram.view;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;

import com.example.itzhari.platzigram.R;
import com.example.itzhari.platzigram.view.fragment.HomeFragment;
import com.example.itzhari.platzigram.view.fragment.ProfileFragment;
import com.example.itzhari.platzigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        //determinamos donde se abrira por defecto la pantalla en este caso en el tab home
        bottomBar.setDefaultTab(R.id.home);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch  (tabId){
                    case R.id.home:
                        HomeFragment homeFragment= new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.container, homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();


                        break;
                    case R.id.search:
                        SearchFragment searchFragment= new SearchFragment();
                        getFragmentManager().beginTransaction().replace(R.id.container, searchFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.user:
                        ProfileFragment userFragment= new ProfileFragment();
                        getFragmentManager().beginTransaction().replace(R.id.container, userFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }

            }
        });
    }
}