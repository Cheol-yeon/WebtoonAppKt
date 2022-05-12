package com.example.webtoonapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.webtoonapp.WeeklyRecycleFragment

class WeeklyAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val NUM_PAGES = 8
    override fun createFragment(position: Int): Fragment {

        // 선택 된 탭에따른 값을 프래그먼트에 전달하여 알맞은 웹툰 정보 불러오기
        when (position) {
            0 -> {
                return WeeklyRecycleFragment.newInstance("Mon")
            }
            1 -> {
                return WeeklyRecycleFragment.newInstance("Thu")
            }
            2 -> {
                return WeeklyRecycleFragment.newInstance("Wed")
            }
            3 -> {
                return WeeklyRecycleFragment.newInstance("Thur")
            }
            4 -> {
                return WeeklyRecycleFragment.newInstance("Fri")
            }
            5 -> {
                return WeeklyRecycleFragment.newInstance("Sat")
            }
            6 -> {
                return WeeklyRecycleFragment.newInstance("Sun")
            }
            7 -> {
                return WeeklyRecycleFragment.newInstance("Remake")
            }
        }
        return WeeklyRecycleFragment.newInstance("Remake")
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }
}