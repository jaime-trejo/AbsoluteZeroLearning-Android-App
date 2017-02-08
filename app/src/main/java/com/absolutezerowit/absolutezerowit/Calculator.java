package com.absolutezerowit.finalproject;

import java.util.Random;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;


public class Calculator extends Activity implements OnClickListener {

    private int answer = 0, sign = 0, value1 = 0, value2 = 0;
    private final int ADD_SIGN = 0, SUB_SIGN = 1, MUL_SIGN = 2, DIV_SIGN = 3;
    private String[] signs = {"+", "-", "x", "/"};
    private TextView question, ansString, score, output;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, enterBtn, clearBtn, menu;
    private CountDownTimer timer, timer2;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        getActionBar().hide();

        timer = new MyCountDownTimer(2000,1000);
        timer2 = new MyCountDownTimer2(2000,1000);

        question =  (TextView)findViewById(R.id.question);
        ansString = (TextView)findViewById(R.id.answer);
        score =  (TextView)findViewById(R.id.score);
        output =  (TextView)findViewById(R.id.output);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        enterBtn = (Button)findViewById(R.id.enter);
        clearBtn = (Button)findViewById(R.id.clear);
        menu =  (Button)findViewById(R.id.main);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        menu.setOnClickListener(this);

        random = new Random();

        chooseQuestion();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.enter){
            String answerContent = ansString.getText().toString();
            if(!answerContent.endsWith("?"))
            {
                int enteredAnswer = Integer.parseInt(answerContent.substring(2));
                int exScore = getScore();
                if(enteredAnswer==answer){
                    score.setText("Score: "+(exScore+1));
                    timer.start();
                }
                else{
                    score.setText("Score: "+exScore);
                    timer2.start();
                }
            }
            chooseQuestion();

        }
        else if(v.getId()==R.id.clear){
            ansString.setText("= ?");
        }
        else if(v.getId()==R.id.main){

			Intent intent = new Intent();
			intent.setClass(Calculator.this, MathSubject.class);
			startActivity(intent);


        }
        else {
            int enteredNum = Integer.parseInt(v.getTag().toString());
            if(ansString.getText().toString().endsWith("?"))
                ansString.setText("= "+enteredNum);
            else
                ansString.append(""+enteredNum);

        }

    }

    private void hideAll(){
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        btn7.setVisibility(View.INVISIBLE);
        btn8.setVisibility(View.INVISIBLE);
        btn9.setVisibility(View.INVISIBLE);
        btn0.setVisibility(View.INVISIBLE);
        enterBtn.setVisibility(View.INVISIBLE);
        clearBtn.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        ansString.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
    }

    private void showAll(){
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        btn9.setVisibility(View.VISIBLE);
        btn0.setVisibility(View.VISIBLE);
        enterBtn.setVisibility(View.VISIBLE);
        clearBtn.setVisibility(View.VISIBLE);
        menu.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        ansString.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
    }

    private void chooseQuestion(){
        ansString.setText("= ?");
        sign = random.nextInt(signs.length);
        value1 = getVales();
        value2 = getVales();
        if(sign == SUB_SIGN){
            while(value2>value1){
                value1 = getVales();
                value2 = getVales();
            }
        }
        else if(sign==DIV_SIGN){
            while((((double)value1/(double)value2)%1 > 0 || value2 == 0 || value1==value2))
            {
                value1 = getVales();
                value2 = getVales();
            }
        }
        if(sign== ADD_SIGN)
            answer = value1+value2;
        else if(sign==SUB_SIGN)
            answer = value1-value2;
        else if(sign==MUL_SIGN)
            answer = value1*value2;
        else
            answer = value1/value2;
        question.setText(value1+" "+signs[sign]+" "+value2);

    }
    private int getVales(){
        return random.nextInt(10);
    }

    private int getScore(){
        String scoreStr = score.getText().toString();
        return Integer.parseInt(scoreStr.substring(scoreStr.lastIndexOf(" ")+1));
    }

    public class MyCountDownTimer extends CountDownTimer {
        View popupView = new View(Calculator.this);
        final PopupWindow popupWindow=new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Drawable drawable = new BitmapDrawable(decodeSampledBitmapFromResource(getResources(), R.drawable.happykitty, 145, 145));
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            showAll();
            popupWindow.dismiss();
            output.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            hideAll();
            output.setVisibility(View.VISIBLE);
            output.setText("AWESOME! You are right!!");
            popupWindow.setBackgroundDrawable(drawable);
            popupWindow.setHeight(300);
            popupWindow.setWidth(200);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return false;
                }

            });
            popupWindow.showAtLocation(findViewById(R.id.btn2), Gravity.CENTER, 0, 0);
        }
    }

    public class MyCountDownTimer2 extends CountDownTimer {
        View popupView2 = new View(Calculator.this);
        final PopupWindow popupWindow2=new PopupWindow(popupView2,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Drawable drawable2 = new BitmapDrawable(decodeSampledBitmapFromResource(getResources(), R.drawable.sadkitty, 145, 145));
        public MyCountDownTimer2(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            showAll();
            popupWindow2.dismiss();
            output.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            hideAll();
            output.setVisibility(View.VISIBLE);
            output.setText("Wrong. Let's try again!");
            popupWindow2.setBackgroundDrawable(drawable2);
            popupWindow2.setHeight(300);
            popupWindow2.setWidth(200);
            popupWindow2.setTouchable(true);
            popupWindow2.setFocusable(true);
            popupWindow2.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow2.dismiss();
                    return false;
                }

            });
            popupWindow2.showAtLocation(findViewById(R.id.btn1), Gravity.CENTER, 0, 0);
        }

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
}
