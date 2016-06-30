package com.example.steveandrewwong.berkeleyadmissionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    // onCreate runs when Activity gets created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // random number
        Random randomNumber = new Random();
        int num1 = randomNumber.nextInt(10);
        int num2 = randomNumber.nextInt(10);

        // view object -> button, textview, edittext + cast the return value to appropriate type
        Button leftButton = (Button) findViewById(R.id.button);
        Button rightButton = (Button) findViewById(R.id.button2);
//        leftButton.setText(num1);
//        rightButton.setText(num2);
    }

    // randomly generate button's text
    // convert the button's text into int and compare the 2 buttons
    // when the button is clicked -> compare e.g. if left is clicked and left int > right int + change the random number inside button's text
    // if true, get the int inside TextView point and increase by 1

//    public void leftButtomClicked(View view) {
//        Button leftButton = (Button) findViewById(R.id.button);
//        Button rightButton = (Button) findViewById(R.id.button2);
//        TextView points = (TextView) findViewById(R.id.textView2);

        // each widget has an associated java object i.e. get() set() methods that corresponds to the properties in Design View
//        int leftNumber = (int) leftButton.getText();
//        leftButton.get
//        int rightNumber = rightButton.getText();
//        if (leftNumber >= rightNumber){
//            points++;
//            toast("Correct");
//
//            leftButton.setText(); //
//        };
//    }


//    public void rightButtomClicked(View view) {
//        Button rightButton = (Button) findViewById(R.id.button2);
//    }
}
