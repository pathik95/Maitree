package example.com.maitreev2.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import example.com.maitreev2.ResponseList;
import example.com.maitreev2.TabFragment;

/**
 * Created by Hello on 17-12-2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {


    List<ResponseList.DatesEntity> datelist;
    public TabsPagerAdapter(FragmentManager fm,List<ResponseList.DatesEntity> datelist) {
        super(fm);
        this.datelist=datelist;
    }

    @Override
    public Fragment getItem(int position) {


        ResponseList.DatesEntity datesEntity=datelist.get(position);

        return new TabFragment(datesEntity);
    }

    @Override
    public int getCount() {
        return datelist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return datelist.get(position).getDate();
    }
}
