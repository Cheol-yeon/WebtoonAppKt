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

import java.util.Calendar;
import java.util.Date;

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

        getDayOfWeek();

    }

    public void getDayOfWeek() {
        long now = System.currentTimeMillis(); //현재시간 가져오기
        Date date = new Date(now); //Date형식으로 Convert

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        String str_week = "";

        switch (dayWeek) {
            case 1:
                str_week = "일";
                tabLayout.getTabAt(6).select();
                viewPager2_weekly.setCurrentItem(6, true);
                break;
            case 2:
                str_week = "월";
                tabLayout.getTabAt(0).select();
                viewPager2_weekly.setCurrentItem(0, true);
                break;
            case 3:
                str_week = "화";
                tabLayout.getTabAt(1).select();
                viewPager2_weekly.setCurrentItem(1, true);
                break;
            case 4:
                str_week = "수";
                tabLayout.getTabAt(2).select();
                viewPager2_weekly.setCurrentItem(2, true);
                break;
            case 5:
                str_week = "목";
                tabLayout.getTabAt(3).select();
                viewPager2_weekly.setCurrentItem(3, true);
                break;
            case 6:
                str_week = "금";
                tabLayout.getTabAt(4).select();
                viewPager2_weekly.setCurrentItem(4, true);
                break;
            case 7:
                str_week = "토";
                tabLayout.getTabAt(5).select();
                viewPager2_weekly.setCurrentItem(5, true);
                break;

        }
    }
}