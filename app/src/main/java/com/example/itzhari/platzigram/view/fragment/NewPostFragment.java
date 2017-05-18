package com.example.itzhari.platzigram.view.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itzhari.platzigram.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPostFragment extends Fragment {
 ImageView ivPicture;
    Button btnTakepicture;
    static  final  int REQUEST_IMAGE_CAPTURE=1;
    String CurrentPhotoPath;

    public NewPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_post, container, false);
        ivPicture = (ImageView)view.findViewById(R.id.imageviewpicture);
        btnTakepicture =(Button) view.findViewById(R.id.buttonthepicture);
        btnTakepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK){
            Picasso.with(getActivity()).load(CurrentPhotoPath).into(ivPicture);
            addPictureToGalery();
            Toast.makeText(getActivity(),CurrentPhotoPath, Toast.LENGTH_SHORT).show();

        }
    }

    private void takePicture() {
        Intent takePictureInten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureInten.resolveActivity(getActivity().getPackageManager())!=null){
            File photfile =  null;
            try {
                photfile= createimage();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if(photfile != null){
                Uri photoURI= FileProvider.getUriForFile(getActivity(),
                        "com.example.itzhari.platzigram",
                        photfile);
                takePictureInten.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureInten, REQUEST_IMAGE_CAPTURE);
            }

        }

    }
    private File createimage() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFilename = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFilename,
                "jpg",
                storageDir
        );
        CurrentPhotoPath = "file:"+ image.getAbsolutePath();

        return  image;
    }

    private  void addPictureToGalery(){
        Intent mediaScanInten = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f  = new File(CurrentPhotoPath);
        Uri contenUri = Uri.fromFile( f);
        mediaScanInten.setData(contenUri);
        getActivity().sendBroadcast(mediaScanInten);

    }

}
