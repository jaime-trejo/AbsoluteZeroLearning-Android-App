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

import com.absolutezerowit.finalproject.MathSubject;

public class MathSubject extends Activity {

	//Button colorSubject,planetSubject;
	Intent subjectSelectedIntent = new Intent();
	ImageView image,prob1,prob2,prob3;
	Button exitSubject;
	Bitmap menuImage;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.math);

		getActionBar().hide();

		//set the background color
		View view = this.getWindow().getDecorView();
		view.setBackgroundColor(Color.rgb(38, 174, 144));

		image = (ImageView) view.findViewById(R.id.image);
		prob1 = (ImageView)findViewById(R.id.problem1);
		prob2 = (ImageView)findViewById(R.id.problem2);
		prob3 = (ImageView)findViewById(R.id.problem3);

		// set menu welcome image
		image.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.sadkitty2, 145, 145));
		//set problem1 image
		prob1.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.problem1, 50, 50));

		//set the problem2 image
		prob2.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.problem2, 50, 50));

		//set the problem3 image
		prob3.setImageBitmap(
				decodeSampledBitmapFromResource(getResources(), R.drawable.problem3, 50, 50));

		//initialize the  buttons
		//colorSubject = (Button)findViewById(R.id.colorSubjectPromptButton);
		//planetSubject = (Button)findViewById(R.id.planetSubjectPromptButton);

		//click listener for problem1 image
		prob1.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(MathSubject.this,apple_problem.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		//click listener for problem2 image
		prob2.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(MathSubject.this,apple_problem2.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		//click listener for problem3 image
		prob3.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Activity switch
				subjectSelectedIntent.setClass(MathSubject.this,Calculator.class);
				startActivity(subjectSelectedIntent);
			}
		}));

		exitSubject = (Button)findViewById(R.id.exitButton);

		//click listener for exit subject button
		exitSubject.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// switch activity
				Intent returnIntent = new Intent();
				returnIntent.setClass(MathSubject.this, SubjectMenu.class);
				startActivity(returnIntent);
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

		((BitmapDrawable)image.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)prob1.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)prob2.getDrawable()).getBitmap().recycle();
		((BitmapDrawable)prob3.getDrawable()).getBitmap().recycle();
	}
}
