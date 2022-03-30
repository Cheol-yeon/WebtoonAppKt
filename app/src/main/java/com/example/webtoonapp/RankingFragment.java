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
        } else if(mParam1 == "Update") {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10828_1645411050.2519.jpg");
            webtoonData.setTitle("신무천존");
            webtoonData.setSub_title("제134화");
            webtoonData.setHit("5천");
            webtoonData.setRank("1위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10568_1604900784.8631.jpg");
            webtoonData.setTitle("속도위반 대표님과 계약 아내");
            webtoonData.setSub_title("제410화");
            webtoonData.setHit("95만");
            webtoonData.setRank("2위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10859_1646896306.4209.jpg");
            webtoonData.setTitle("불순한 동거동락");
            webtoonData.setSub_title("제80화 최종화");
            webtoonData.setHit("5천");
            webtoonData.setRank("3위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg");
            webtoonData.setTitle("폭군의 눈물");
            webtoonData.setSub_title("제47화");
            webtoonData.setHit("5천");
            webtoonData.setRank("4위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10532_1596439274.1639.jpg");
            webtoonData.setTitle("대표님 책임지세요");
            webtoonData.setSub_title("제207화");
            webtoonData.setHit("29만");
            webtoonData.setRank("5위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10830_1645410926.1581.jpg");
            webtoonData.setTitle("무적검역");
            webtoonData.setSub_title("제94화");
            webtoonData.setHit("5천");
            webtoonData.setRank("6위");
            webtoonDataArrayList.add(webtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if(mParam1 == "New") {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10848_1646639017.4464.jpg");
            webtoonData.setTitle("말단 병사에서 군주까지");
            webtoonData.setSub_title("제71화");
            webtoonData.setHit("5천");
            webtoonData.setRank("1위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10850_1646644712.7923.jpg");
            webtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            webtoonData.setSub_title("제27화");
            webtoonData.setHit("5천");
            webtoonData.setRank("2위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10816_1644220013.7383.jpg");
            webtoonData.setTitle("별빛 아래 우리");
            webtoonData.setSub_title("제67화");
            webtoonData.setHit("5천");
            webtoonData.setRank("3위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10831_1645411113.0887.jpg");
            webtoonData.setTitle("역천 지존");
            webtoonData.setSub_title("제89화");
            webtoonData.setHit("5천");
            webtoonData.setRank("4위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg");
            webtoonData.setTitle("폭군의 눈물");
            webtoonData.setSub_title("제47화");
            webtoonData.setHit("5천");
            webtoonData.setRank("5위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10852_1646644078.0962.jpg");
            webtoonData.setTitle("나홀로 초능력자");
            webtoonData.setSub_title("제32화");
            webtoonData.setHit("5천");
            webtoonData.setRank("6위");
            webtoonDataArrayList.add(webtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if(mParam1 == "Sale") {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10871_1648016636.5223.jpg");
            webtoonData.setTitle("무역:운명을 거스르다");
            webtoonData.setSub_title("제98화");
            webtoonData.setHit("5천");
            webtoonData.setRank("1위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10174_1545109436.0006.jpg");
            webtoonData.setTitle("동네 누나");
            webtoonData.setSub_title("제50화-너 지금 뭐 하는 거야?");
            webtoonData.setHit("1,047만");
            webtoonData.setRank("2위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10450_1582881801.935.jpg");
            webtoonData.setTitle("누나:연");
            webtoonData.setSub_title("제63화 최종화-우리는 살아남았다");
            webtoonData.setHit("21만");
            webtoonData.setRank("3위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/2631_1550797351.4803.jpg");
            webtoonData.setTitle("청소부K");
            webtoonData.setSub_title("시즌2 제149화 최종화-항상 널 지켜보고 있다");
            webtoonData.setHit("3,436만");
            webtoonData.setRank("4위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10818_1644220372.3696.jpg");
            webtoonData.setTitle("백스테이지 키스신");
            webtoonData.setSub_title("제46화");
            webtoonData.setHit("5천");
            webtoonData.setRank("5위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10663_1625193390.5776.jpg");
            webtoonData.setTitle("대표님 살살해요");
            webtoonData.setSub_title("제194화");
            webtoonData.setHit("46만");
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