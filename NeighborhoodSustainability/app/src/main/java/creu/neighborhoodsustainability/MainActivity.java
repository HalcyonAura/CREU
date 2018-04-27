package creu.neighborhoodsustainability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
/*
 * This activity is the entry activity that only shows one button to the user
 * and will house the search bar for other locations on top.
 */

    private String currentCity = "CityName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Neighborhood Sustainability");
        List<String> cityNames = new ArrayList<String>();
        cityNames.add(0,"CityName");
        cityNames.add("Mesa");
        cityNames.add("Phoenix");
        cityNames.add("Scottsdale");
        cityNames.add("Tempe");
        Spinner sp1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> places = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityNames);

        places.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(places);
        final ArrayAdapter<String> PLACESF = places;
        final MainActivity thisAct = this;
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String city = PLACESF.getItem(position);
                    Button cityText = (Button) findViewById(R.id.mainButton);
                    Log.d("position", Integer.toString(position));
                    switch (position) {
                        case 0:
                            cityText.setText("10");
                            currentCity = city;
                            break;
                        case 1:
                            cityText.setText("6");
                            currentCity = city;
                            break;
                        case 2:
                            cityText.setText("5");
                            currentCity = city;
                            break;
                        case 3:
                            cityText.setText("7");
                            currentCity = city;
                            break;
                        case 4:
                            cityText.setText("6");
                            currentCity = city;
                            break;
                        default:
                            cityText.setText("10");
                            currentCity = "CityName";
                            break;
                    }
                    //Replace string of text on bottom and button text
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    //Input dropdown menu functionality here

    //For button
    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, BreakDown.class);
        intent.putExtra("CityName", currentCity);
        startActivity(intent);
    }

    //Fixing backstack
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
