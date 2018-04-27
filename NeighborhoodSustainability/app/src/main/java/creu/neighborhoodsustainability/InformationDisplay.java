package creu.neighborhoodsustainability;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class InformationDisplay extends AppCompatActivity {
/*
 * This is the swipe tab view that will be populated with the
 * information from the server containing the links,
 * scoring, etc.
 */
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private PagerAdapter mSectionsPagerAdapter;
    //private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    String currentCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_display);
        Intent intent = getIntent();
        int pageNum = intent.getIntExtra("PageNumber", 0);
        currentCity = intent.getStringExtra("CityName");
        if (currentCity == null)
            currentCity = "CityName";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(pageNum);
        Toast.makeText(this, "Swipe left/right to access more information", Toast.LENGTH_LONG).show();
    }


    public class PagerAdapter extends FragmentPagerAdapter {
        int numTabs = 4;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //return EconomyFragment.newInstance();
            switch (position) {
                case 0:
                    //EconomyFragment economy = new EconomyFragment();
                    return EconomyFragment.newInstance();
                case 1:
                    //SocialFragment social = new SocialFragment();
                    return SocialFragment.newInstance();
                case 2:
                    //EcologyFragment ecology = new EcologyFragment();
                    return EcologyFragment.newInstance();
                case 3:
                    //OntologyFragment ontology = new OntologyFragment();
                    return OntologyFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numTabs;
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent =  new Intent(InformationDisplay.this, BreakDown.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("CityName", currentCity);
        Log.d("Information class", currentCity);
        startActivity(intent);
    }
}
