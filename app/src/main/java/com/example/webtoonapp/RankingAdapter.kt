package com.example.webtoonapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.webtoonapp.RankingFragment

class RankingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val NUM_PAGES = 4
    override fun createFragment(position: Int): Fragment {

        // 선택 된 탭에따른 값을 프래그먼트에 전달하여 알맞은 웹툰 정보 불러오기
        when (position) {
            0 -> {
                return RankingFragment.newInstance("Realtime")
            }
            1 -> {
                return RankingFragment.newInstance("Update")
            }
            2 -> {
                return RankingFragment.newInstance("New")
            }
            3 -> {
                return RankingFragment.newInstance("Sale")
            }
        }
        return RankingFragment.newInstance("Sale")
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }
}