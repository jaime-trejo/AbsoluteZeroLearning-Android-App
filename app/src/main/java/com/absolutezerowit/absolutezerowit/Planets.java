package com.absolutezerowit.finalproject;

        import java.util.Random;

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
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemSelectedListener;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.Spinner;
        import android.widget.Toast;

public class Planets extends Activity implements OnItemSelectedListener{

    Spinner spinner;
    ImageView planetImage;
    Button btnSubmit,exitSubj;
    String planetSelection,randomPlanetName,planetResult,lossOrWin;
    private String[] planetNameArray = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
    Bundle planetChosenBundle = new Bundle();
    Intent planetIntent = new Intent();
    Bitmap pImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        getActionBar().hide();

        // set the background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(38, 174, 144));

        //instantiate
        btnSubmit = (Button)findViewById(R.id.submit);
        spinner = (Spinner) findViewById(R.id.planets_spinner);
        exitSubj = (Button)findViewById(R.id.exitBtt);
        //planetImage = (ImageView)findViewById(R.id.planetImage);

        //generate a random color string index
        Random randomNum = new Random();
        int sizeOfArray = planetNameArray.length -1;
        int randomPlanetIndex = randomNum.nextInt(sizeOfArray)+1;

        //set the random color string value onto the screen and center it
        randomPlanetName = planetNameArray[randomPlanetIndex];
        Log.v("Random Planet",randomPlanetName);


        planetImage = (ImageView) view.findViewById(R.id.planetImage);

        // display a planet image/ depends on the randomized image
        if(randomPlanetName.equalsIgnoreCase("Mercury"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.mercury, 100, 100));
        }
        else if (randomPlanetName.equalsIgnoreCase("Venus"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.venus, 100, 100));
        }
        else if (randomPlanetName.equals("Earth"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.earth, 100, 100));
        }
        else if (randomPlanetName.equalsIgnoreCase("Mars"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.mars, 100, 100));
        }
        else if(randomPlanetName.equalsIgnoreCase("Jupiter"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.jupiter, 100, 100));
        }
        else if(randomPlanetName.equalsIgnoreCase("Saturn"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.saturn, 100, 100));
        }
        else if(randomPlanetName.equalsIgnoreCase("Uranus"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.uranus, 100, 100));
        }
        else if(randomPlanetName.equalsIgnoreCase("Neptune"))
        {

            planetImage.setImageBitmap(
                    decodeSampledBitmapFromResource(getResources(), R.drawable.neptune, 100, 100));
        }



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        //On click listener for
        btnSubmit.setOnClickListener(( new OnClickListener() {
            @Override
            public void onClick(View v) {

                planetSelection = String.valueOf(spinner.getSelectedItem());
                Log.v("User selected", planetSelection); // test output

                if(randomPlanetName.equalsIgnoreCase(planetSelection))
                {
                    //Log.v("WIN", "HOORAY! You picked " + planetSelection + ".");
                    //store string
                    planetResult = "HOORAY! You picked " + planetSelection + ".";
                    lossOrWin = "win";
                    // bundle the data to send
                    planetChosenBundle.putString("planetResults", planetResult);
                    planetChosenBundle.putString("lossOrWin", lossOrWin);
                    // Activity switch
                    planetIntent.setClass(Planets.this,PlanetResults.class);
                    planetIntent.putExtras(planetChosenBundle);
                    startActivity(planetIntent);

                }
                else
                {
                    //Log.v("LOSE", "Oops! The correct name of the planet is " + randomPlanetName + ".\nTry again.");
                    //store string
                    planetResult = "Oops! The correct name of the planet is " + randomPlanetName + ".\nTry again.";
                    lossOrWin = "lose";
                    // bundle the data to send
                    planetChosenBundle.putString("planetResults", planetResult);
                    planetChosenBundle.putString("lossOrWin", lossOrWin);
                    // Activity switch
                    planetIntent.setClass(Planets.this,PlanetResults.class);
                    planetIntent.putExtras(planetChosenBundle);
                    startActivity(planetIntent);

                }
            }
        }));


        //click listener for exit subject button
        exitSubj.setOnClickListener(( new OnClickListener() {
            @Override
            public void onClick(View v) {
                // switch activity
                Intent returnIntent = new Intent();
                returnIntent.setClass(Planets.this, SubjectMenu.class);
                startActivity(returnIntent);
            }
        }));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // TODO Auto-generated method stub
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

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

        ((BitmapDrawable)planetImage.getDrawable()).getBitmap().recycle();
    }
}
