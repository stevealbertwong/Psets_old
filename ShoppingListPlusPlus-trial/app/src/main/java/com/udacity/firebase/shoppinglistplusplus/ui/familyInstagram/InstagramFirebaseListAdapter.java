package com.udacity.firebase.shoppinglistplusplus.ui.familyInstagram;

import android.app.Activity;
import android.view.View;

import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.udacity.firebase.shoppinglistplusplus.model.Instagram;

/**
 * Created by SteveAndrewWong on 8/4/16.
 */
public class InstagramFirebaseListAdapter extends FirebaseListAdapter<Instagram> {


    public InstagramFirebaseListAdapter(Activity activity, Class<Instagram> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }

    @Override
    protected void populateView(View v, Instagram model) {
        super.populateView(v, model);
        String ownerName = model.getOwnerName();
        String pictureBase64 = model.getPicture();


    }
}
