package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        // Global variable shared by everyone else and used across different methods
        ArrayAdapter mArrayAdapter;

        public PlaceholderFragment() {
        }

        // This is where ListView populate the data
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Array is static in size, ArrayList dynamic in size
            // ArrayList cannot contain primative datatype, it can only contain object
            String[] data = {
                    "Mon 6/23 - Sunny - 31/17",
                    "Tue 6/24 - Foggy - 21/8",
                    "Wed 6/25 - Cloudy - 22/17",
                    "Thurs 6/26 - Rainy - 18/11",
                    "Fri 6/27 - Foggy - 21/10",
                    "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                    "Sun 6/29 - Sunny - 20/7"
            };

            List<String> weekforecast= new ArrayList<String>(Arrays.asList(data));

            // Adapter -> takes in by reference raw data e.g. List<String> and build list item layout
            // Bind adapter to ListView so ListView knows there are 3 list item layout
            // no need to create the list view yet until the list view request
            // Adapter is responsible for creating the View that are displayed within the bound AdapterView
            // AdapterView is responsible for how those views are laid out

            mArrayAdapter =new ArrayAdapter <String>(
                    getActivity(), // Context: current activity
                    R.layout.list_item_forecast, // how raw data is laid out
                    R.id.list_item_forecast_textview, // how layout is populated in the view i.e. adapter view
                    weekforecast
            );

            // Look up ListView in fragment_main.xml
            // fragment_main.xml is root view in view hierarchy
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mArrayAdapter);

            return rootView;
        }
    }
}
