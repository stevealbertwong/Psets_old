package com.udacity.firebase.shoppinglistplusplus.ui.activeListDetails;

import android.app.Dialog;
import android.os.Bundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingListItem;
import com.udacity.firebase.shoppinglistplusplus.model.User;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;
import com.udacity.firebase.shoppinglistplusplus.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Let user add new list item.
 *
 * 1. Public static constructor that creates fragment -> creates Bundle with data from parameters -> pass Bundle into Fragment
 *
 *
 *
 */
public class AddListItemDialogFragment extends EditListDialogFragment {











    /**
     * Public static constructor that creates fragment -> creates Bundle with data from parameters -> pass Bundle into Fragment
     * (which happens when adapter is created)
     */
    // use EditListDialogFragment to create Bundle and pass to AddListDialogFragment
    public static AddListItemDialogFragment newInstance(ShoppingList shoppingList, String listId,
                                                        String encodedEmail,
                                                        HashMap<String, User> sharedWithUsers) {

        AddListItemDialogFragment addListItemDialogFragment = new AddListItemDialogFragment();
        Bundle bundle = EditListDialogFragment.newInstanceHelper(shoppingList,
                R.layout.dialog_add_item, listId, encodedEmail, sharedWithUsers);
        addListItemDialogFragment.setArguments(bundle);

        return addListItemDialogFragment;
    }













    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }






    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /** {@link EditListDialogFragment#createDialogHelper(int)} is a
         * superclass method that creates the dialog
         **/
        return super.createDialogHelper(R.string.positive_button_add_list_item);
    }









    /**
     * Add new item to Firebase ref current shopping list through POJO
     *
     * Get mItemName from mEditTextForList
     * -> if there is input, create FirebaseRef + HashMap
     * -> Create POJO i.e. ShoppingListItem model with paramter mItemName, mEncodedEmail
     * -> convert itemToAddObject ShoppingListItem into itemToAdd HashMap
     * -> add ("Firebase/mListId/itemId", itemToAdd) to updatedItemToAddMap HashMap
     * -> shot HashMap data to Firebase: firebaseRef.updateChildren(updatedItemToAddMap, new Firebase.CompletionListener()
     */
    @Override
    protected void doListEdit() {


        String mItemName = mEditTextForList.getText().toString();





        //  Adds list item if the input name is not empty
        if (!mItemName.equals("")) {

            Firebase firebaseRef = new Firebase(Constants.FIREBASE_URL);
            Firebase itemsRef = new Firebase(Constants.FIREBASE_URL_SHOPPING_LIST_ITEMS).child(mListId);

            /* Make a map for the item you are adding */
            HashMap<String, Object> updatedItemToAddMap = new HashMap<String, Object>();

            /* Save push() to maintain same random Id */
            Firebase newRef = itemsRef.push();
            String itemId = newRef.getKey();









            /* Make a POJO i.e. model for the item and immediately turn it into a HashMap */
            ShoppingListItem itemToAddObject = new ShoppingListItem(mItemName, mEncodedEmail);
            HashMap<String, Object> itemToAdd =
                    (HashMap<String, Object>) new ObjectMapper().convertValue(itemToAddObject, Map.class);


            /* Convert the POJO ShoppingListItem to HashMap itemToAdd -> then stored in the created updatedItemToAddMap */
            updatedItemToAddMap.put("/" + Constants.FIREBASE_LOCATION_SHOPPING_LIST_ITEMS + "/"
                    + mListId + "/" + itemId, itemToAdd);

            /* Update affected lists timestamps */
            Utils.updateMapWithTimestampLastChanged(mSharedWith,
                    mListId, mOwner, updatedItemToAddMap);











            // update the Hashmap updatedItemToAddMap to FirebaseRef
            firebaseRef.updateChildren(updatedItemToAddMap, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    /* Now that we have the timestamp, update the reversed timestamp */
                    Utils.updateTimestampReversed(firebaseError, "AddListItem", mListId,
                            mSharedWith, mOwner);
                }
            });









            /**
             * Close the dialog fragment when done
             */
            AddListItemDialogFragment.this.getDialog().cancel();
        }
    }
}
