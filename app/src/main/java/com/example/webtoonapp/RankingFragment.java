package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankingFragment extends Fragment {

    private static final String ARG_PARAM1 = "type";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    WebtoonData webtoonData;
    ArrayList<WebtoonData>  webtoonDataArrayList;

    // TODO: Rename and change types of parameters
    private String mParam1;

    public RankingFragment() {
        // Required empty public constructor
    }

    public static RankingFragment newInstance(String param1) {
        RankingFragment fragment = new RankingFragment();
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
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_ranking);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);

        setWebtoonData();
    }

    public void setWebtoonData() {
        webtoonDataArrayList = new ArrayList<>();

        if(mParam1 == "Realtime") {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/5412_1580460555.8501.jpg");
            webtoonData.setTitle("편의점 샛별이");
            webtoonData.setSub_title("제67화 최종화-영업종료");
            webtoonData.setHit("5,803만");
            webtoonData.setRank("1위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10291_1558085744.1762.jpg");
            webtoonData.setTitle("사각사각 로맨스");
            webtoonData.setSub_title("제168화-처음 보는 남자친구의 표정");
            webtoonData.setHit("1,942만");
            webtoonData.setRank("2위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10415_1591248416.2574.jpg");
            webtoonData.setTitle("H-mate");
            webtoonData.setSub_title("제75화 최종화-해피엔딩");
            webtoonData.setHit("46만");
            webtoonData.setRank("3위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10609_1619599386.7538.jpg");
            webtoonData.setTitle("대표님, 사모님이 도망가요");
            webtoonData.setSub_title("제289화 최종화");
            webtoonData.setHit("48만");
            webtoonData.setRank("4위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10586_1614672726.6089.jpg");
            webtoonData.setTitle("신데렐라의 역습");
            webtoonData.setSub_title("시즌1 최종화");
            webtoonData.setHit("6.5만");
            webtoonData.setRank("5위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10340_1566267954.1921.jpg");
            webtoonData.setTitle("블러디 발렌타인:인류종말");
            webtoonData.setSub_title("제412화");
            webtoonData.setHit("11만");
            webtoonData.setRank("6위");
            webtoonDataArrayList.add(webtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        }

        adapter = new RankingRecyclerViewAdapter(webtoonDataArrayList, requireActivity());
        recyclerView.setAdapter(adapter);
    }
}