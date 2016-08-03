package com.udacity.firebase.shoppinglistplusplus.ui.contactList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.User;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

/**
 * Created by SteveAndrewWong on 8/2/16.
 *
 * create public constuctor and newInstance
 * get encoded email from share preference
 *
 * set up layout ListView/RecyclerView + set up FirebaseRef + adapter to populates views with data
 */
public class ContactFragment extends Fragment {
    private String mEncodedEmail;
    ContactAdapter mContactListAdapter;

    public ContactFragment(){

    }

    public ContactFragment newInstance(String mEncodedEmail){
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        
        return fragment;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Return the arguments supplied to setArguments(Bundle), if any.
        mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);




    }

    @Override
    public void onResume() {
        super.onResume();

        Firebase contactListRef = new Firebase(Constants.FIREBASE_URL_USERS);

        //TODO: create adapter + listView.setView
        // getActivity() in a Fragment returns the Activity the Fragment is currently associated
        mContactListAdapter = new ContactAdapter(getActivity(), User.class,
                R.layout.single_user_contact, contactListRef);
        }





}

