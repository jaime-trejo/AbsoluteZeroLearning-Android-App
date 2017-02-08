package com.absolutezerowit.finalproject;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class math_problem2 extends Activity {

    private String result;
    private String winOrLose;
    private String buttonClicked;
    Bundle appleBundle = new Bundle();
    Intent appleIntent = new Intent();

    ImageView drag, drag2;
    Button submit;
    LinearLayout drop, drop2;
    TextView eat1,eat2, cat1_have, cat2_have;
    int total, failure = 0;
    int total2, failure2 = 0;
    int cat1;
    int cat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probem2);

        getActionBar().hide();

        drag = (ImageView)findViewById(R.id.one);
        drag2 = (ImageView)findViewById(R.id.two);
        drop = (LinearLayout)findViewById(R.id.toplinear);
        drop2 = (LinearLayout)findViewById(R.id.middlelinear);
        cat1_have = (TextView)findViewById(R.id.cat1_have);
        cat2_have = (TextView)findViewById(R.id.cat2_have);
        submit = (Button)findViewById(R.id.submit);

        //drag.setImageResource(R.drawable.apple);
        //drag2.setImageResource(R.drawable.apple);

        drag.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.apple, 100, 100));

        drag2.setImageBitmap(
                decodeSampledBitmapFromResource(getResources(), R.drawable.apple, 100, 100));

        cat1_have.setText("Cat1 have 10 apples.");
        cat2_have.setText("Cat2 have 7 apples.");

        drop.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch (action) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP: {
                        failure = failure + 1;
                        return (true);
                    }

                    case DragEvent.ACTION_DRAG_ENDED: {
                        total = total + 1;
                        int cat2_recieve = total - failure;
                        cat1 = 10 - cat2_recieve;
                        cat2 = 7 + cat2_recieve;
                        cat1_have.setText("Cat1 have " + cat1 + " apples.");
                        //Log.v("cat1", "cat1 has " +cat1+ " apples");
                        cat2_have.setText("Cat2 have " + cat2 + " apples.");
                        //Log.v("cat1", "cat1 has " + cat1 + " apples");
                        return (true);

                    }

                    default:
                        break;
                }
                return true;
            }
        });

        drop2.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action2 = event.getAction();
                switch (action2) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP: {
                        failure2 = failure2 + 1;
                        return (true);
                    }

                    case DragEvent.ACTION_DRAG_ENDED: {
                        //total2 = total2 + 1;
                        total2 = total2 +1;
                        int cat1_recieve = total2 - failure2;
                        cat1 = cat1 + cat1_recieve;
                        cat2 = cat2 - cat1_recieve;
                        cat1_have.setText("Cat1 have " + cat1 + " apples.");
                        //Log.v("cat1", "cat1 has " +cat1+ " apples");
                        cat2_have.setText("Cat2 have " + cat2 + " apples.");
                        //Log.v("cat1", "cat1 has " +cat1+ " apples");
                        return (true);

                    }

                    default:
                        break;
                }
                return true;
            }
        });

        submit.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v("myApp", "submit button is clicked");

                // buttonClicked = "2";
                //String cat1 = Integer.toString(left);

                if (cat1 == 12 && cat2 == 5) {
                    Log.v("WIN", "HOORAY! You got the answer correct!.");
                    //store string
                    result = "HOORAY! You got the answer correct!.";
                    winOrLose = "win";
                    // bundle the data to send
                    appleBundle.putString("cResults", result);
                    appleBundle.putString("winOrLose", winOrLose);
                    // Activity switch
                    appleIntent.setClass(math_problem2.this, AppleResults2.class);
                    appleIntent.putExtras(appleBundle);
                    finish();
                    startActivity(appleIntent);

                } else {
                    Log.v("LOSE", "Oops! That\'s not correct. Try again.");
                    //store string
                    result = "Oops! That\'s not correct. Try again.";
                    winOrLose = "lose";
                    // bundle the data to send
                    appleBundle.putString("cResults", result);
                    appleBundle.putString("winOrLose", winOrLose);
                    // Activity switch
                    appleIntent.setClass(math_problem2.this, AppleResults2.class);
                    appleIntent.putExtras(appleBundle);
                    finish();
                    startActivity(appleIntent);
                }

            }
        }));

        drag.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag);
                v.startDrag(data, shadow, null, 0);
                return false;
            }
        });

        drag2.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag2);
                v.startDrag(data, shadow, null, 0);
                return false;
            }
        });

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
        ((BitmapDrawable)drag.getDrawable()).getBitmap().recycle();
        ((BitmapDrawable)drag2.getDrawable()).getBitmap().recycle();
        // The activity is about to be destroyed.
    }

}

