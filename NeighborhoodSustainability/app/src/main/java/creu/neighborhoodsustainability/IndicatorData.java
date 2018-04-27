package creu.neighborhoodsustainability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndicatorData extends AppCompatActivity {

    private TextView indicatorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_data);
        indicatorText = (TextView) findViewById(R.id.indicatorData);
        indicatorText.setText("\nINDICATOR DATA INFORMATION\n" +
                "\nData (original value taken from the source)" +
                "\nData type (short description of data)" +
                "\n\t\t\tPER CAPITA, \n\t\t\tPERCENT POPULATION, \n\t\t\tTONS, \n\t\t\tPEOPLE, \n\t\t\tetc. " +
                "\n\t\t\tUsed to describe what the number means" +
                "\nSource (where the data came from): URL " +
                "\nRank (computed from Data): #");
    }

    @Override
    public void onBackPressed(){
        Intent intent =  new Intent(IndicatorData.this, InformationDisplay.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("PageNumber", 3);
        startActivity(intent);
    }
}
