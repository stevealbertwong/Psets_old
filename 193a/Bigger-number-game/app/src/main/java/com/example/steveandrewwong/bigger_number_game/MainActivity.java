package com.example.steveandrewwong.bigger_number_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(){

        Button button = (Button) findViewById();
        TextView point = (TextView) findViewById();

        // randomly generate button's text
        // convert the button's text into int and compare the 2 buttons
        // when the button is clicked -> compare e.g. if left is clicked and left int > right int + change the random number inside button's text
        // if true, get the int inside TextView point and increase by 1
    };
}
