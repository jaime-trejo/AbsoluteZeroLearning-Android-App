package com.absolutezerowit.finalproject;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Colors extends Activity {

	private String[] colorNameArray = {"ORANGE","LIME","BROWN","PURPLE","BLACK","BLUE","GREEN","RED","YELLOW","WHITE","PINK","GRAY"};
	Button orange,lime,brown,purple,black,blue,green,red,yellow,white,pink,gray,exitSubject;
	private String buttonClicked;
	private String randomColorName;
	private String result;
	private String winOrLose;
	Bundle colorChosenBundle = new Bundle();
	Intent pickColorIntent = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colors);

		getActionBar().hide();

		// set the background color
		View view = this.getWindow().getDecorView();
		view.setBackgroundColor(Color.rgb(38, 174, 144));

		//generate a random color string index
		Random randomNum = new Random();
		int sizeOfArray = colorNameArray.length -1;
		int randomColorIndex = randomNum.nextInt(sizeOfArray)+1;

		//set the random color string value onto the screen and center it
		randomColorName = colorNameArray[randomColorIndex];
		TextView colorName = (TextView)findViewById(R.id.colorDisplayName);
		colorName.setText("What color is\n" + randomColorName + " ?");
		//colorName.setGravity(Gravity.CENTER);

		// creates the orange button
		orange = (Button)findViewById(R.id.orangeButton);
		orange.setBackgroundColor(Color.rgb(255, 165, 0));

		// creates the lime button
		lime = (Button)findViewById(R.id.limeButton);
		lime.setBackgroundColor(Color.GREEN);

		// creates the brown button
		brown = (Button)findViewById(R.id.brownButton);
		brown.setBackgroundColor(Color.rgb(139,69,19));

		// creates the purple button
		purple = (Button)findViewById(R.id.purpleButton);
		purple.setBackgroundColor(Color.rgb(148,0,211));

		// Creates the black button
		black = (Button)findViewById(R.id.blackButton);
		black.setBackgroundColor(Color.BLACK);

		// Creates the blue button
		blue = (Button)findViewById(R.id.blueButton);
		blue.setBackgroundColor(Color.BLUE);

		// Creates the green button
		green = (Button)findViewById(R.id.greenButton);
		green.setBackgroundColor(Color.rgb(34,139, 34));

		// Creates the red button
		red = (Button)findViewById(R.id.redButton);
		red.setBackgroundColor(Color.RED);

		// Creates the yellow button
		yellow = (Button)findViewById(R.id.yellowButton);
		yellow.setBackgroundColor(Color.YELLOW);

		// Creates the white button
		white = (Button)findViewById(R.id.whiteButton);
		white.setBackgroundColor(Color.WHITE);

		// Creates the magenta button
		pink = (Button)findViewById(R.id.magentaButton);
		pink.setBackgroundColor(Color.rgb(255,20, 147));

		// Creates the gray button
		gray = (Button)findViewById(R.id.grayButton);
		gray.setBackgroundColor(Color.GRAY);

		//click listener for orange button
		orange.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Orange button is clicked");
				buttonClicked = "orange";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for lime button
		lime.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Lime button is clicked");
				buttonClicked = "lime";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for brown button
		brown.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Brown button is clicked");
				buttonClicked = "brown";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for purple button
		purple.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Purple button is clicked");
				buttonClicked = "purple";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for black button
		black.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Black button is clicked");
				buttonClicked = "black";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for blue button
		blue.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Blue button is clicked");
				buttonClicked = "blue";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for green button
		green.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Green button is clicked");
				buttonClicked = "green";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));



		//click listener for red button
		red.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Red button is clicked");
				buttonClicked = "red";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}
			}
		}));

		//click listener for yellow button
		yellow.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Yellow button is clicked");
				buttonClicked = "yellow";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for white button
		white.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","White button is clicked");
				buttonClicked = "white";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for pink button
		pink.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Pink button is clicked");
				buttonClicked = "pink";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));

		//click listener for gray button
		gray.setOnClickListener(( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v("myApp","Gray button is clicked");
				buttonClicked = "gray";

				if(buttonClicked.equalsIgnoreCase(randomColorName))
				{
					//Log.v("WIN", "HOORAY! You picked " +buttonClicked + ".");
					//store string
					result = "HOORAY! You picked " +buttonClicked + ".";
					winOrLose = "win";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);

				}
				else
				{
					//Log.v("LOSE", "Oops! That\'s not " + randomColorName + ". Try again.");
					//store string
					result = "Oops! That\'s not " + randomColorName + ". Try again.";
					winOrLose = "lose";
					// bundle the data to send
					colorChosenBundle.putString("cResults", result);
					colorChosenBundle.putString("winOrLose", winOrLose);
					// Activity switch
					pickColorIntent.setClass(Colors.this,ColorResults.class);
					pickColorIntent.putExtras(colorChosenBundle);
					startActivity(pickColorIntent);
				}

			}
		}));


		//initialize the continue button
		exitSubject = (Button)findViewById(R.id.exitButton);

		//click listener for exit subject button
		exitSubject.setOnClickListener(( new OnClickListener() {
			@Override
			public void onClick(View v) {
				// switch activity
				Intent returnIntent = new Intent();
				returnIntent.setClass(Colors.this, SubjectMenu.class);
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

}