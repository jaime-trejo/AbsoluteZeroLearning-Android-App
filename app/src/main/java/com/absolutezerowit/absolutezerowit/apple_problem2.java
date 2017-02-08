package com.absolutezerowit.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class apple_problem2 extends Activity {

    Button cont, goBack;
    Intent intent, returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_problem2);

        getActionBar().hide();

        // set the background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(38, 174, 144));

        cont = (Button)findViewById(R.id.continue_btn);
        goBack = (Button)findViewById(R.id.goBack_btn);


        //click listener for colorSubject button
        cont.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activity switch
                intent = new Intent();
                intent.setClass(apple_problem2.this, math_problem2.class);
                startActivity(intent);
            }
        }));

        //click listener for mathSubject button
        goBack.setOnClickListener(( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activity switch
                returnIntent = new Intent();
                returnIntent.setClass(apple_problem2.this, MathSubject.class);
                startActivity(returnIntent);
            }
        }));
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
        // The activity is about to be destroyed.
    }
}
