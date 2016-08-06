package com.udacity.firebase.shoppinglistplusplus.ui.meals;

import android.app.Activity;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.udacity.firebase.shoppinglistplusplus.model.Chat;

/**
 * Created by SteveAndrewWong on 8/5/16.
 */
public class ChatDetailsAdapter extends FirebaseListAdapter<Chat> {
    public ChatDetailsAdapter(Activity activity, Class<Chat> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }
}
