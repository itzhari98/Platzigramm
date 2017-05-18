package com.example.itzhari.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.os.BuildCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itzhari.platzigram.R;
import com.example.itzhari.platzigram.model.Picture;
import com.example.itzhari.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by itzhari on 02/05/2017.
 */

public class PictureAdapter_Recyclerview  extends RecyclerView.Adapter<PictureAdapter_Recyclerview.PictureViewHolder>{


    private ArrayList<Picture> pictures;
    //el cardview que hayamo  creado
    private int resource;
    // la actividad de donde se llamara el cardview
    private Activity activity;
    public PictureAdapter_Recyclerview(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //aqui se trabajara con la lista de elemnteos y se hara el pasa de datos
        //tenemos accesso a cada view
        Picture picture=pictures.get(position);
        holder.username_card.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.LikenumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(activity, PictureDetailActivity.class);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,activity.getString(R.string.transitionname_picture)).toBundle());
                }else {
                    activity.startActivity(intent);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView username_card;
        private TextView timeCard;
        private TextView LikenumberCard;


        public PictureViewHolder(View itemView){
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.picture_caRd);
            username_card = (TextView) itemView.findViewById(R.id.username_card);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            LikenumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);





        }
    }
}