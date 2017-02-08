package com.absolutezerowit.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class StartScreen extends Activity {

    Button start;
    Intent intent;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        getActionBar().hide();

        //set the background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(38, 174, 144));

        image = (ImageView) view.findViewById(R.id.start_image);

        // set menu welcome image
        image.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.start_icon, 150, 150));

        start = (Button) findViewById(R.id.start);

        //click listener for colorSubject button
        start.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activity switch
                intent = new Intent();
                intent.setClass(StartScreen.this, SubjectMenu.class);
                startActivity(intent);
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
