package com.example.ekshoonaya;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return step_1.newInstance("", "");
            case 1:
                return step_2.newInstance("", "");
            case 2:
                return step_3.newInstance("", "");
        }



        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "First Level";
            case 1:
                return "Second Level";
            case 2:
                return "Finish";
        }


        return null;
    }






}
