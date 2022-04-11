package com.example.webtoonapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WeeklyAdapter extends FragmentStateAdapter {

    private final int NUM_PAGES = 8;

    public WeeklyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        // 선택 된 탭에따른 값을 프래그먼트에 전달하여 알맞은 웹툰 정보 불러오기
        switch (position) {
            case 0 : {
                return WeeklyRecycleFragment.newInstance("Mon");
            }
            case 1 : {
                return WeeklyRecycleFragment.newInstance("Thu");
            }
            case 2 : {
                return WeeklyRecycleFragment.newInstance("Wed");
            }
            case 3 : {
                return WeeklyRecycleFragment.newInstance("Thur");
            }
            case 4 : {
                return WeeklyRecycleFragment.newInstance("Fri");
            }
            case 5 : {
                return WeeklyRecycleFragment.newInstance("Sat");
            }
            case 6 : {
                return WeeklyRecycleFragment.newInstance("Sun");
            }
            case 7 : {
                return WeeklyRecycleFragment.newInstance("Remake");
            }
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
