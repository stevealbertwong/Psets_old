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
public class HairstyleGridViewAdapter extends BaseAdapter {

    private Context context;
    private final String[] mobileValues;

    public HairstyleGridViewAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }





    // populates view
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;



        gridView = new View(context);

        // get layout from mobile.xml
        gridView = inflater.inflate(R.layout.single_hairstyle, null);

        // set value into textview
        TextView textViewName = (TextView) gridView
                .findViewById(R.id.haricut_style);
        textViewName.setText(mobileValues[position]);

        // set image based on selected text
        ImageView imageView = (ImageView) gridView
                .findViewById(R.id.image_circle);

        String mobile = mobileValues[position];




        if (mobile.equals("波波頭")) {
            imageView.setImageResource(R.drawable.hairstyle_ballball);
        } else if (mobile.equals("染頭")) {
            imageView.setImageResource(R.drawable.hairstyle_dye);
        } else if (mobile.equals("小童")) {
            imageView.setImageResource(R.drawable.image_kid);
        } else if (mobile.equals("返工")) {
            imageView.setImageResource(R.drawable.hairstyle_work);
        } else if (mobile.equals("出街頭")) {
            imageView.setImageResource(R.drawable.hairstyle_party);
        } else if (mobile.equals("curly")) {
            imageView.setImageResource(R.drawable.hairstyle_curly);
        } else if (mobile.equals("新娘頭")) {
            imageView.setImageResource(R.drawable.hairstyle_bride);
        } else if (mobile.equals("小童")) {
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
