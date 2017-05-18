package com.example.itzhari.platzigram.view.fragment;


import com.example.itzhari.platzigram.model.Picture;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.itzhari.platzigram.R;
import com.example.itzhari.platzigram.adapter.PictureAdapter_Recyclerview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        showtoolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=(RecyclerView) view.findViewById(R.id.picture_Recycler);
        LinearLayoutManager LinearLayoutMaganer = new LinearLayoutManager(getContext());
        LinearLayoutMaganer.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(LinearLayoutMaganer);
        PictureAdapter_Recyclerview pictureAdapter_recyclerview = new PictureAdapter_Recyclerview(buidPictures(),R.layout.cardview_picture, getActivity());
         picturesRecycler.setAdapter(pictureAdapter_recyclerview);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewPostFragment newPostFragment = new NewPostFragment();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.container, newPostFragment)
                        .addToBackStack(null).commit();
            }
        });
        return view;


    }
    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture>pictures=new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Uriel Ramírez", "4 días", "7 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Juan Pablo", "6 días", "8 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","María Fernanda", "12 días", "30 Me gusta"));
        return pictures;

    }

    public void showtoolbar(String title, boolean upButton, View view){
        Toolbar tolbar=(Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);


    }

}
