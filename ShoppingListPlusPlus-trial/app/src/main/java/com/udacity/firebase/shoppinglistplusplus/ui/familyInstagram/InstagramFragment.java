package com.udacity.firebase.shoppinglistplusplus.ui.familyInstagram;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by SteveAndrewWong on 7/27/16.
 */
public class InstagramFragment extends Fragment{

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


}
