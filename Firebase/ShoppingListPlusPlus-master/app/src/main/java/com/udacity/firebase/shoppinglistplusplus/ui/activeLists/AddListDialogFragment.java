package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;
import com.udacity.firebase.shoppinglistplusplus.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * MainActivity: DialogFragment dialog = AddListDialogFragment.newInstance(mEncodedEmail);
 *
 * Adds a new shopping list
 *
 * 1. Public static constructor that creates fragment -> creates Bundle with data from parameters -> pass Bundle into Fragment
 * 2. public static AddListDialogFragment newInstance(String encodedEmail) -> bundle.putString(Constants.KEY_ENCODED_EMAIL, encodedEmail);
 * 3. Get encodedEmail from newInstance.setArgument(bundle) -> mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);
 * 4. Build Dialog -> new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog); + inflater.inflate(R.layout.dialog_add_list, null) + rootView.findViewById(R.id.edit_text_list_name);
 * 5. mEditTextListName.setOnEditorActionListener -> if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN)
 * 6. AddShoppingList() -> Utils.updateMapForAllWithValue(null, listId, mEncodedEmail, updateShoppingListData, "", shoppingListMap);
 *
 *
 */
public class AddListDialogFragment extends DialogFragment {
    String mEncodedEmail;
    EditText mEditTextListName;








    /**
     * Public static constructor that creates fragment and passes a bundle with encoded email
     *
     * Public constructor -> when you want to run fragment in MainActivity
     */
    // MainActivity: public void showAddListDialog(View view)
    // Fragment_shopping_lists.xml when + is clicked -> run showAddListDialog in MainActivity: AddListDialogFragment.newInstance(mEncodedEmail); + dialog.show()->
    // pass stuff from MainActivity to your fragment
    // so that they are available after a Fragment is recreated by Android -> is to pass a bundle to the setArguments method.
    // then get it in onCreate -> mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);

    public static AddListDialogFragment newInstance(String encodedEmail) {
        AddListDialogFragment addListDialogFragment = new AddListDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ENCODED_EMAIL, encodedEmail);
        addListDialogFragment.setArguments(bundle);
        return addListDialogFragment;
    }









    /**
     * Get mEncodedEmail instance variables from bundle data from LoginActivity
     *
     * LoginActivity:
     * private void setAuthenticatedUserPasswordProvider(AuthData authData)
     * final String unprocessedEmail = authData.getProviderData().get(Constants.FIREBASE_PROPERTY_EMAIL).toString().toLowerCase();
     * mSharedPrefEditor.putString(Constants.KEY_ENCODED_EMAIL, mEncodedEmail).apply();
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // a new ShoppingList requires user email
        // addListDialogFragment.setArguments(bundle);
        mEncodedEmail = getArguments().getString(Constants.KEY_ENCODED_EMAIL);
    }








    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }









    // this is the actually building of dialog before dialog.show()
    // Build AlertDialog + inflate dialog_add_list layout into View -> Builder.setView(View)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction -> e.g. builder.setView(rootView)
        // ???????????????????????? where is R.style.CustomTheme_Dialog -> maybe it is just config parameter ??
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog);
        // Get the layout inflater
        // Layout inflater converts XML into java widget
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // null is parent: parent means layout or container to add this widget to
        // Pass null as the parent view because its going in the dialog layout
        View rootView = inflater.inflate(R.layout.dialog_add_list, null);


        mEditTextListName = (EditText) rootView.findViewById(R.id.edit_text_list_name);

        /**
         * Call addShoppingList() when user taps "Done" keyboard action
         */
        mEditTextListName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

                    addShoppingList();
                }
                return true;
            }
        });






        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        // null + layout.addView(View) -> getLayoutInflater().inflate(R.layout.xx, layout) // layout is the parent you are adding view to
        // define a custom dialog
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton(R.string.positive_button_create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addShoppingList();
                    }
                });

        // builder.create() returns an AlertDialog dialog
        return builder.create();
    }









    /**
     * 1. userList
     * 2.
     * 3.
     *
     */
    public void addShoppingList() {
        String userEnteredName = mEditTextListName.getText().toString();
        if (!userEnteredName.equals("")) {

            /**
             * Atomic write: update multiple places in database, all the locations in our database are updated at the same time and the write command is sent as one operation to the server
             */

            Firebase userListsRef = new Firebase(Constants.FIREBASE_URL_USER_LISTS).child(mEncodedEmail);
            final Firebase firebaseRef = new Firebase(Constants.FIREBASE_URL);
            Firebase newListRef = userListsRef.push();
            /* Save listsRef.push() to maintain same random Id */
            final String listId = newListRef.getKey();






            /* HashMap for data to update */
            HashMap<String, Object> updateShoppingListData = new HashMap<>();

            /**
             * Set raw version of date to the ServerValue.TIMESTAMP value and save into
             * timestampCreatedMap
             */
            HashMap<String, Object> timestampCreated = new HashMap<>();
            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);







            /* Build the shopping list */
            // this.listName = listName; this.owner = owner; this.timestampCreated = timestampCreated;
            ShoppingList newShoppingList = new ShoppingList(userEnteredName, mEncodedEmail,
                    timestampCreated);

            // Jackson's ObjectMapper class -> convert a POJO style objects into Maps
            HashMap<String, Object> shoppingListMap = (HashMap<String, Object>)
                    new ObjectMapper().convertValue(newShoppingList, Map.class);

            /*
            * ATMOIC WRITE MAP
            * 
            * public static HashMap<String, Object> updateMapForAllWithValue
            *
            * final HashMap<String, User> sharedWith,
            * final String listId,
            * final String owner,
            * HashMap<String, Object> mapToUpdate,
            * String propertyToUpdate,
            * Object valueToUpdate)
            *
            * */

            // return updateShoppingListData
            Utils.updateMapForAllWithValue(null, listId, mEncodedEmail,
                    updateShoppingListData, "", shoppingListMap);









            updateShoppingListData.put("/" + Constants.FIREBASE_LOCATION_OWNER_MAPPINGS + "/" + listId,
                    mEncodedEmail);
            firebaseRef.updateChildren(updateShoppingListData, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    /* Now that we have the timestamp, update the reversed timestamp */
                    Utils.updateTimestampReversed(firebaseError, "AddList", listId,
                            null, mEncodedEmail);
                }
            });




            /* Close the dialog fragment */
            AddListDialogFragment.this.getDialog().cancel();
        }
    }
}

