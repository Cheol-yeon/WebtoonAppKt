package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class WeeklyRecycleFragment extends Fragment {

    RecyclerView weeklyRecycle;
    RecyclerView.LayoutManager weeklyRecyclerLayoutManager;
    RecyclerView.Adapter weeklyRecyclerAdapter;

    ArrayList<WeeklyWebtoonData> weeklyWebtoonDatas;
    WeeklyWebtoonData weeklyWebtoonData;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "day";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public WeeklyRecycleFragment() {
        // Required empty public constructor
    }

    public static WeeklyRecycleFragment newInstance(String param1) {
        WeeklyRecycleFragment fragment = new WeeklyRecycleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly_recycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weeklyRecycle = view.findViewById(R.id.rv_weekly);
        weeklyRecycle.setHasFixedSize(true);
        weeklyRecyclerLayoutManager = new GridLayoutManager(requireActivity(),3);
        weeklyRecycle.setLayoutManager(weeklyRecyclerLayoutManager);

        setWeeklyData();
    }

    public void setWeeklyData() {
        weeklyWebtoonDatas = new ArrayList<>();
        if(mParam1 == "Mon" || mParam1 == "Thur" || mParam1 == "Fri" || mParam1 == "Sat" || mParam1 == "Sun" || mParam1 == "Remake") {
            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10608_1620036312.6485.jpg");
            weeklyWebtoonData.setTitle("대표님의 삐뚤어진 사랑");
            weeklyWebtoonData.setSubTitle("제345화");
            weeklyWebtoonData.setHit("44만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10850_1646644683.0066.jpg");
            weeklyWebtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            weeklyWebtoonData.setSubTitle("제32화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10242_1552874447.8449.jpg");
            weeklyWebtoonData.setTitle("영검존");
            weeklyWebtoonData.setSubTitle("제595화");
            weeklyWebtoonData.setHit("13만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10858_1646894514.7846.jpg");
            weeklyWebtoonData.setTitle("그 남자의 계략");
            weeklyWebtoonData.setSubTitle("제45화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10870_1648555205.3122.jpg");
            weeklyWebtoonData.setTitle("만고지존");
            weeklyWebtoonData.setSubTitle("제52화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10663_1625193390.61.jpg");
            weeklyWebtoonData.setTitle("대표님 살살해요");
            weeklyWebtoonData.setSubTitle("제200화");
            weeklyWebtoonData.setHit("48만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10229_1551329307.5441.jpg");
            weeklyWebtoonData.setTitle("요신기");
            weeklyWebtoonData.setSubTitle("제396화");
            weeklyWebtoonData.setHit("12만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg");
            weeklyWebtoonData.setTitle("신혼좀비");
            weeklyWebtoonData.setSubTitle("제30화");
            weeklyWebtoonData.setHit("3.0만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10333_1564369661.5709.jpg");
            weeklyWebtoonData.setTitle("만계선종");
            weeklyWebtoonData.setSubTitle("제508화");
            weeklyWebtoonData.setHit("4.8만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10822_1644826219.0029.jpg");
            weeklyWebtoonData.setTitle("폐하, 옥체 보존하세요!");
            weeklyWebtoonData.setSubTitle("제168화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10683_1626345727.7418.jpg");
            weeklyWebtoonData.setTitle("워너비스타");
            weeklyWebtoonData.setSubTitle("제121화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg");
            weeklyWebtoonData.setTitle("대표님, 사모님이 도망가요");
            weeklyWebtoonData.setSubTitle("제289화 최종화");
            weeklyWebtoonData.setHit("49만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10377_1568707397.4925.jpg");
            weeklyWebtoonData.setTitle("그녀의 11센티");
            weeklyWebtoonData.setSubTitle("제118화 최종화");
            weeklyWebtoonData.setHit("102만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10829_1645411161.9839.jpg");
            weeklyWebtoonData.setTitle("제존회귀록");
            weeklyWebtoonData.setSubTitle("시즌1 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10825_1645175822.0559.jpg");
            weeklyWebtoonData.setTitle("난세신벌");
            weeklyWebtoonData.setSubTitle("제91화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10826_1645410735.9514.jpg");
            weeklyWebtoonData.setTitle("만계신주");
            weeklyWebtoonData.setSubTitle("제208화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10803_1641785683.7242.jpg");
            weeklyWebtoonData.setTitle("어이상실의 시대");
            weeklyWebtoonData.setSubTitle("제60화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10665_1625220322.2119.jpg");
            weeklyWebtoonData.setTitle("황비님의 비밀수업");
            weeklyWebtoonData.setSubTitle("시즌2 제50화 최종화");
            weeklyWebtoonData.setHit("1.3만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10661_1625192924.9361.jpg");
            weeklyWebtoonData.setTitle("고양이 카페로 초대합니다.");
            weeklyWebtoonData.setSubTitle("제51화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8859_1525393508.0471.jpg");
            weeklyWebtoonData.setTitle("그녀, 윤희");
            weeklyWebtoonData.setSubTitle("제49화 최종화");
            weeklyWebtoonData.setHit("182만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9463_1549011485.5343.jpg");
            weeklyWebtoonData.setTitle("보스 오빠, 제발!");
            weeklyWebtoonData.setSubTitle("제301화 최종화");
            weeklyWebtoonData.setHit("66만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10541_1599189957.4978.jpg");
            weeklyWebtoonData.setTitle("아내가 돌아왔다");
            weeklyWebtoonData.setSubTitle("제38화 최종화");
            weeklyWebtoonData.setHit("8.3만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10682_1626345662.0359.jpg");
            weeklyWebtoonData.setTitle("오늘 그가 돌아왔다");
            weeklyWebtoonData.setSubTitle("시즌1 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10409_1582878801.6759.jpg");
            weeklyWebtoonData.setTitle("알 수 없는 마음");
            weeklyWebtoonData.setSubTitle("제57화 최종화");
            weeklyWebtoonData.setHit("29만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8479_1525334192.3962.jpg");
            weeklyWebtoonData.setTitle("패러사이트 퀸");
            weeklyWebtoonData.setSubTitle("제38화 최종화");
            weeklyWebtoonData.setHit("15만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10681_1626345596.6749.jpg");
            weeklyWebtoonData.setTitle("예쁜 남자 잘생긴 여자");
            weeklyWebtoonData.setSubTitle("시즌1 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8896_1525324961.8075.jpg");
            weeklyWebtoonData.setTitle("그래도 사랑해");
            weeklyWebtoonData.setSubTitle("제35화 최종화");
            weeklyWebtoonData.setHit("18만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8995_1503372321.5861.jpg");
            weeklyWebtoonData.setTitle("아임 펫!");
            weeklyWebtoonData.setSubTitle("제68화 최종화");
            weeklyWebtoonData.setHit("5.0만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/7438_1526621901.7552.jpg");
            weeklyWebtoonData.setTitle("힙찔이 빙진호");
            weeklyWebtoonData.setSubTitle("제26화 최종화");
            weeklyWebtoonData.setHit("147만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10290_1557369462.428.jpg");
            weeklyWebtoonData.setTitle("seven");
            weeklyWebtoonData.setSubTitle("시즌1 제189화 최종화");
            weeklyWebtoonData.setHit("3.3만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/3800_1527053771.9733.jpg");
            weeklyWebtoonData.setTitle("산군:활 제로");
            weeklyWebtoonData.setSubTitle("제44화 최종화");
            weeklyWebtoonData.setHit("42만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10063_1525333999.2016.jpg");
            weeklyWebtoonData.setTitle("7의 잔재");
            weeklyWebtoonData.setSubTitle("제36화");
            weeklyWebtoonData.setHit("2.8만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8156_1525326427.485.jpg");
            weeklyWebtoonData.setTitle("경계인");
            weeklyWebtoonData.setSubTitle("제38화 최종화");
            weeklyWebtoonData.setHit("16만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8972_1525393703.2779.jpg");
            weeklyWebtoonData.setTitle("블랙");
            weeklyWebtoonData.setSubTitle("제30화 최종화");
            weeklyWebtoonData.setHit("15만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10352_1566290302.4593.jpg");
            weeklyWebtoonData.setTitle("현호전기");
            weeklyWebtoonData.setSubTitle("제166화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10234_1551329811.1858.jpg");
            weeklyWebtoonData.setTitle("굴다리 블루스");
            weeklyWebtoonData.setSubTitle("제93화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

        } else if (mParam1 == "Thu") {
            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10802_1641785551.1803.jpg");
            weeklyWebtoonData.setTitle("레벨업에 미친 의사");
            weeklyWebtoonData.setSubTitle("제75화");
            weeklyWebtoonData.setHit("2.3만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10242_1552874447.8449.jpg");
            weeklyWebtoonData.setTitle("영검존");
            weeklyWebtoonData.setSubTitle("제595화");
            weeklyWebtoonData.setHit("13만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10876_1649209377.2602.jpg");
            weeklyWebtoonData.setTitle("소오강호");
            weeklyWebtoonData.setSubTitle("제104화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10806_1642490978.5488.jpg");
            weeklyWebtoonData.setTitle("천일의 아내");
            weeklyWebtoonData.setSubTitle("제28화");
            weeklyWebtoonData.setHit("2.0만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10663_1625193390.61.jpg");
            weeklyWebtoonData.setTitle("만지고 싶어");
            weeklyWebtoonData.setSubTitle("제124화");
            weeklyWebtoonData.setHit("8.9만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10818_1644220372.3964.jpg");
            weeklyWebtoonData.setTitle("백스테이지 키스신");
            weeklyWebtoonData.setSubTitle("제48화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10871_1648641556.8514.jpg");
            weeklyWebtoonData.setTitle("무역: 운명을 거스르다");
            weeklyWebtoonData.setSubTitle("제102화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg");
            weeklyWebtoonData.setTitle("신혼좀비");
            weeklyWebtoonData.setSubTitle("제31화");
            weeklyWebtoonData.setHit("3.0만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10811_1644223649.7517.jpg");
            weeklyWebtoonData.setTitle("내 남편의 스토커");
            weeklyWebtoonData.setSubTitle("제65화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg");
            weeklyWebtoonData.setTitle("대표님, 사모님이 도망가요");
            weeklyWebtoonData.setSubTitle("제289화 최종화");
            weeklyWebtoonData.setHit("49만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8322_1525394231.8298.jpg");
            weeklyWebtoonData.setTitle("복수할까? 연애할까?");
            weeklyWebtoonData.setSubTitle("제473화");
            weeklyWebtoonData.setHit("126만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10384_1598851294.5814.jpg");
            weeklyWebtoonData.setTitle("SHE");
            weeklyWebtoonData.setSubTitle("제74화 최종화");
            weeklyWebtoonData.setHit("52만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10413_1573809389.4239.jpg");
            weeklyWebtoonData.setTitle("심판의 군주[전연령]");
            weeklyWebtoonData.setSubTitle("제88화");
            weeklyWebtoonData.setHit("3.4만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10854_1646962017.5802.jpg");
            weeklyWebtoonData.setTitle("무협소녀와 강아지");
            weeklyWebtoonData.setSubTitle("제4화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10590_1612338793.8826.jpg");
            weeklyWebtoonData.setTitle("당구장 사랑이");
            weeklyWebtoonData.setSubTitle("제30화 최종화");
            weeklyWebtoonData.setHit("15만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10450_1582881801.9822.jpg");
            weeklyWebtoonData.setTitle("누나:연");
            weeklyWebtoonData.setSubTitle("제63화 최종화");
            weeklyWebtoonData.setHit("21만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8989_1503629038.2688.jpg");
            weeklyWebtoonData.setTitle("시어머니는 츤데레");
            weeklyWebtoonData.setSubTitle("제84화 최종화");
            weeklyWebtoonData.setHit("198만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10338_1569227969.7826.jpg");
            weeklyWebtoonData.setTitle("허니트랩");
            weeklyWebtoonData.setSubTitle("제101화 최종화");
            weeklyWebtoonData.setHit("5.7만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9166_1525326692.9585.jpg");
            weeklyWebtoonData.setTitle("매일 가장 잘생긴 남자는 죽는다");
            weeklyWebtoonData.setSubTitle("제65화 최종화");
            weeklyWebtoonData.setHit("39만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8158_1525334575.5413.jpg");
            weeklyWebtoonData.setTitle("흥부와 놀부");
            weeklyWebtoonData.setSubTitle("제39화 최종화");
            weeklyWebtoonData.setHit("134만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8314_1525336437.0552.jpg");
            weeklyWebtoonData.setTitle("모래와 바다의 노래");
            weeklyWebtoonData.setSubTitle("시즌1 제103화 최종화");
            weeklyWebtoonData.setHit("38만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/586_1525335381.3884.jpg");
            weeklyWebtoonData.setTitle("캠핑은 빡세");
            weeklyWebtoonData.setSubTitle("제154화 최종화");
            weeklyWebtoonData.setHit("114만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/5015_1525394342.7532.jpg");
            weeklyWebtoonData.setTitle("독고 플라워");
            weeklyWebtoonData.setSubTitle("제67화 최종화");
            weeklyWebtoonData.setHit("111만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/5324_1526620643.7695.jpg");
            weeklyWebtoonData.setTitle("군사 시즌2");
            weeklyWebtoonData.setSubTitle("제51화 최종화");
            weeklyWebtoonData.setHit("61만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8990_1503372555.8095.jpg");
            weeklyWebtoonData.setTitle("위험한 동거");
            weeklyWebtoonData.setSubTitle("제28화 최종화");
            weeklyWebtoonData.setHit("5.4만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10160_1542950894.2044.jpg");
            weeklyWebtoonData.setTitle("클러스터");
            weeklyWebtoonData.setSubTitle("제121화 최종화");
            weeklyWebtoonData.setHit("4.5만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10007_1525336024.201.jpg");
            weeklyWebtoonData.setTitle("도시괴담");
            weeklyWebtoonData.setSubTitle("제24화 최종화");
            weeklyWebtoonData.setHit("3.2만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/8428_1525394293.884.jpg");
            weeklyWebtoonData.setTitle("햄스터 키우는 만화");
            weeklyWebtoonData.setSubTitle("제36화 최종화");
            weeklyWebtoonData.setHit("13만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10348_1566282030.2524.jpg");
            weeklyWebtoonData.setTitle("결일문 : 목각사단의 비밀");
            weeklyWebtoonData.setSubTitle("제80화 최종화");
            weeklyWebtoonData.setHit("1.7만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9246_1525326729.3162.jpg");
            weeklyWebtoonData.setTitle("기억해줘");
            weeklyWebtoonData.setSubTitle("제30화 최종화");
            weeklyWebtoonData.setHit("20만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10261_1554108262.0244.jpg");
            weeklyWebtoonData.setTitle("귀연");
            weeklyWebtoonData.setSubTitle("제48화 최종화");
            weeklyWebtoonData.setHit("1.0만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

        } else if (mParam1 == "Wed") {
            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10850_1646644683.0066.jpg");
            weeklyWebtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            weeklyWebtoonData.setSubTitle("제33화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10568_1604900784.8934.jpg");
            weeklyWebtoonData.setTitle("속도위반 대표님과 계약 아내");
            weeklyWebtoonData.setSubTitle("제414화");
            weeklyWebtoonData.setHit("96만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10872_1649397595.3984.jpg");
            weeklyWebtoonData.setTitle("마황의 귀환");
            weeklyWebtoonData.setSubTitle("제251화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10887_1648806006.937.jpg");
            weeklyWebtoonData.setTitle("가출천사 육성계약");
            weeklyWebtoonData.setSubTitle("제34화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10873_1649743138.8721.jpg");
            weeklyWebtoonData.setTitle("의천도룡기");
            weeklyWebtoonData.setSubTitle("제141화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10859_1646896306.4326.jpg");
            weeklyWebtoonData.setTitle("불순한 동거동락");
            weeklyWebtoonData.setSubTitle("제80화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10828_1645411050.302.jpg");
            weeklyWebtoonData.setTitle("신무천존");
            weeklyWebtoonData.setSubTitle("제138화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10899_1649844820.5237.jpg");
            weeklyWebtoonData.setTitle("보지마, 안 괜찮아, 불법이야!");
            weeklyWebtoonData.setSubTitle("제1화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10886_1648805268.204.jpg");
            weeklyWebtoonData.setTitle("커피여우 김삼월");
            weeklyWebtoonData.setSubTitle("제16화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10532_1596439274.2237.jpg");
            weeklyWebtoonData.setTitle("대표님 책임지세요");
            weeklyWebtoonData.setSubTitle("제211화");
            weeklyWebtoonData.setHit("29만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10830_1645410926.2109.jpg");
            weeklyWebtoonData.setTitle("무적검역");
            weeklyWebtoonData.setSubTitle("제95화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10245_1552357810.9013.jpg");
            weeklyWebtoonData.setTitle("성무신결");
            weeklyWebtoonData.setSubTitle("제515화");
            weeklyWebtoonData.setHit("7.1만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10699_1628156242.5851.jpg");
            weeklyWebtoonData.setTitle("대표님은 나 아니면 안돼요");
            weeklyWebtoonData.setSubTitle("제114화");
            weeklyWebtoonData.setHit("3.8만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10847_1646971047.4652.jpg");
            weeklyWebtoonData.setTitle("신혼좀비");
            weeklyWebtoonData.setSubTitle("제32화");
            weeklyWebtoonData.setHit("3.1만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10330_1638840498.5224.jpg");
            weeklyWebtoonData.setTitle("만고검신");
            weeklyWebtoonData.setSubTitle("시즌2 제22화");
            weeklyWebtoonData.setHit("3.6만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10700_1628156050.969.jpg");
            weeklyWebtoonData.setTitle("대표님의 독점적 사랑");
            weeklyWebtoonData.setSubTitle("제114화");
            weeklyWebtoonData.setHit("5.4만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10634_1640604653.6457.jpg");
            weeklyWebtoonData.setTitle("잘못 전한 편지");
            weeklyWebtoonData.setSubTitle("제18화 최종화");
            weeklyWebtoonData.setHit("1.7만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10449_1580197487.7602.jpg");
            weeklyWebtoonData.setTitle("대표님 꼭 안아주세요");
            weeklyWebtoonData.setSubTitle("제238화");
            weeklyWebtoonData.setHit("84만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10795_1641173153.1999.jpg");
            weeklyWebtoonData.setTitle("주인님의 예비신부로 환생했습니다");
            weeklyWebtoonData.setSubTitle("제59화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10785_1638926112.7979.jpg");
            weeklyWebtoonData.setTitle("내 남편은 뱀파이어");
            weeklyWebtoonData.setSubTitle("제71화");
            weeklyWebtoonData.setHit("1.7만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10610_1620039770.1825.jpg");
            weeklyWebtoonData.setTitle("사랑의 형태: 마음이 향하는 곳");
            weeklyWebtoonData.setSubTitle("제95화 (시즌2)");
            weeklyWebtoonData.setHit("2.4만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10609_1619599386.8101.jpg");
            weeklyWebtoonData.setTitle("대표님, 사모님이 도망가요");
            weeklyWebtoonData.setSubTitle("제289화 최종화");
            weeklyWebtoonData.setHit("49만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10790_1640252848.2317.jpg");
            weeklyWebtoonData.setTitle("독충마왕 벌레들의 전쟁");
            weeklyWebtoonData.setSubTitle("제32화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10794_1641172764.1986.jpg");
            weeklyWebtoonData.setTitle("원래 악녀가 체질");
            weeklyWebtoonData.setSubTitle("제59화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10784_1638925951.9581.jpg");
            weeklyWebtoonData.setTitle("대표님의 전속 노예가 되었습니다");
            weeklyWebtoonData.setSubTitle("제71화");
            weeklyWebtoonData.setHit("2.2만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10815_1644219619.8302.jpg");
            weeklyWebtoonData.setTitle("폭군의 눈물");
            weeklyWebtoonData.setSubTitle("제49화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9811_1525334172.5868.jpg");
            weeklyWebtoonData.setTitle("일인지하");
            weeklyWebtoonData.setSubTitle("제416화 최종화");
            weeklyWebtoonData.setHit("23만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10812_1644222273.2999.jpg");
            weeklyWebtoonData.setTitle("연애 2분의 1");
            weeklyWebtoonData.setSubTitle("제112화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10855_1646962607.1397.jpg");
            weeklyWebtoonData.setTitle("모쉬의 슬기로운 먹는생활");
            weeklyWebtoonData.setSubTitle("제2화 최종화");
            weeklyWebtoonData.setHit("5천");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10586_1614672726.6737.jpg");
            weeklyWebtoonData.setTitle("신데렐라의 역습");
            weeklyWebtoonData.setSubTitle("시즌1 최종화");
            weeklyWebtoonData.setHit("6.6만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/9605_1549011676.0995.jpg");
            weeklyWebtoonData.setTitle("상큼하지 않아");
            weeklyWebtoonData.setSubTitle("제102화 최종화");
            weeklyWebtoonData.setHit("80만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10415_1582094039.3946.jpg");
            weeklyWebtoonData.setTitle("H-mate");
            weeklyWebtoonData.setSubTitle("제75화 최종화");
            weeklyWebtoonData.setHit("47만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10125_1554963604.3303.gif");
            weeklyWebtoonData.setTitle("대표님 안돼요");
            weeklyWebtoonData.setSubTitle("제170화 최종화");
            weeklyWebtoonData.setHit("81만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10395_1571044275.0403.jpg");
            weeklyWebtoonData.setTitle("에이스");
            weeklyWebtoonData.setSubTitle("시즌2 제36화 최종화");
            weeklyWebtoonData.setHit("9.5만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10273_1556243522.5508.jpg");
            weeklyWebtoonData.setTitle("내 부인은 16살");
            weeklyWebtoonData.setSubTitle("제206화 최종화");
            weeklyWebtoonData.setHit("18만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

            weeklyWebtoonData = new WeeklyWebtoonData();
            weeklyWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb12/10301_1558422314.5707.jpg");
            weeklyWebtoonData.setTitle("이방인");
            weeklyWebtoonData.setSubTitle("제53화 최종화");
            weeklyWebtoonData.setHit("5.4만");
            weeklyWebtoonDatas.add(weeklyWebtoonData);

        }
        weeklyRecyclerAdapter = new WeeklyRecyclerViewAdapter(weeklyWebtoonDatas, requireActivity());
        weeklyRecycle.setAdapter(weeklyRecyclerAdapter);
    }
}