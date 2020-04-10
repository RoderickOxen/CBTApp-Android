package com.cbt.cbtapp.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;


public class FragmentsAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> fragmentTitles;
    Context context;

    public FragmentsAdapter(@NonNull FragmentManager fm, Context ct, ArrayList<Fragment> _fragmentArrayList, ArrayList<String> _fragmentTitles) {
        super(fm);
        this.context = ct;
        this.fragmentArrayList = _fragmentArrayList;
        this.fragmentTitles = _fragmentTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

}
