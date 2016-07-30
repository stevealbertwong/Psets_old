package com.example.steveandrewwong.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private static final int REQUEST_CODE_TO_TAKEPICTURE = 1;
    private static final int REQUEST_CODE_TO_GETPICTURE = 2;
    private Bitmap bitmap;
    private Uri fileUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = (Button) findViewById(R.id.button_take_picture);
        imageView = (ImageView) findViewById(R.id.image_view_1);

//        if (!hasCamera()) {
//            button.setEnabled(false);
//        }


    }


    public void takePictureClick(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(takePictureIntent, REQUEST_CODE_TO_TAKEPICTURE);



    }



    public void getPictureClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE_TO_GETPICTURE);


    }








    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        InputStream stream = null;
        // take picture activity is finished -> 1. get bitmap data 2. set imageView
        if (requestCode == REQUEST_CODE_TO_TAKEPICTURE) {

            // Image captured and saved to fileUri specified in the Intent
            Toast.makeText(this, "Image saved to:\n" +
                    data.getData(), Toast.LENGTH_LONG).show();



            // taken photo is encoded in the return Intent delivered to onActivityResult
            // taken photo is encoded as a small bitmap stored in Extra under the key "data"
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView = (ImageView) findViewById(R.id.image_view_1);
            imageView.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_TO_GETPICTURE) {
            try {
                InputStream stream = null;
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    }







//    // check if device has camera
//    public boolean hasCamera() {
//        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
//
//    }





    /*
     * 1. decided external public storage or internal file to write to
     * 2. create a collision-resistant file name using a date-time stamp + save path in member variable
     *
    * */


}

