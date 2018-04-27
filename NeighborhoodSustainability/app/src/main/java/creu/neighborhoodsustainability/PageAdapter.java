package creu.neighborhoodsustainability;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by C on 3/27/2018.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int numTabs = 3;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SocialFragment social = new SocialFragment();
                return social;
            case 1:
                EconomyFragment economy = new EconomyFragment();
                return economy;
            case 2:
                EcologyFragment ecology = new EcologyFragment();
                return ecology;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
