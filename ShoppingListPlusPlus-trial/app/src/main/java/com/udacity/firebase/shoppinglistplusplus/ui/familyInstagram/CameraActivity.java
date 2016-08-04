package com.udacity.firebase.shoppinglistplusplus.ui.familyInstagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.firebase.client.Firebase;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.ui.BaseActivity;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by SteveAndrewWong on 7/29/16.
 */
public class CameraActivity extends BaseActivity {
    private ImageView imageView;
    private static final int REQUEST_CODE_TO_TAKEPICTURE = 1;
    private static final int REQUEST_CODE_TO_GETPICTURE = 2;
    private Bitmap bitmap;
    private Firebase mInstagramRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        mInstagramRef = new Firebase(Constants.FIREBASE_URL_INSTAGRAM);

        imageView = (ImageView) findViewById(R.id.image_view_1);

        previewStoredFirebaseImage();

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

    public void previewStoredFirebaseImage() {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // IGNORE THIS************
        // take picture activity is finished -> 1. get bitmap data 2. set imageView
        if (requestCode == REQUEST_CODE_TO_TAKEPICTURE) {

            // Image captured and saved to fileUri specified in the Intent
            // Toast.makeText(this, "Image saved to:\n" + data.getData(), Toast.LENGTH_LONG).show();
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView = (ImageView) findViewById(R.id.image_view_1);
            imageView.setImageBitmap(bitmap);
        }


        // START HERE*************
        if (requestCode == REQUEST_CODE_TO_GETPICTURE) {
            try {
                InputStream stream = null;
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                // TODO: save to Firebase + show progress bar + toast photo uploaded successfully



                // imageView.setImageBitmap(bitmap);

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

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



}

// show pictures + jump back to home + take pictures