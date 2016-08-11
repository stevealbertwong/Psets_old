package com.example.steveandrewwong.hairbobo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SteveAndrewWong on 8/11/16.
 */
public class PostGridViewAdapter extends BaseAdapter {

    private Context context;
    private final String[] mobileValues;

    public PostGridViewAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;



        gridView = new View(context);

        // get layout from mobile.xml
        gridView = inflater.inflate(R.layout.single_post, null);

        // set value into textview
        TextView textViewName = (TextView) gridView
                .findViewById(R.id.user_name_location);
        textViewName.setText(mobileValues[position]);

        // set image based on selected text
        ImageView imageView = (ImageView) gridView
                .findViewById(R.id.image_haircut);




        String mobile = mobileValues[position];

        if (mobile.equals("guy")) {
            imageView.setImageResource(R.drawable.image_guy);
        } else if (mobile.equals("dye")) {
            imageView.setImageResource(R.drawable.image_dye);
        } else if (mobile.equals("kid")) {
            imageView.setImageResource(R.drawable.image_kid);
        } else {
            imageView.setImageResource(R.drawable.image_dye);
        }




        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }
}
