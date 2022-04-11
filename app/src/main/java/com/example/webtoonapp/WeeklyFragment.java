package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeeklyFragment extends Fragment {

    ViewPager2 viewPager2_weekly;
    TabLayout tabLayout;

    public WeeklyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2_weekly = view.findViewById(R.id.vp2_weekly);
        tabLayout = view.findViewById(R.id.tl_weekly);

        viewPager2_weekly.setAdapter(new WeeklyAdapter(this.getActivity()));

        // 인기순위 탭 레이아웃과 목록 표시할 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager2_weekly, (tab, position) -> {

            switch (position) {
                case 0: {
                    tab.setText("월");
                    break;
                }
                case 1: {
                    tab.setText("화");
                    break;
                }
                case 2: {
                    tab.setText("수");
                    break;
                }
                case 3: {
                    tab.setText("목");
                    break;
                }
                case 4: {
                    tab.setText("금");
                    break;
                }
                case 5: {
                    tab.setText("토");
                    break;
                }
                case 6: {
                    tab.setText("일");
                    break;
                }
                case 7: {
                    tab.setText("리메이크");
                    break;
                }
            }

        }).attach();

    }
}