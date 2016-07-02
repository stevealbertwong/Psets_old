package com.example.steveandrewwong.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // dictionary, list of words in JSON format
    private static final String [] WORDS ={
            "abate", "to lessen to subside",
            "abeyance", "suspended action",
            "abjure", "promise or swear ot give up"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // filter out the elements, odd is word, even is definition
    }
}
