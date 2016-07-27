package com.udacity.firebase.shoppinglistplusplus.ui.familyInstagram;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.udacity.firebase.shoppinglistplusplus.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.Inflater;

/**
 * Created by SteveAndrewWong on 7/27/16.
 */
public class InstagramFragment extends Fragment{
    ImageView mImageView;
    Button mButtomTakePicture;
    Button mButtomGetPicture;
    private static final int REQUEST_CODE_TO_TAKEPICTURE = 1;
    private static final int REQUEST_CODE_TO_GETPICTURE = 2;
    private Bitmap bitmap;

    public InstagramFragment(){

    }

    public static InstagramFragment newInstance(){
        InstagramFragment fragment = new InstagramFragment();
        // the arguments supplied here will be retained across fragment destroy and creation.
        Bundle args = new Bundle();
        fragment.setArguments(args);
        /* @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: fragment = InstagramFragment.newInstance()
                break; }
                return fragment;}
         */
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {super.onActivityCreated(savedInstanceState);}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_instagram, container, false);
        initializeScreen(rootView);

        mButtomTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, REQUEST_CODE_TO_TAKEPICTURE);
            }


        });



        return rootView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

//        InputStream stream = null;
        // take picture activity is finished -> 1. get bitmap data 2. set imageView
        if (requestCode == REQUEST_CODE_TO_TAKEPICTURE) {
            Inflater inflater = new Inflater();
            View rootView = inflater.inflate(R.layout.fragment_instagram);

            bitmap = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view_1);
            imageView.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_TO_GETPICTURE) {
            try {
                InputStream stream = null;
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    }



    


    private void initializeScreen(View rootView){
        mImageView = (ImageView) rootView.findViewById(R.id.image_view_1);
        mButtomTakePicture = (Button) rootView.findViewById(R.id.button_take_picture);
        mButtomGetPicture = (Button) rootView.findViewById(R.id.button_get_picture);

    }

}
