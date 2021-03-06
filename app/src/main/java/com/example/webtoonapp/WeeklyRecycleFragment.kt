package com.example.webtoonapp

import androidx.recyclerview.widget.RecyclerView
import com.example.webtoonapp.WeeklyWebtoonData
import android.os.Bundle
import com.example.webtoonapp.WeeklyRecycleFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webtoonapp.R
import androidx.recyclerview.widget.GridLayoutManager
import com.example.webtoonapp.WeeklyRecyclerViewAdapter
import java.util.ArrayList

class WeeklyRecycleFragment : Fragment() {
    var weeklyRecycle: RecyclerView? = null
    var weeklyRecyclerLayoutManager: RecyclerView.LayoutManager? = null
    var weeklyRecyclerAdapter: RecyclerView.Adapter<*>? = null
    var weeklyWebtoonDatas: ArrayList<WeeklyWebtoonData>? = null
    var weeklyWebtoonData: WeeklyWebtoonData? = null

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly_recycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weeklyRecycle = view.findViewById(R.id.rv_weekly)
        weeklyRecycle?.setHasFixedSize(true)
        weeklyRecyclerLayoutManager = GridLayoutManager(requireActivity(), 3)
        weeklyRecycle?.setLayoutManager(weeklyRecyclerLayoutManager)
        setWeeklyData()
    }

    fun setWeeklyData() {
        weeklyWebtoonDatas = ArrayList()
        if (mParam1 === "Mon" || mParam1 === "Thur" || mParam1 === "Fri" || mParam1 === "Sat" || mParam1 === "Sun" || mParam1 === "Remake") {
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10608_1620036312.6485.jpg"
            weeklyWebtoonData!!.title = "???????????? ???????????? ??????"
            weeklyWebtoonData!!.subTitle = "???345???"
            weeklyWebtoonData!!.hit = "44???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10850_1646644683.0066.jpg"
            weeklyWebtoonData!!.title = "?????? ????????? ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???32???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10242_1552874447.8449.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "???595???"
            weeklyWebtoonData!!.hit = "13???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10858_1646894514.7846.jpg"
            weeklyWebtoonData!!.title = "??? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "???45??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10870_1648555205.3122.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???52???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10663_1625193390.61.jpg"
            weeklyWebtoonData!!.title = "????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???200???"
            weeklyWebtoonData!!.hit = "48???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10229_1551329307.5441.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "???396???"
            weeklyWebtoonData!!.hit = "12???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???30???"
            weeklyWebtoonData!!.hit = "3.0???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10333_1564369661.5709.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???508???"
            weeklyWebtoonData!!.hit = "4.8???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10822_1644826219.0029.jpg"
            weeklyWebtoonData!!.title = "??????, ?????? ???????????????!"
            weeklyWebtoonData!!.subTitle = "???168???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10683_1626345727.7418.jpg"
            weeklyWebtoonData!!.title = "???????????????"
            weeklyWebtoonData!!.subTitle = "???121???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg"
            weeklyWebtoonData!!.title = "?????????, ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???289??? ?????????"
            weeklyWebtoonData!!.hit = "49???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10377_1568707397.4925.jpg"
            weeklyWebtoonData!!.title = "????????? 11??????"
            weeklyWebtoonData!!.subTitle = "???118??? ?????????"
            weeklyWebtoonData!!.hit = "102???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10829_1645411161.9839.jpg"
            weeklyWebtoonData!!.title = "???????????????"
            weeklyWebtoonData!!.subTitle = "??????1 ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10825_1645175822.0559.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???91??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10826_1645410735.9514.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???208??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10803_1641785683.7242.jpg"
            weeklyWebtoonData!!.title = "??????????????? ??????"
            weeklyWebtoonData!!.subTitle = "???60??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10665_1625220322.2119.jpg"
            weeklyWebtoonData!!.title = "???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "??????2 ???50??? ?????????"
            weeklyWebtoonData!!.hit = "1.3???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10661_1625192924.9361.jpg"
            weeklyWebtoonData!!.title = "????????? ????????? ???????????????."
            weeklyWebtoonData!!.subTitle = "???51??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8859_1525393508.0471.jpg"
            weeklyWebtoonData!!.title = "??????, ??????"
            weeklyWebtoonData!!.subTitle = "???49??? ?????????"
            weeklyWebtoonData!!.hit = "182???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9463_1549011485.5343.jpg"
            weeklyWebtoonData!!.title = "?????? ??????, ??????!"
            weeklyWebtoonData!!.subTitle = "???301??? ?????????"
            weeklyWebtoonData!!.hit = "66???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10541_1599189957.4978.jpg"
            weeklyWebtoonData!!.title = "????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???38??? ?????????"
            weeklyWebtoonData!!.hit = "8.3???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10682_1626345662.0359.jpg"
            weeklyWebtoonData!!.title = "?????? ?????? ????????????"
            weeklyWebtoonData!!.subTitle = "??????1 ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10409_1582878801.6759.jpg"
            weeklyWebtoonData!!.title = "??? ??? ?????? ??????"
            weeklyWebtoonData!!.subTitle = "???57??? ?????????"
            weeklyWebtoonData!!.hit = "29???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8479_1525334192.3962.jpg"
            weeklyWebtoonData!!.title = "??????????????? ???"
            weeklyWebtoonData!!.subTitle = "???38??? ?????????"
            weeklyWebtoonData!!.hit = "15???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10681_1626345596.6749.jpg"
            weeklyWebtoonData!!.title = "?????? ?????? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "??????1 ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8896_1525324961.8075.jpg"
            weeklyWebtoonData!!.title = "????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???35??? ?????????"
            weeklyWebtoonData!!.hit = "18???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8995_1503372321.5861.jpg"
            weeklyWebtoonData!!.title = "?????? ???!"
            weeklyWebtoonData!!.subTitle = "???68??? ?????????"
            weeklyWebtoonData!!.hit = "5.0???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/7438_1526621901.7552.jpg"
            weeklyWebtoonData!!.title = "????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???26??? ?????????"
            weeklyWebtoonData!!.hit = "147???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10290_1557369462.428.jpg"
            weeklyWebtoonData!!.title = "seven"
            weeklyWebtoonData!!.subTitle = "??????1 ???189??? ?????????"
            weeklyWebtoonData!!.hit = "3.3???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/3800_1527053771.9733.jpg"
            weeklyWebtoonData!!.title = "??????:??? ??????"
            weeklyWebtoonData!!.subTitle = "???44??? ?????????"
            weeklyWebtoonData!!.hit = "42???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10063_1525333999.2016.jpg"
            weeklyWebtoonData!!.title = "7??? ??????"
            weeklyWebtoonData!!.subTitle = "???36???"
            weeklyWebtoonData!!.hit = "2.8???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8156_1525326427.485.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "???38??? ?????????"
            weeklyWebtoonData!!.hit = "16???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8972_1525393703.2779.jpg"
            weeklyWebtoonData!!.title = "??????"
            weeklyWebtoonData!!.subTitle = "???30??? ?????????"
            weeklyWebtoonData!!.hit = "15???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10352_1566290302.4593.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???166??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10234_1551329811.1858.jpg"
            weeklyWebtoonData!!.title = "????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???93??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
        } else if (mParam1 === "Thu") {
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10802_1641785551.1803.jpg"
            weeklyWebtoonData!!.title = "???????????? ?????? ??????"
            weeklyWebtoonData!!.subTitle = "???75???"
            weeklyWebtoonData!!.hit = "2.3???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10242_1552874447.8449.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "???595???"
            weeklyWebtoonData!!.hit = "13???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10876_1649209377.2602.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???104???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10806_1642490978.5488.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???28???"
            weeklyWebtoonData!!.hit = "2.0???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10663_1625193390.61.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???124???"
            weeklyWebtoonData!!.hit = "8.9???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10818_1644220372.3964.jpg"
            weeklyWebtoonData!!.title = "??????????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???48???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10871_1648641556.8514.jpg"
            weeklyWebtoonData!!.title = "??????: ????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???102???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???31???"
            weeklyWebtoonData!!.hit = "3.0???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10811_1644223649.7517.jpg"
            weeklyWebtoonData!!.title = "??? ????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???65???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg"
            weeklyWebtoonData!!.title = "?????????, ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???289??? ?????????"
            weeklyWebtoonData!!.hit = "49???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8322_1525394231.8298.jpg"
            weeklyWebtoonData!!.title = "????????????? ?????????????"
            weeklyWebtoonData!!.subTitle = "???473???"
            weeklyWebtoonData!!.hit = "126???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10384_1598851294.5814.jpg"
            weeklyWebtoonData!!.title = "SHE"
            weeklyWebtoonData!!.subTitle = "???74??? ?????????"
            weeklyWebtoonData!!.hit = "52???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10413_1573809389.4239.jpg"
            weeklyWebtoonData!!.title = "????????? ??????[?????????]"
            weeklyWebtoonData!!.subTitle = "???88???"
            weeklyWebtoonData!!.hit = "3.4???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10854_1646962017.5802.jpg"
            weeklyWebtoonData!!.title = "??????????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???4??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10590_1612338793.8826.jpg"
            weeklyWebtoonData!!.title = "????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???30??? ?????????"
            weeklyWebtoonData!!.hit = "15???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10450_1582881801.9822.jpg"
            weeklyWebtoonData!!.title = "??????:???"
            weeklyWebtoonData!!.subTitle = "???63??? ?????????"
            weeklyWebtoonData!!.hit = "21???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8989_1503629038.2688.jpg"
            weeklyWebtoonData!!.title = "??????????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???84??? ?????????"
            weeklyWebtoonData!!.hit = "198???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10338_1569227969.7826.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???101??? ?????????"
            weeklyWebtoonData!!.hit = "5.7???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9166_1525326692.9585.jpg"
            weeklyWebtoonData!!.title = "?????? ?????? ????????? ????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???65??? ?????????"
            weeklyWebtoonData!!.hit = "39???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8158_1525334575.5413.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???39??? ?????????"
            weeklyWebtoonData!!.hit = "134???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8314_1525336437.0552.jpg"
            weeklyWebtoonData!!.title = "????????? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "??????1 ???103??? ?????????"
            weeklyWebtoonData!!.hit = "38???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/586_1525335381.3884.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???154??? ?????????"
            weeklyWebtoonData!!.hit = "114???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/5015_1525394342.7532.jpg"
            weeklyWebtoonData!!.title = "?????? ?????????"
            weeklyWebtoonData!!.subTitle = "???67??? ?????????"
            weeklyWebtoonData!!.hit = "111???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/5324_1526620643.7695.jpg"
            weeklyWebtoonData!!.title = "?????? ??????2"
            weeklyWebtoonData!!.subTitle = "???51??? ?????????"
            weeklyWebtoonData!!.hit = "61???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8990_1503372555.8095.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???28??? ?????????"
            weeklyWebtoonData!!.hit = "5.4???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10160_1542950894.2044.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???121??? ?????????"
            weeklyWebtoonData!!.hit = "4.5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10007_1525336024.201.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???24??? ?????????"
            weeklyWebtoonData!!.hit = "3.2???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8428_1525394293.884.jpg"
            weeklyWebtoonData!!.title = "????????? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "???36??? ?????????"
            weeklyWebtoonData!!.hit = "13???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10348_1566282030.2524.jpg"
            weeklyWebtoonData!!.title = "????????? : ??????????????? ??????"
            weeklyWebtoonData!!.subTitle = "???80??? ?????????"
            weeklyWebtoonData!!.hit = "1.7???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9246_1525326729.3162.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???30??? ?????????"
            weeklyWebtoonData!!.hit = "20???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10261_1554108262.0244.jpg"
            weeklyWebtoonData!!.title = "??????"
            weeklyWebtoonData!!.subTitle = "???48??? ?????????"
            weeklyWebtoonData!!.hit = "1.0???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
        } else if (mParam1 === "Wed") {
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10850_1646644683.0066.jpg"
            weeklyWebtoonData!!.title = "?????? ????????? ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???33???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10568_1604900784.8934.jpg"
            weeklyWebtoonData!!.title = "???????????? ???????????? ?????? ??????"
            weeklyWebtoonData!!.subTitle = "???414???"
            weeklyWebtoonData!!.hit = "96???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10872_1649397595.3984.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???251???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10887_1648806006.937.jpg"
            weeklyWebtoonData!!.title = "???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???34???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10873_1649743138.8721.jpg"
            weeklyWebtoonData!!.title = "???????????????"
            weeklyWebtoonData!!.subTitle = "???141???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10859_1646896306.4326.jpg"
            weeklyWebtoonData!!.title = "????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???80??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10828_1645411050.302.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???138???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10899_1649844820.5237.jpg"
            weeklyWebtoonData!!.title = "?????????, ??? ?????????, ????????????!"
            weeklyWebtoonData!!.subTitle = "???1???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10886_1648805268.204.jpg"
            weeklyWebtoonData!!.title = "???????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???16???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10532_1596439274.2237.jpg"
            weeklyWebtoonData!!.title = "????????? ???????????????"
            weeklyWebtoonData!!.subTitle = "???211???"
            weeklyWebtoonData!!.hit = "29???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10830_1645410926.2109.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???95???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10245_1552357810.9013.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???515???"
            weeklyWebtoonData!!.hit = "7.1???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10699_1628156242.5851.jpg"
            weeklyWebtoonData!!.title = "???????????? ??? ????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???114???"
            weeklyWebtoonData!!.hit = "3.8???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???32???"
            weeklyWebtoonData!!.hit = "3.1???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10330_1638840498.5224.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "??????2 ???22???"
            weeklyWebtoonData!!.hit = "3.6???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10700_1628156050.969.jpg"
            weeklyWebtoonData!!.title = "???????????? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "???114???"
            weeklyWebtoonData!!.hit = "5.4???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10634_1640604653.6457.jpg"
            weeklyWebtoonData!!.title = "?????? ?????? ??????"
            weeklyWebtoonData!!.subTitle = "???18??? ?????????"
            weeklyWebtoonData!!.hit = "1.7???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10449_1580197487.7602.jpg"
            weeklyWebtoonData!!.title = "????????? ??? ???????????????"
            weeklyWebtoonData!!.subTitle = "???238???"
            weeklyWebtoonData!!.hit = "84???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10795_1641173153.1999.jpg"
            weeklyWebtoonData!!.title = "???????????? ??????????????? ??????????????????"
            weeklyWebtoonData!!.subTitle = "???59???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10785_1638926112.7979.jpg"
            weeklyWebtoonData!!.title = "??? ????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???71???"
            weeklyWebtoonData!!.hit = "1.7???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10610_1620039770.1825.jpg"
            weeklyWebtoonData!!.title = "????????? ??????: ????????? ????????? ???"
            weeklyWebtoonData!!.subTitle = "???95??? (??????2)"
            weeklyWebtoonData!!.hit = "2.4???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg"
            weeklyWebtoonData!!.title = "?????????, ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???289??? ?????????"
            weeklyWebtoonData!!.hit = "49???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10790_1640252848.2317.jpg"
            weeklyWebtoonData!!.title = "???????????? ???????????? ??????"
            weeklyWebtoonData!!.subTitle = "???32??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10794_1641172764.1986.jpg"
            weeklyWebtoonData!!.title = "?????? ????????? ??????"
            weeklyWebtoonData!!.subTitle = "???59???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10784_1638925951.9581.jpg"
            weeklyWebtoonData!!.title = "???????????? ?????? ????????? ???????????????"
            weeklyWebtoonData!!.subTitle = "???71???"
            weeklyWebtoonData!!.hit = "2.2???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10815_1644219619.8302.jpg"
            weeklyWebtoonData!!.title = "????????? ??????"
            weeklyWebtoonData!!.subTitle = "???49???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9811_1525334172.5868.jpg"
            weeklyWebtoonData!!.title = "????????????"
            weeklyWebtoonData!!.subTitle = "???416??? ?????????"
            weeklyWebtoonData!!.hit = "23???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10812_1644222273.2999.jpg"
            weeklyWebtoonData!!.title = "?????? 2?????? 1"
            weeklyWebtoonData!!.subTitle = "???112???"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10855_1646962607.1397.jpg"
            weeklyWebtoonData!!.title = "????????? ???????????? ????????????"
            weeklyWebtoonData!!.subTitle = "???2??? ?????????"
            weeklyWebtoonData!!.hit = "5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10586_1614672726.6737.jpg"
            weeklyWebtoonData!!.title = "??????????????? ??????"
            weeklyWebtoonData!!.subTitle = "??????1 ?????????"
            weeklyWebtoonData!!.hit = "6.6???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9605_1549011676.0995.jpg"
            weeklyWebtoonData!!.title = "???????????? ??????"
            weeklyWebtoonData!!.subTitle = "???102??? ?????????"
            weeklyWebtoonData!!.hit = "80???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10415_1582094039.3946.jpg"
            weeklyWebtoonData!!.title = "H-mate"
            weeklyWebtoonData!!.subTitle = "???75??? ?????????"
            weeklyWebtoonData!!.hit = "47???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10125_1554963604.3303.gif"
            weeklyWebtoonData!!.title = "????????? ?????????"
            weeklyWebtoonData!!.subTitle = "???170??? ?????????"
            weeklyWebtoonData!!.hit = "81???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10395_1571044275.0403.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "??????2 ???36??? ?????????"
            weeklyWebtoonData!!.hit = "9.5???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10273_1556243522.5508.jpg"
            weeklyWebtoonData!!.title = "??? ????????? 16???"
            weeklyWebtoonData!!.subTitle = "???206??? ?????????"
            weeklyWebtoonData!!.hit = "18???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
            weeklyWebtoonData = WeeklyWebtoonData()
            weeklyWebtoonData!!.img =
                "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10301_1558422314.5707.jpg"
            weeklyWebtoonData!!.title = "?????????"
            weeklyWebtoonData!!.subTitle = "???53??? ?????????"
            weeklyWebtoonData!!.hit = "5.4???"
            weeklyWebtoonDatas!!.add(weeklyWebtoonData!!)
        }
        weeklyRecyclerAdapter = WeeklyRecyclerViewAdapter(weeklyWebtoonDatas, requireActivity())
        weeklyRecycle!!.adapter = weeklyRecyclerAdapter
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "day"
        fun newInstance(param1: String?): WeeklyRecycleFragment {
            val fragment = WeeklyRecycleFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}