package com.example.webtoonapp

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webtoonapp.R
import com.example.webtoonapp.WeeklyAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import java.util.*

class WeeklyFragment : Fragment() {
    var viewPager2_weekly: ViewPager2? = null
    var tabLayout: TabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2_weekly = view.findViewById(R.id.vp2_weekly)
        tabLayout = view.findViewById(R.id.tl_weekly)
        viewPager2_weekly?.setAdapter(WeeklyAdapter(this.requireActivity()))

        // 인기순위 탭 레이아웃과 목록 표시할 ViewPager2 연결
        TabLayoutMediator (
            tabLayout!!, viewPager2_weekly!! ) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "월"
                    }
                    1 -> {
                        tab.text = "화"
                    }
                    2 -> {
                        tab.text = "수"
                    }
                    3 -> {
                        tab.text = "목"
                    }
                    4 -> {
                        tab.text = "금"
                    }
                    5 -> {
                        tab.text = "토"
                    }
                    6 -> {
                        tab.text = "일"
                    }
                    7 -> {
                        tab.text = "리메이크"
                    }
                }
            }.attach()
        dayOfWeek
    }//Date형식으로 Convert

    //현재시간 가져오기
    val dayOfWeek: Unit
        get() {
            val now = System.currentTimeMillis() //현재시간 가져오기
            val date = Date(now) //Date형식으로 Convert
            val cal = Calendar.getInstance()
            cal.time = date
            val dayWeek = cal[Calendar.DAY_OF_WEEK]
            var str_week = ""
            when (dayWeek) {
                1 -> {
                    str_week = "일"
                    tabLayout!!.getTabAt(6)!!.select()
                    viewPager2_weekly!!.setCurrentItem(6, true)
                }
                2 -> {
                    str_week = "월"
                    tabLayout!!.getTabAt(0)!!.select()
                    viewPager2_weekly!!.setCurrentItem(0, true)
                }
                3 -> {
                    str_week = "화"
                    tabLayout!!.getTabAt(1)!!.select()
                    viewPager2_weekly!!.setCurrentItem(1, true)
                }
                4 -> {
                    str_week = "수"
                    tabLayout!!.getTabAt(2)!!.select()
                    viewPager2_weekly!!.setCurrentItem(2, true)
                }
                5 -> {
                    str_week = "목"
                    tabLayout!!.getTabAt(3)!!.select()
                    viewPager2_weekly!!.setCurrentItem(3, true)
                }
                6 -> {
                    str_week = "금"
                    tabLayout!!.getTabAt(4)!!.select()
                    viewPager2_weekly!!.setCurrentItem(4, true)
                }
                7 -> {
                    str_week = "토"
                    tabLayout!!.getTabAt(5)!!.select()
                    viewPager2_weekly!!.setCurrentItem(5, true)
                }
            }
        }
}