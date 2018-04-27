package creu.neighborhoodsustainability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BreakDown extends AppCompatActivity {
/*
 * This activity follows the main activity and houses
 * 3 buttons which will lead the user to the information
 * for each section (economical, ecological, social)
 */
    String currentCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_down);
        Intent intent = getIntent();
        currentCity = intent.getStringExtra("CityName");
        Button button = (Button) findViewById(R.id.economicButton);
        Button button1 = (Button) findViewById(R.id.socialButton);
        Button button2 = (Button) findViewById(R.id.ecologicButton);
        if (currentCity.equals("Mesa")|| currentCity.equals("Tempe")){
            button.setText("6");
            button1.setText("6");
            button2.setText("6");
        }
        else if (currentCity.equals("Phoenix")){
            button.setText("5");
            button1.setText("5");
            button2.setText("5");
        }
        else if (currentCity.equals("Scottsdale")){
            button.setText("7");
            button1.setText("7");
            button2.setText("7");
        }
        Log.d("Break down", currentCity);
    }

    public void onClickEcon(View view){
        Intent intent = new Intent(BreakDown.this, InformationDisplay.class);
        intent.putExtra("PageNumber", 0);
        intent.putExtra("CityName", currentCity);
        startActivity(intent);
    }

    public void onClickSocial(View view){
        Intent intent = new Intent(BreakDown.this, InformationDisplay.class);
        intent.putExtra("PageNumber", 1);
        intent.putExtra("CityName", currentCity);
        startActivity(intent);
    }

    public void onClickEnv(View view){
        Intent intent = new Intent(BreakDown.this, InformationDisplay.class);
        intent.putExtra("PageNumber", 2);
        intent.putExtra("CityName", currentCity);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent =  new Intent(BreakDown.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
