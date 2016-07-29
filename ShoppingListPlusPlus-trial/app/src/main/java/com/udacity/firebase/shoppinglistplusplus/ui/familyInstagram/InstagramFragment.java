package com.udacity.firebase.shoppinglistplusplus.ui.familyInstagram;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.ui.sharing.AddFriendActivity;

/**
 * Created by SteveAndrewWong on 7/27/16.
 */
public class InstagramFragment extends Fragment {
    ImageView mImageView;
//    Button mButtomTakePicture;
//    Button mButtomGetPicture;
//    private static final int REQUEST_CODE_TO_TAKEPICTURE = 1;
//    private static final int REQUEST_CODE_TO_GETPICTURE = 2;
//    private Bitmap bitmap;

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

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(getActivity(), AddFriendActivity.class);
                startActivity(takePictureIntent);
            }


        });



        return rootView;
    }




    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }



    private void initializeScreen(View rootView){
        mImageView = (ImageView) rootView.findViewById(R.id.image_view_1);


    }


}