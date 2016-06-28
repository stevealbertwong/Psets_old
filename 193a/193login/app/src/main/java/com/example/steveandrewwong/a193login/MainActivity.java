package com.example.steveandrewwong.a193login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
// import stanford.andriodlib.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this); // set android context to be this activity
    }

    public void loginClick(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.password);
        String password = passwordEditText.getText().toString();

        // look up this person's password in Firebase
        Firebase firebase = new Firebase("https://amber-inferno-3012.firebaseio.com/");
        Firebase fbName = firebase.child("simpsons").child("students").child("123").child("name"); // return a firebase
        fbName.setValue("d-dog");

        // DataSnapshot + addChildEventListener


    }
}
