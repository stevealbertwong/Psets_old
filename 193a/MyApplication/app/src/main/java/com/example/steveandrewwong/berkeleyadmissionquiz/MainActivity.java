package com.example.steveandrewwong.berkeleyadmissionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // randomly generate button's text
    // convert the button's text into int and compare the 2 buttons
    // when the button is clicked -> compare e.g. if left is clicked and left int > right int + change the random number inside button's text
    // if true, get the int inside TextView point and increase by 1

    public void leftButtomClicked(View view) {
        Button leftButton = (Button) findViewById(R.id.button);
    }


    public void rightButtomClicked(View view) {
        Button rightButton = (Button) findViewById(R.id.button2);
    }
}
