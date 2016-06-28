package com.example.steveandrewwong.a193login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


import stanford.andriodlib.*;

import static java.lang.Math.log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this); // set android context to be this activity
    }

    public void loginClick(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String email = nameEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.password);
        String password = passwordEditText.getText().toString();

        // CREATING FIREBASE OBJECT
        // look up this person's password in Firebase
        // 1st step: figure out which part of database to go
        Firebase firebase = new Firebase("https://amber-inferno-3012.firebaseio.com/");
        Firebase fbName = firebase.child("simpsons").child("students").child("123").child("name"); // return a firebase

        // SETTING DATA
        // once a new value is set -> on complete callback
        fbName.setValue("d-dog", new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        // TODO
                    }
                });

        // RETRIEVING EXISTING DATA
        // must grab the Firebase object for that data + add listener + bind eventhandler -> fb no getValue() method
        // DataSnapshot + addChildEventListener -> notified/snapshot initially and on state changes
        // DataSnapshot: optimized for FireChat, not sending http get/post request -> emphasize their skills in cloud
        //
        fbName.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String username = dataSnapshot.getKey();
                String password = (String) dataSnapshot.getValue(); // casting Object to String
                log(username, password); // SELECT username, password FROM students where id = 123

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        })



    }
}
