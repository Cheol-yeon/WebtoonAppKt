package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    // 전달받은 탭의 값
    private static final String ARG_PARAM1 = "type";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    RankingWebtoonData rankingWebtoonData;
    ArrayList<RankingWebtoonData> rankingWebtoonDataArrayList;

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
        rankingWebtoonDataArrayList = new ArrayList<>();

        if(mParam1 == "Realtime") {
            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/5412_1580460555.8501.jpg");
            rankingWebtoonData.setTitle("편의점 샛별이");
            rankingWebtoonData.setSub_title("제67화 최종화-영업종료");
            rankingWebtoonData.setHit("5,803만");
            rankingWebtoonData.setRank("1위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10291_1558085744.1762.jpg");
            rankingWebtoonData.setTitle("사각사각 로맨스");
            rankingWebtoonData.setSub_title("제168화-처음 보는 남자친구의 표정");
            rankingWebtoonData.setHit("1,942만");
            rankingWebtoonData.setRank("2위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10415_1591248416.2574.jpg");
            rankingWebtoonData.setTitle("H-mate");
            rankingWebtoonData.setSub_title("제75화 최종화-해피엔딩");
            rankingWebtoonData.setHit("46만");
            rankingWebtoonData.setRank("3위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10609_1619599386.7538.jpg");
            rankingWebtoonData.setTitle("대표님, 사모님이 도망가요");
            rankingWebtoonData.setSub_title("제289화 최종화");
            rankingWebtoonData.setHit("48만");
            rankingWebtoonData.setRank("4위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10586_1614672726.6089.jpg");
            rankingWebtoonData.setTitle("신데렐라의 역습");
            rankingWebtoonData.setSub_title("시즌1 최종화");
            rankingWebtoonData.setHit("6.5만");
            rankingWebtoonData.setRank("5위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10340_1566267954.1921.jpg");
            rankingWebtoonData.setTitle("블러디 발렌타인:인류종말");
            rankingWebtoonData.setSub_title("제412화");
            rankingWebtoonData.setHit("11만");
            rankingWebtoonData.setRank("6위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if(mParam1 == "Update") {
            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10828_1645411050.2519.jpg");
            rankingWebtoonData.setTitle("신무천존");
            rankingWebtoonData.setSub_title("제134화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("1위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10568_1604900784.8631.jpg");
            rankingWebtoonData.setTitle("속도위반 대표님과 계약 아내");
            rankingWebtoonData.setSub_title("제410화");
            rankingWebtoonData.setHit("95만");
            rankingWebtoonData.setRank("2위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10859_1646896306.4209.jpg");
            rankingWebtoonData.setTitle("불순한 동거동락");
            rankingWebtoonData.setSub_title("제80화 최종화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("3위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg");
            rankingWebtoonData.setTitle("폭군의 눈물");
            rankingWebtoonData.setSub_title("제47화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("4위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10532_1596439274.1639.jpg");
            rankingWebtoonData.setTitle("대표님 책임지세요");
            rankingWebtoonData.setSub_title("제207화");
            rankingWebtoonData.setHit("29만");
            rankingWebtoonData.setRank("5위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10830_1645410926.1581.jpg");
            rankingWebtoonData.setTitle("무적검역");
            rankingWebtoonData.setSub_title("제94화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("6위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if(mParam1 == "New") {
            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10848_1646639017.4464.jpg");
            rankingWebtoonData.setTitle("말단 병사에서 군주까지");
            rankingWebtoonData.setSub_title("제71화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("1위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10850_1646644712.7923.jpg");
            rankingWebtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            rankingWebtoonData.setSub_title("제27화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("2위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10816_1644220013.7383.jpg");
            rankingWebtoonData.setTitle("별빛 아래 우리");
            rankingWebtoonData.setSub_title("제67화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("3위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10831_1645411113.0887.jpg");
            rankingWebtoonData.setTitle("역천 지존");
            rankingWebtoonData.setSub_title("제89화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("4위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg");
            rankingWebtoonData.setTitle("폭군의 눈물");
            rankingWebtoonData.setSub_title("제47화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("5위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10852_1646644078.0962.jpg");
            rankingWebtoonData.setTitle("나홀로 초능력자");
            rankingWebtoonData.setSub_title("제32화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("6위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if(mParam1 == "Sale") {
            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10871_1648016636.5223.jpg");
            rankingWebtoonData.setTitle("무역:운명을 거스르다");
            rankingWebtoonData.setSub_title("제98화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("1위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10174_1545109436.0006.jpg");
            rankingWebtoonData.setTitle("동네 누나");
            rankingWebtoonData.setSub_title("제50화-너 지금 뭐 하는 거야?");
            rankingWebtoonData.setHit("1,047만");
            rankingWebtoonData.setRank("2위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10450_1582881801.935.jpg");
            rankingWebtoonData.setTitle("누나:연");
            rankingWebtoonData.setSub_title("제63화 최종화-우리는 살아남았다");
            rankingWebtoonData.setHit("21만");
            rankingWebtoonData.setRank("3위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/2631_1550797351.4803.jpg");
            rankingWebtoonData.setTitle("청소부K");
            rankingWebtoonData.setSub_title("시즌2 제149화 최종화-항상 널 지켜보고 있다");
            rankingWebtoonData.setHit("3,436만");
            rankingWebtoonData.setRank("4위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10818_1644220372.3696.jpg");
            rankingWebtoonData.setTitle("백스테이지 키스신");
            rankingWebtoonData.setSub_title("제46화");
            rankingWebtoonData.setHit("5천");
            rankingWebtoonData.setRank("5위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

            rankingWebtoonData = new RankingWebtoonData();
            rankingWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10663_1625193390.5776.jpg");
            rankingWebtoonData.setTitle("대표님 살살해요");
            rankingWebtoonData.setSub_title("제194화");
            rankingWebtoonData.setHit("46만");
            rankingWebtoonData.setRank("6위");
            rankingWebtoonDataArrayList.add(rankingWebtoonData);

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        }

        adapter = new RankingRecyclerViewAdapter(rankingWebtoonDataArrayList, requireActivity());
        recyclerView.setAdapter(adapter);
    }
}