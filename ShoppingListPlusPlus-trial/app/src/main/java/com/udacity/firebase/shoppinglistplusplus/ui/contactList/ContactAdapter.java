package com.udacity.firebase.shoppinglistplusplus.ui.contactList;

import android.app.Activity;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.udacity.firebase.shoppinglistplusplus.model.User;

/**
 * Created by SteveAndrewWong on 8/2/16.
 */
public class ContactAdapter extends FirebaseListAdapter<User> {

    public ContactAdapter(Activity activity, Class<User> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }



}
