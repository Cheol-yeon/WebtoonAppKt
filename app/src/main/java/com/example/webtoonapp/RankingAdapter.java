package com.example.webtoonapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RankingAdapter extends FragmentStateAdapter {

    private final int NUM_PAGES = 4;

    public RankingAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0 : {
                return RankingFragment.newInstance("Realtime");
            }
            case 1 : {
                return RankingFragment.newInstance("Update");
            }
            case 2 : {
                return RankingFragment.newInstance("New");
            }
            case 3 : {
                return RankingFragment.newInstance("Sale");
            }
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
