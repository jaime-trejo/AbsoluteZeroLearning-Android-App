package com.absolutezerowit.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class AppleResults2 extends Activity {

    Button cButton,eButton,exitSubjectButton;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_or_lose);

        getActionBar().hide();

        // set the background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(38, 174, 144));

        // receive/retrieve the data
        Intent intent = getIntent(); // get the intent that started your activity
        Bundle bundle = intent.getExtras();
        String result = bundle.getString("cResults");
        String winOrLoseResult = bundle.getString("winOrLose");
        cButton = (Button)findViewById(R.id.continueButton);
        eButton = (Button)findViewById(R.id.exitButton);
        Log.v("result",result);//test
        Log.v("winOrLoseResult", winOrLoseResult);

        image = (ImageView)findViewById(R.id.resultImage);

        //initialize the exit button
        exitSubjectButton = (Button)findViewById(R.id.exitButton);

        if(winOrLoseResult.equalsIgnoreCase("win"))
        {

            //image.setImageResource(R.drawable.happy4);
            image.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.teal, 115, 115));
            cButton.setText("New Problem");
            eButton.setText("Exit Subject");
            cButton.setOnClickListener((new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // switch activity
                    Intent intent = new Intent();
                    intent.setClass(AppleResults2.this, MathSubject.class);
                    startActivity(intent);

                }
            }));

            exitSubjectButton.setOnClickListener(( new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // switch activity
                    Intent returnSubjectIntent = new Intent();
                    returnSubjectIntent.setClass(AppleResults2.this, SubjectMenu.class);
                    startActivity(returnSubjectIntent);
                }
            }));

        }
        else{
            //image.setImageResource(R.drawable.red);
            image.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.sadkitty, 115, 115));
            cButton.setText("Try Again");
            eButton.setText("New Problem");
            cButton.setOnClickListener((new OnClickListener() {
                @Override
                public void onClick(View v) {

                    // switch activity
                    Intent intent = new Intent();
                    intent.setClass(AppleResults2.this, math_problem2.class);
                    startActivity(intent);

                }
            }));
            exitSubjectButton.setOnClickListener(( new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // switch activity
                    Intent returnSubjectIntent = new Intent();
                    returnSubjectIntent.setClass(AppleResults2.this, MathSubject.class);
                    startActivity(returnSubjectIntent);
                }
            }));

        }


        // modify the textviews
        TextView textView;
        textView = (TextView) findViewById(R.id.colorResults);
        textView.setText(result);

    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BitmapDrawable)image.getDrawable()).getBitmap().recycle();
        // The activity is about to be destroyed.
    }

}