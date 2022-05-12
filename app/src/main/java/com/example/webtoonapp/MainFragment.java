package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    RadioButton radioButtonKeyword1,
            radioButtonKeyword2,
            radioButtonKeyword3,
            radioButtonKeyword4,
            radioButtonKeyword5,
            radioButtonKeyword6,
            radioButtonKeyword7,
            radioButtonKeyword8;

    RadioButton radioButtonRecommand1,
            radioButtonRecommand2,
            radioButtonRecommand3,
            radioButtonRecommand4,
            radioButtonRecommand5,
            radioButtonRecommand6,
            radioButtonRecommand7,
            radioButtonRecommand8;


    ArrayList<WebtoonData> webtoonDataArrayList;
    WebtoonData webtoonData;

    ViewPager2 viewPager2_banner, viewPager2_ranking, viewPager2_event;
    private LinearLayout layoutIndicator;
    TabLayout tabLayout;
    RadioGroup radioGroupKeyword;

    private RecyclerView keyWordRecycle;
    private RecyclerView.Adapter keyWordRecycleAdapter;
    private RecyclerView.LayoutManager keyWordRecycleLayoutManager;

    private RecyclerView recommandRecycle;
    private RecyclerView.Adapter recommandRecycleAdapter;
    private RecyclerView.LayoutManager recommandRecycleLayoutManager;

    private RecyclerView waitRecycle;
    private RecyclerView.Adapter waitRecycleAdapter;
    private RecyclerView.LayoutManager waitRecycleLayoutManager;

    private RecyclerView coinRecycle;
    private RecyclerView.Adapter coinRecycleAdapter;
    private RecyclerView.LayoutManager coinRecycleLayoutManager;

    private String[] images = new String[]{
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

    private String[] images_event = new String[]{
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/396_12161.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/162_19811.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/234_17061.png",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/340_15811.png",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/61_13501.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/94_10841.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/133_10691.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/240_13351.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/200_12861.jpg",
            "https://shtosebzjw.akamaized.net/assets/upfile/event_thumb/395_17081.png"
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        configViews(view);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 초기화
        layoutIndicator = view.findViewById(R.id.layoutIndicators);
        viewPager2_banner = view.findViewById(R.id.vp2_banner);
        viewPager2_ranking = view.findViewById(R.id.vp2_ranking);
        viewPager2_event = view.findViewById(R.id.vp2_eventbanner);
        tabLayout = view.findViewById(R.id.tl_ranking);
        keyWordRecycle = view.findViewById(R.id.rv_keyWord);
        recommandRecycle = view.findViewById(R.id.rv_recommand);
        waitRecycle = view.findViewById(R.id.rv_waitFree);
        coinRecycle = view.findViewById(R.id.rv_1coin);

        // 화면에 보여줄 뷰페이저2 개수
        viewPager2_banner.setOffscreenPageLimit(1);
        viewPager2_ranking.setOffscreenPageLimit(2);
        viewPager2_event.setOffscreenPageLimit(2);

        // viewPager2_banner
        // 뷰페이저2 아이템 지정
        viewPager2_banner.setAdapter(new BannerAdapter(this.getContext(), images));

        // 배너 이동할 때 마다 몇번째인지 알려줌
        viewPager2_banner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position >= images.length) {
                    position = position % images.length;
                }
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.length);

        // viewPager2_event
        viewPager2_event.setAdapter(new EventAdapter(this.getContext(), images_event));

        //viewPager2_ranking
        // 뷰페이저2에서 화면 우측에 다음페이지 미리보기 표시
        viewPager2_ranking.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2_ranking.setPageTransformer(compositePageTransformer);

//        SpringDotsIndicator indicator = view.findViewById(R.id.layoutIndicators);
//        indicator.setViewPager2(viewPager2_banner);

        viewPager2_ranking.setAdapter(new RankingAdapter(this.getActivity()));
        // 인기순위 탭 레이아웃과 목록 표시할 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager2_ranking, (tab, position) -> {

            switch (position) {
                case 0: {
                    tab.setText("실시간");
                    break;
                }
                case 1: {
                    tab.setText("업데이트");
                    break;
                }
                case 2: {
                    tab.setText("신작");
                    break;
                }
                case 3: {
                    tab.setText("할인");
                    break;
                }
            }

        }).attach();

        // 맞춤 키워드탭 RecyclerView 이용 데이터 출력
        keyWordRecycle.setHasFixedSize(true);
        keyWordRecycleLayoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        keyWordRecycle.setLayoutManager(keyWordRecycleLayoutManager);

        recommandRecycle.setHasFixedSize(true);
        recommandRecycleLayoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        recommandRecycle.setLayoutManager(recommandRecycleLayoutManager);

        waitRecycle.setHasFixedSize(true);
        waitRecycleLayoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        waitRecycle.setLayoutManager(waitRecycleLayoutManager);

        coinRecycle.setHasFixedSize(true);
        coinRecycleLayoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);
        coinRecycle.setLayoutManager(coinRecycleLayoutManager);

        getKeywordData(1);
        getRecommandData(1);
        getWaitData();
        getCoinData();

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
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this.getContext(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }

    // Fragment 에서 OnClickListener을 사용할 수 없어 따로 함수 정의
    public void configViews(View view) {

        radioGroupKeyword = view.findViewById(R.id.rg_filter1);
        int selectedId = radioGroupKeyword.getCheckedRadioButtonId();

        radioButtonKeyword1 = view.findViewById(R.id.rb_button1);
        radioButtonKeyword2 = view.findViewById(R.id.rb_button2);
        radioButtonKeyword3 = view.findViewById(R.id.rb_button3);
        radioButtonKeyword4 = view.findViewById(R.id.rb_button4);
        radioButtonKeyword5 = view.findViewById(R.id.rb_button5);
        radioButtonKeyword6 = view.findViewById(R.id.rb_button6);
        radioButtonKeyword7 = view.findViewById(R.id.rb_button7);
        radioButtonKeyword8 = view.findViewById(R.id.rb_button8);

        radioButtonRecommand1 = view.findViewById(R.id.rb_button1_2);
        radioButtonRecommand2 = view.findViewById(R.id.rb_button2_2);
        radioButtonRecommand3 = view.findViewById(R.id.rb_button3_2);
        radioButtonRecommand4 = view.findViewById(R.id.rb_button4_2);
        radioButtonRecommand5 = view.findViewById(R.id.rb_button5_2);
        radioButtonRecommand6 = view.findViewById(R.id.rb_button6_2);
        radioButtonRecommand7 = view.findViewById(R.id.rb_button7_2);
        radioButtonRecommand8 = view.findViewById(R.id.rb_button8_2);

        radioButtonKeyword1.setOnClickListener(this::onClick);
        radioButtonKeyword2.setOnClickListener(this::onClick);
        radioButtonKeyword3.setOnClickListener(this::onClick);
        radioButtonKeyword4.setOnClickListener(this::onClick);
        radioButtonKeyword5.setOnClickListener(this::onClick);
        radioButtonKeyword6.setOnClickListener(this::onClick);
        radioButtonKeyword7.setOnClickListener(this::onClick);
        radioButtonKeyword8.setOnClickListener(this::onClick);

        radioButtonRecommand1.setOnClickListener(this::onClick2);
        radioButtonRecommand2.setOnClickListener(this::onClick2);
        radioButtonRecommand3.setOnClickListener(this::onClick2);
        radioButtonRecommand4.setOnClickListener(this::onClick2);
        radioButtonRecommand5.setOnClickListener(this::onClick2);
        radioButtonRecommand6.setOnClickListener(this::onClick2);
        radioButtonRecommand7.setOnClickListener(this::onClick2);
        radioButtonRecommand8.setOnClickListener(this::onClick2);
    }

    // RadioGroup 사용하였으나 배치를 위해 LinearLayout을 사용하였더니 다중체크가 되어 라디오버튼 각각마다 설정
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_button1: {
                Log.e("onClick", "rb_button1");
                if (radioButtonKeyword1.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(1);
                break;
            }
            case R.id.rb_button2: {
                Log.e("onClick", "rb_button2");
                if (radioButtonKeyword2.isChecked() == true) {
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(2);
                break;
            }
            case R.id.rb_button3: {
                Log.e("onClick", "rb_button3");
                if (radioButtonKeyword3.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(3);
                break;
            }
            case R.id.rb_button4: {
                Log.e("onClick", "rb_button4");
                if (radioButtonKeyword4.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(4);
                break;
            }
            case R.id.rb_button5: {
                Log.e("onClick", "rb_button5");
                if (radioButtonKeyword5.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(5);
                break;
            }
            case R.id.rb_button6: {
                Log.e("onClick", "rb_button6");
                if (radioButtonKeyword6.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(6);
                break;
            }
            case R.id.rb_button7: {
                Log.e("onClick", "rb_button7");
                if (radioButtonKeyword7.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                    radioButtonKeyword8.setChecked(false);
                }
                getKeywordData(7);
                break;
            }
            case R.id.rb_button8: {
                Log.e("onClick", "rb_button8");
                if (radioButtonKeyword8.isChecked() == true) {
                    radioButtonKeyword2.setChecked(false);
                    radioButtonKeyword3.setChecked(false);
                    radioButtonKeyword4.setChecked(false);
                    radioButtonKeyword5.setChecked(false);
                    radioButtonKeyword6.setChecked(false);
                    radioButtonKeyword7.setChecked(false);
                    radioButtonKeyword1.setChecked(false);
                }
                getKeywordData(8);
                break;
            }
        }
    }

    public void onClick2(View v) {
        switch (v.getId()) {
            case R.id.rb_button1_2: {
                Log.e("onClick", "rb_button1_2");
                if (radioButtonRecommand1.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(1);
                break;
            }
            case R.id.rb_button2_2: {
                Log.e("onClick", "rb_button2_2");
                if (radioButtonRecommand2.isChecked() == true) {
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(2);
                break;
            }
            case R.id.rb_button3_2: {
                Log.e("onClick", "rb_button3_2");
                if (radioButtonRecommand3.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(3);
                break;
            }
            case R.id.rb_button4_2: {
                Log.e("onClick", "rb_button4_2");
                if (radioButtonRecommand4.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(4);
                break;
            }
            case R.id.rb_button5_2: {
                Log.e("onClick", "rb_button5_2");
                if (radioButtonRecommand5.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(5);
                break;
            }
            case R.id.rb_button6_2: {
                Log.e("onClick", "rb_button6_2");
                if (radioButtonRecommand6.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(6);
                break;
            }
            case R.id.rb_button7_2: {
                Log.e("onClick", "rb_button7_2");
                if (radioButtonRecommand7.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                    radioButtonRecommand8.setChecked(false);
                }
                getRecommandData(7);
                break;
            }
            case R.id.rb_button8_2: {
                Log.e("onClick", "rb_button8_2");
                if (radioButtonRecommand8.isChecked() == true) {
                    radioButtonRecommand2.setChecked(false);
                    radioButtonRecommand3.setChecked(false);
                    radioButtonRecommand4.setChecked(false);
                    radioButtonRecommand5.setChecked(false);
                    radioButtonRecommand6.setChecked(false);
                    radioButtonRecommand7.setChecked(false);
                    radioButtonRecommand1.setChecked(false);
                }
                getRecommandData(8);
                break;
            }
        }
    }

    // 눌린 버튼의 값을 불러와 Data저장 후 RecyclerView로 출력
    public void getKeywordData(int btnNo) {
        webtoonDataArrayList = new ArrayList<>();

        if (btnNo == 1) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            webtoonData.setTitle("앙(怏)");
            webtoonData.setSub_title("김진수");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            webtoonData.setTitle("사각사각 로맨스");
            webtoonData.setSub_title("말초코칩");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            webtoonData.setTitle("청소부K");
            webtoonData.setSub_title("신진우&홍순식");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            webtoonData.setTitle("신혼좀비");
            webtoonData.setSub_title("생쥐");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            webtoonData.setTitle("편의점 샛별이");
            webtoonData.setSub_title("활화산&스기키 하루미");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 2 || btnNo == 4) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            webtoonData.setTitle("앙(怏)");
            webtoonData.setSub_title("김진수");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10855_1646962607.1277.jpg");
            webtoonData.setTitle("모쉬의 슬기로운 먹는생활");
            webtoonData.setSub_title("모쉬");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            webtoonData.setTitle("신혼좀비");
            webtoonData.setSub_title("생쥐");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10854_1646962017.567.jpg");
            webtoonData.setTitle("무협소녀와 강아지");
            webtoonData.setSub_title("웹티&을코");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10839_1646707637.0069.png");
            webtoonData.setTitle("심야십담");
            webtoonData.setSub_title("시코르스키&천도담");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 3) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10806_1642490978.5388.jpg");
            webtoonData.setTitle("천일의 아내");
            webtoonData.setSub_title("0510&베리&죠이나");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10200_1550461930.3529.jpg");
            webtoonData.setTitle("프릭");
            webtoonData.setSub_title("신진우&홍순식");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10300_1560234034.5599.jpg");
            webtoonData.setTitle("Mad:콜때기");
            webtoonData.setSub_title("고영훈&김찬영");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10634_1640604653.6298.jpg");
            webtoonData.setTitle("잘못 전한 편지");
            webtoonData.setSub_title("배뚱&생선찜");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10860_1646898197.8547.jpg");
            webtoonData.setTitle("낮에 뜨는 별");
            webtoonData.setSub_title("채은,고다고");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 5) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            webtoonData.setTitle("앙(怏)");
            webtoonData.setSub_title("김진수");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10859_1646896306.429.jpg");
            webtoonData.setTitle("불순한 동거동락");
            webtoonData.setSub_title("황한영,이룸");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10871_1648016636.5417.jpg");
            webtoonData.setTitle("무역: 운명을 거스르다");
            webtoonData.setSub_title("작은새우/일차원동만");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10870_1648016298.5089.jpg");
            webtoonData.setTitle("만고지존");
            webtoonData.setSub_title("태일생수/잭 노르웨이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10858_1646894514.7813.jpg");
            webtoonData.setTitle("그 남자의 계략");
            webtoonData.setSub_title("이채영,한우주");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 6) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10174_1574317553.4498.png");
            webtoonData.setTitle("동네 누나");
            webtoonData.setSub_title("타르초&견자");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10590_1612338793.8735.jpg");
            webtoonData.setTitle("당구장 사랑이");
            webtoonData.setSub_title("캄쟈&성백&옥충이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10563_1603689733.1208.jpg");
            webtoonData.setTitle("돈과 여자");
            webtoonData.setSub_title("김홍태&TB Production");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10541_1599189957.4919.jpg");
            webtoonData.setTitle("아내가 돌아왔다");
            webtoonData.setSub_title("양파&꼬붕");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10535_1596419741.0281.jpg");
            webtoonData.setTitle("고소한 여자");
            webtoonData.setSub_title("에일리언&frog");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 7) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            webtoonData.setTitle("사각사각 로맨스");
            webtoonData.setSub_title("말초코칩");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            webtoonData.setTitle("그녀, 윤희");
            webtoonData.setSub_title("병수씨");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10568_1604900784.8866.jpg");
            webtoonData.setTitle("속도위반 대표님과 계약 아내");
            webtoonData.setSub_title("Shuibuciyuan&kkworld&Flower");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8322_1496987995.183.jpg");
            webtoonData.setTitle("복수할까? 연애할까?");
            webtoonData.setSub_title("핑지");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            webtoonData.setTitle("편의점 샛별이");
            webtoonData.setSub_title("활화산&스기키 하루미");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 8) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            webtoonData.setTitle("편의점 샛별이");
            webtoonData.setSub_title("활화산&스기키 하루미");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            webtoonData.setTitle("청소부K");
            webtoonData.setSub_title("신진우&홍순식");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/1345_1553841689.2188.jpg");
            webtoonData.setTitle("뽈쟁이 툰");
            webtoonData.setSub_title("뽈쟁이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10303_1559888119.0164.jpg");
            webtoonData.setTitle("음지킹");
            webtoonData.setSub_title("서영관");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            webtoonData.setTitle("그녀, 윤희");
            webtoonData.setSub_title("병수씨");
            webtoonDataArrayList.add(webtoonData);
        }

        keyWordRecycleAdapter = new WebtoonRecyclerViewAdapter(webtoonDataArrayList, getContext());
        keyWordRecycle.setAdapter(keyWordRecycleAdapter);
    }

    public void getRecommandData(int btnNo) {
        webtoonDataArrayList = new ArrayList<>();

        if (btnNo == 1) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            webtoonData.setTitle("사각사각 로맨스");
            webtoonData.setSub_title("말초코칩");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10561_1602826603.2833.jpg");
            webtoonData.setTitle("비밀수업");
            webtoonData.setSub_title("왕강철&미나짱");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10639_1623142571.2271.jpg");
            webtoonData.setTitle("절친의 모든 것");
            webtoonData.setSub_title("형작가&타르초");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10663_1625193390.6024.jpg");
            webtoonData.setTitle("대표님 살살해요");
            webtoonData.setSub_title("웹티&올코");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10568_1604900784.8866.jpg");
            webtoonData.setTitle("속도위반 대표님과 계약 아내");
            webtoonData.setSub_title("Shuibuciyuan&kkworld&Flower");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 2) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10561_1602826603.2833.jpg");
            webtoonData.setTitle("비밀수업");
            webtoonData.setSub_title("왕강철&미나짱");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            webtoonData.setTitle("편의점 샛별이");
            webtoonData.setSub_title("활화산&스기키 하루미");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10576_1607593022.2276.jpg");
            webtoonData.setTitle("하숙일기");
            webtoonData.setSub_title("김제타&용의자H");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10663_1625193390.6024.jpg");
            webtoonData.setTitle("대표님 살살해요");
            webtoonData.setSub_title("웹티&올코");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10704_1627867858.6998.jpg");
            webtoonData.setTitle("동아리");
            webtoonData.setSub_title("슈리넬&QRQ");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 3) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            webtoonData.setTitle("청소부K");
            webtoonData.setSub_title("신진우&홍순식");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            webtoonData.setTitle("앙(怏)");
            webtoonData.setSub_title("김진수");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10850_1646644682.9942.jpg");
            webtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            webtoonData.setSub_title("Beimuliuhuo&Cat Comics");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10448_1579570605.6723.jpg");
            webtoonData.setTitle("작은 전쟁");
            webtoonData.setSub_title("얀새&타르초");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/3979_1453854610.8889.jpg");
            webtoonData.setTitle("독고");
            webtoonData.setSub_title("Meen&백승훈");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 4) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/1345_1553841689.2188.jpg");
            webtoonData.setTitle("뽈쟁이 툰");
            webtoonData.setSub_title("뽈쟁이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/3211_1459301291.5446.jpg");
            webtoonData.setTitle("뽈쟁이의 BBOL한 일상만화");
            webtoonData.setSub_title("뽈쟁이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/7939_1493109178.9834.jpg");
            webtoonData.setTitle("희키툰");
            webtoonData.setSub_title("희키");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10642_1623822955.9469.jpg");
            webtoonData.setTitle("역전의 샤이닝스타");
            webtoonData.setSub_title("웹티&올코");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10855_1646962607.1277.jpg");
            webtoonData.setTitle("모쉬의 슬기로운 먹는생활");
            webtoonData.setSub_title("모쉬");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 5) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10850_1646644682.9942.jpg");
            webtoonData.setTitle("전설 헌터로 키워지는 중입니다");
            webtoonData.setSub_title("Beimuliuhuo&Cat Comics");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10802_1641785551.1569.jpg");
            webtoonData.setTitle("레벨업에 미친 의사");
            webtoonData.setSub_title("ZhiNiaoCun&JSCR");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10866_1647591657.2121.jpg");
            webtoonData.setTitle("현질해서 최강으로 레벨업!");
            webtoonData.setSub_title("대목&노뚠뚠, 반위");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10848_1646639017.4884.jpg");
            webtoonData.setTitle("말단 병사에서 군주까지");
            webtoonData.setSub_title("doip&소울풍&2631");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10586_1614672726.6537.jpg");
            webtoonData.setTitle("신데렐라의 역습");
            webtoonData.setSub_title("유룩");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 6) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10839_1646707637.0069.png");
            webtoonData.setTitle("심야십담");
            webtoonData.setSub_title("시코르스키&천도담");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/7223_1486026549.5581.jpg");
            webtoonData.setTitle("기기묘묘");
            webtoonData.setSub_title("깔선&멀덕");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10340_1566267954.2236.jpg");
            webtoonData.setTitle("블러디 발렌타인 : 인류종말");
            webtoonData.setSub_title("Bluemoon&Twenty4");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8450_1497938769.8037.jpg");
            webtoonData.setTitle("사일런트 문");
            webtoonData.setSub_title("빨간 휴지");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10492_1596518995.6398.jpg");
            webtoonData.setTitle("원킬");
            webtoonData.setSub_title("팀 잔나비");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 7) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            webtoonData.setTitle("사각사각 로맨스");
            webtoonData.setSub_title("말초코칩");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/1345_1553841689.2188.jpg");
            webtoonData.setTitle("뽈쟁이 툰");
            webtoonData.setSub_title("뽈쟁이");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            webtoonData.setTitle("신혼좀비");
            webtoonData.setSub_title("생쥐");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10360_1566543133.7083.png");
            webtoonData.setTitle("일탈 : 즐거운 나의 집");
            webtoonData.setSub_title("병수씨");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10852_1646644078.1351.jpg");
            webtoonData.setTitle("나홀로 초능력자");
            webtoonData.setSub_title("GUMINGYUEYE&NAMU");
            webtoonDataArrayList.add(webtoonData);
        } else if (btnNo == 8) {
            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10831_1645411113.1267.jpg");
            webtoonData.setTitle("역천지존");
            webtoonData.setSub_title("kuyayumu");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10828_1645411050.289.jpg");
            webtoonData.setTitle("신무천존");
            webtoonData.setSub_title("LEGEND ANIMATION");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10830_1645410926.1972.jpg");
            webtoonData.setTitle("무적검역");
            webtoonData.setSub_title("소명태극");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10245_1552357810.8887.jpg");
            webtoonData.setTitle("성무신결");
            webtoonData.setSub_title("아이리더");
            webtoonDataArrayList.add(webtoonData);

            webtoonData = new WebtoonData();
            webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10826_1645410735.9261.jpg");
            webtoonData.setTitle("만계신주");
            webtoonData.setSub_title("스네일");
            webtoonDataArrayList.add(webtoonData);
        }

        recommandRecycleAdapter = new WebtoonRecyclerViewAdapter(webtoonDataArrayList, getContext());
        recommandRecycle.setAdapter(recommandRecycleAdapter);
    }

    public void getWaitData() {
        webtoonDataArrayList = new ArrayList<>();

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10806_1642490978.5388.jpg");
        webtoonData.setTitle("천일의 아내");
        webtoonData.setSub_title("0510&베리&죠이나");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10300_1560234034.5599.jpg");
        webtoonData.setTitle("Mad : 콜때기");
        webtoonData.setSub_title("고영훈&김찬영");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10860_1646898197.8547.jpg");
        webtoonData.setTitle("낮에 뜨는 별");
        webtoonData.setSub_title("채은,고다고");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10779_1641439329.9598.jpg");
        webtoonData.setTitle("인류멸망같은 건 상관없어");
        webtoonData.setSub_title("김정호");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10609_1619599386.7962.jpg");
        webtoonData.setTitle("대표님, 사모님이 도망가요");
        webtoonData.setSub_title("Hongshu&Anyouran");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/9993_1515742630.1929.jpg");
        webtoonData.setTitle("프릭");
        webtoonData.setSub_title("신진우&홍순식");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10867_1647592077.2087.jpg");
        webtoonData.setTitle("대귀갑사");
        webtoonData.setSub_title("당가삼소&DL.Sir");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10634_1640604653.6298.jpg");
        webtoonData.setTitle("잘못 전한 편지");
        webtoonData.setSub_title("배뚱&생선찜");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10866_1647591657.2121.jpg");
        webtoonData.setTitle("현질해서 최강으로 레벨업!");
        webtoonData.setSub_title("대목&노뚠뚠, 반위");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10857_1646893667.3302.jpg");
        webtoonData.setTitle("너와 사는 오늘");
        webtoonData.setSub_title("우지혜,두르");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10858_1646894514.7813.jpg");
        webtoonData.setTitle("그 남자의 계략");
        webtoonData.setSub_title("이채영,한우주");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10859_1646896306.429.jpg");
        webtoonData.setTitle("불순한 동거동락");
        webtoonData.setSub_title("황한영,이룸");
        webtoonDataArrayList.add(webtoonData);

        waitRecycleAdapter = new WebtoonRecyclerViewAdapter2(webtoonDataArrayList, getContext());
        waitRecycle.setAdapter(waitRecycleAdapter);
    }

    public void getCoinData() {
        webtoonDataArrayList = new ArrayList<>();

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10408_1572601697.2488.jpg");
        webtoonData.setTitle("렛 미 드라이브");
        webtoonData.setSub_title("견자");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10790_1640248556.607.jpg");
        webtoonData.setTitle("독충마왕 벌레들의 전쟁");
        webtoonData.setSub_title("검군");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10777_1638417070.3987.jpg");
        webtoonData.setTitle("오해로 시작된 사이");
        webtoonData.setSub_title("Kuaikan&QianTangTang&FangChao");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10263_1554108800.5357.jpg");
        webtoonData.setTitle("백은아란전");
        webtoonData.setSub_title("송정욱&송의섭");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10677_1626345325.6626.jpg");
        webtoonData.setTitle("소년검객");
        webtoonData.setSub_title("웹티&올코");
        webtoonDataArrayList.add(webtoonData);

        webtoonData = new WebtoonData();
        webtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10586_1614672726.6537.jpg");
        webtoonData.setTitle("신데렐라의 역습");
        webtoonData.setSub_title("유룩");
        webtoonDataArrayList.add(webtoonData);

        coinRecycleAdapter = new WebtoonRecyclerViewAdapter2(webtoonDataArrayList, getContext());
        coinRecycle.setAdapter(coinRecycleAdapter);
    }
}