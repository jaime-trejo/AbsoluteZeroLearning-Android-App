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

import com.absolutezerowit.finalproject.Colors;
import com.absolutezerowit.finalproject.MathSubject;

public class SubjectMenu extends Activity {

	//Button colorSubject,planetSubject;
	Intent subjectSelectedIntent = new Intent();
	ImageView welcomeImage,colorSubject,planetSubject,mathSubject;
	Bitmap menuImage;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subject_selection);

		getActionBar().hide();

		//set the background color
		View view = this.getWindow().getDecorView();
		view.setBackgroundColor(Color.rgb(38, 174, 144));

		welcomeImage = (ImageView) view.findViewById(R.id.welcomeImage);
		colorSubject = (ImageView)findViewById(R.id.colorSubjectPromptButton);
		planetSubject = (ImageView)findViewById(R.id.planetSubjectPromptButton);
		mathSubject = (ImageView)findViewById(R.id.mathSubjectPromptButton);

		// set menu welcome image
		welcomeImage.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.blackcat, 145, 145));
		//set color image
		colorSubject.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.colorsicon, 50, 50));

		//set the planet image
		planetSubject.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.planeticon, 50, 50));

		//set the math image
		mathSubject.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.mathicon, 50, 50));

		//initialize the  buttons
		//colorSubject = (Button)findViewById(R.id.colorSubjectPromptButton);
		//planetSubject = (Button)findViewById(R.id.planetSubjectPromptButton);

		//click listener for colorSubject image
		colorSubject.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(SubjectMenu.this,Colors.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		//click listener for colorSubject image
		mathSubject.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(SubjectMenu.this,MathSubject.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		//click listener for planetSubject image
		planetSubject.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(SubjectMenu.this,Planets.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		//click listener for mathSubject image
		//mathSubject.setOnClickListener(( new OnClickListener() {
		//		@Override
		//	public void onClick(View v) {
		// Activity switch
		//subjectSelectedIntent.setClass(SubjectMenu.this,Planets.class);
		//startActivity(subjectSelectedIntent);
		//		}
		//}));
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

		((BitmapDrawable)welcomeImage.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)planetSubject.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)mathSubject.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)colorSubject.getDrawable()).getBitmap().recycle();
	}
}
