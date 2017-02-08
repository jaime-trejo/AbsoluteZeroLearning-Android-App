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

public class PlanetResults extends Activity {
    Button conButton,returnToSubjectMenuButton;
    ImageView image;
    TextView textView;
    Bitmap im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_results);

        getActionBar().hide();

        // set the background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(38, 174, 144));


        // receive/retrieve the data
        Intent intent = getIntent(); // get the intent that started your activity
        Bundle bundle = intent.getExtras();
        String result = bundle.getString("planetResults");
        String winOrLoseResult = bundle.getString("lossOrWin");
        Log.v("result",result);//test
        Log.v("winOrLoseResult",winOrLoseResult);

        image = (ImageView)findViewById(R.id.planetImageResult);

        if(winOrLoseResult.equalsIgnoreCase("win"))
        {


            image.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.happy4, 150, 150));

        }
        else{

            image.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.sadkitty2, 150, 150));
        }


        // modify the textviews
        textView = (TextView) findViewById(R.id.planetResults);
        textView.setText(result);

        //initialize the continue button
        conButton = (Button)findViewById(R.id.continueBttn);

        //click listener for orange button
        conButton.setOnClickListener(( new OnClickListener() {
            @Override
            public void onClick(View v) {

                // switch activity
                Intent intent = new Intent();
                intent.setClass(PlanetResults.this, Planets.class);
                startActivity(intent);

            }
        }));

        //initialize the continue button
        returnToSubjectMenuButton = (Button)findViewById(R.id.exitBttn);

        //click listener for orange button
        returnToSubjectMenuButton.setOnClickListener(( new OnClickListener() {
            @Override
            public void onClick(View v) {
                // switch activity
                Intent returnSubjectIntent = new Intent();
                returnSubjectIntent.setClass(PlanetResults.this, SubjectMenu.class);
                startActivity(returnSubjectIntent);
            }
        }));

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
    public void onDestroy() {
        super.onDestroy();

        ((BitmapDrawable)image.getDrawable()).getBitmap().recycle();
    }


}
