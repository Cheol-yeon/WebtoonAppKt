package com.example.webtoonapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;


public class MainFragment extends Fragment {

    ViewPager2 viewPager2_banner, viewPager2_ranking;
    private LinearLayout layoutIndicator;
    TabLayout tabLayout;

    private String[] images = new String[] {
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/10017_1626067667.9501.png",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/12459_1646045778.3586.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/9889_1645603245.6129.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/12564_1647480946.766.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/12548_1647229344.7918.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/10128_1612516976.1911.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/10466_1625029486.3514.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/10129_1612516915.8922.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/10130_1612516944.6079.png",
            "https://shtosebzjw.akamaized.net/assets/upfile/banner/12549_1647229540.3236.jpg"
    };

    public MainFragment() {
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
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 초기화
        layoutIndicator = view.findViewById(R.id.layoutIndicators);
        viewPager2_banner = view.findViewById(R.id.vp2_banner);
        viewPager2_ranking = view.findViewById(R.id.vp2_ranking);
        tabLayout = view.findViewById(R.id.tl_ranking);

        // 뷰페이저2 아이템 지정
        viewPager2_banner.setOffscreenPageLimit(1);
        viewPager2_banner.setAdapter(new BannerAdapter(this.getContext(), images));

//        SpringDotsIndicator indicator = view.findViewById(R.id.layoutIndicators);
//        indicator.setViewPager2(viewPager2_banner);

        // 배너 이동할 때 마다 몇번째인지 알려줌
        viewPager2_banner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position >= images.length) {
                    position = position % images.length;
                }
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.length);


        viewPager2_ranking.setAdapter(new RankingAdapter(this.getActivity()));
        // 인기순위 탭 레이아웃과 목록 표시할 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager2_ranking,(tab, position) -> {

            switch (position) {
                case 0 : {
                    tab.setText("실시간");
                    break;
                }
                case 1 : {
                    tab.setText("업데이트");
                    break;
                }
                case 2 : {
                    tab.setText("신작");
                    break;
                }
                case 3 : {
                    tab.setText("할인");
                    break;
                }
            }

        }).attach();
    }

    // 뷰페이저2 위치에 따라 점으로 표시
    private void setupIndicators(int count) {
        ImageFilterView[] indicators = new ImageFilterView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(12, 8, 12, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageFilterView(this.getContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this.getContext(),
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);

            layoutIndicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        setCurrentIndicator(0);
    }

    // 선택되어있는 뷰페이저 아이콘 변경
    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < childCount; i++) {
            ImageFilterView imageView = (ImageFilterView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this.getContext(),
                        R.drawable.bg_indicator_active
                ));
                Log.e("MainFrag", "Selected = " + position);
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this.getContext(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }

}