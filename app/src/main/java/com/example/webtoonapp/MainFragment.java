package com.example.webtoonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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


    ArrayList<KeywordWebtoonData> keywordWebtoonDataArrayList;
    KeywordWebtoonData keywordWebtoonData;

    ViewPager2 viewPager2_banner, viewPager2_ranking;
    private LinearLayout layoutIndicator;
    TabLayout tabLayout;
    RadioGroup radioGroupKeyword;
    RadioButton radioButtonKeyword;

    private RecyclerView keyWordRecycle;
    private RecyclerView.Adapter keyWordRecycleAdapter;
    private RecyclerView.LayoutManager keyWordRecycleLayoutManager;

    private RecyclerView recommandRecycle;
    private RecyclerView.Adapter recommandRecycleAdapter;
    private RecyclerView.LayoutManager recommandRecycleLayoutManager;

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
        tabLayout = view.findViewById(R.id.tl_ranking);
        keyWordRecycle = view.findViewById(R.id.rv_keyWord);
        recommandRecycle = view.findViewById(R.id.rv_recommand);


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
                if (position >= images.length) {
                    position = position % images.length;
                }
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.length);


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

        getKeywordData(1);
        getRecommandData(1);

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

    // Fragment 에서 OnClickListener을 사용할 수 없어 따로 함수 정의
    public void configViews(View view) {

        radioGroupKeyword = view.findViewById(R.id.rg_filter1);
        int selectedId = radioGroupKeyword.getCheckedRadioButtonId();
        Log.e("SelectedId", "test = " + selectedId);

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
                Log.e("onClick", "rb_button2");
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
                Log.e("onClick", "rb_button3");
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
                Log.e("onClick", "rb_button4");
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
                Log.e("onClick", "rb_button5");
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
                Log.e("onClick", "rb_button6");
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
                Log.e("onClick", "rb_button7");
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
                Log.e("onClick", "rb_button8");
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
        keywordWebtoonDataArrayList = new ArrayList<>();

        if (btnNo == 1) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            keywordWebtoonData.setTitle("사각사각 로맨스");
            keywordWebtoonData.setSub_title("말초코칩");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            keywordWebtoonData.setTitle("청소부K");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            keywordWebtoonData.setTitle("신혼좀비");
            keywordWebtoonData.setSub_title("생쥐");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 2 || btnNo == 4) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10855_1646962607.1277.jpg");
            keywordWebtoonData.setTitle("모쉬의 슬기로운 먹는생활");
            keywordWebtoonData.setSub_title("모쉬");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            keywordWebtoonData.setTitle("신혼좀비");
            keywordWebtoonData.setSub_title("생쥐");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10854_1646962017.567.jpg");
            keywordWebtoonData.setTitle("무협소녀와 강아지");
            keywordWebtoonData.setSub_title("웹티&을코");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10839_1646707637.0069.png");
            keywordWebtoonData.setTitle("심야십담");
            keywordWebtoonData.setSub_title("시코르스키&천도담");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 3) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10806_1642490978.5388.jpg");
            keywordWebtoonData.setTitle("천일의 아내");
            keywordWebtoonData.setSub_title("0510&베리&죠이나");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10200_1550461930.3529.jpg");
            keywordWebtoonData.setTitle("프릭");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10300_1560234034.5599.jpg");
            keywordWebtoonData.setTitle("Mad:콜때기");
            keywordWebtoonData.setSub_title("고영훈&김찬영");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10634_1640604653.6298.jpg");
            keywordWebtoonData.setTitle("잘못 전한 편지");
            keywordWebtoonData.setSub_title("배뚱&생선찜");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10860_1646898197.8547.jpg");
            keywordWebtoonData.setTitle("낮에 뜨는 별");
            keywordWebtoonData.setSub_title("채은,고다고");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 5) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10859_1646896306.429.jpg");
            keywordWebtoonData.setTitle("불순한 동거동락");
            keywordWebtoonData.setSub_title("황한영,이룸");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10871_1648016636.5417.jpg");
            keywordWebtoonData.setTitle("무역: 운명을 거스르다");
            keywordWebtoonData.setSub_title("작은새우/일차원동만");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10870_1648016298.5089.jpg");
            keywordWebtoonData.setTitle("만고지존");
            keywordWebtoonData.setSub_title("태일생수/잭 노르웨이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10858_1646894514.7813.jpg");
            keywordWebtoonData.setTitle("그 남자의 계략");
            keywordWebtoonData.setSub_title("이채영,한우주");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 6) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10174_1574317553.4498.png");
            keywordWebtoonData.setTitle("동네 누나");
            keywordWebtoonData.setSub_title("타르초&견자");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10590_1612338793.8735.jpg");
            keywordWebtoonData.setTitle("당구장 사랑이");
            keywordWebtoonData.setSub_title("캄쟈&성백&옥충이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10563_1603689733.1208.jpg");
            keywordWebtoonData.setTitle("돈과 여자");
            keywordWebtoonData.setSub_title("김홍태&TB Production");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10541_1599189957.4919.jpg");
            keywordWebtoonData.setTitle("아내가 돌아왔다");
            keywordWebtoonData.setSub_title("양파&꼬붕");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10535_1596419741.0281.jpg");
            keywordWebtoonData.setTitle("고소한 여자");
            keywordWebtoonData.setSub_title("에일리언&frog");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 7) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            keywordWebtoonData.setTitle("사각사각 로맨스");
            keywordWebtoonData.setSub_title("말초코칩");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            keywordWebtoonData.setTitle("그녀, 윤희");
            keywordWebtoonData.setSub_title("병수씨");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10568_1604900784.8866.jpg");
            keywordWebtoonData.setTitle("속도위반 대표님과 계약 아내");
            keywordWebtoonData.setSub_title("Shuibuciyuan&kkworld&Flower");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8322_1496987995.183.jpg");
            keywordWebtoonData.setTitle("복수할까? 연애할까?");
            keywordWebtoonData.setSub_title("핑지");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 8) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            keywordWebtoonData.setTitle("청소부K");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/1345_1553841689.2188.jpg");
            keywordWebtoonData.setTitle("뽈쟁이 툰");
            keywordWebtoonData.setSub_title("뽈쟁이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10303_1559888119.0164.jpg");
            keywordWebtoonData.setTitle("음지킹");
            keywordWebtoonData.setSub_title("서영관");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            keywordWebtoonData.setTitle("그녀, 윤희");
            keywordWebtoonData.setSub_title("병수씨");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        }

        keyWordRecycleAdapter = new KeywordRecyclerViewAdapter(keywordWebtoonDataArrayList, getContext());
        keyWordRecycle.setAdapter(keyWordRecycleAdapter);
    }

    public void getRecommandData(int btnNo) {
        keywordWebtoonDataArrayList = new ArrayList<>();

        if (btnNo == 1) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            keywordWebtoonData.setTitle("사각사각 로맨스");
            keywordWebtoonData.setSub_title("말초코칩");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            keywordWebtoonData.setTitle("청소부K");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            keywordWebtoonData.setTitle("신혼좀비");
            keywordWebtoonData.setSub_title("생쥐");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 2 || btnNo == 4) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10855_1646962607.1277.jpg");
            keywordWebtoonData.setTitle("모쉬의 슬기로운 먹는생활");
            keywordWebtoonData.setSub_title("모쉬");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10847_1646971047.4575.jpg");
            keywordWebtoonData.setTitle("신혼좀비");
            keywordWebtoonData.setSub_title("생쥐");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10854_1646962017.567.jpg");
            keywordWebtoonData.setTitle("무협소녀와 강아지");
            keywordWebtoonData.setSub_title("웹티&을코");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10839_1646707637.0069.png");
            keywordWebtoonData.setTitle("심야십담");
            keywordWebtoonData.setSub_title("시코르스키&천도담");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 3) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10806_1642490978.5388.jpg");
            keywordWebtoonData.setTitle("천일의 아내");
            keywordWebtoonData.setSub_title("0510&베리&죠이나");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10200_1550461930.3529.jpg");
            keywordWebtoonData.setTitle("프릭");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10300_1560234034.5599.jpg");
            keywordWebtoonData.setTitle("Mad:콜때기");
            keywordWebtoonData.setSub_title("고영훈&김찬영");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10634_1640604653.6298.jpg");
            keywordWebtoonData.setTitle("잘못 전한 편지");
            keywordWebtoonData.setSub_title("배뚱&생선찜");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10860_1646898197.8547.jpg");
            keywordWebtoonData.setTitle("낮에 뜨는 별");
            keywordWebtoonData.setSub_title("채은,고다고");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 5) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10838_1648718702.0184.jpg");
            keywordWebtoonData.setTitle("앙(怏)");
            keywordWebtoonData.setSub_title("김진수");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10859_1646896306.429.jpg");
            keywordWebtoonData.setTitle("불순한 동거동락");
            keywordWebtoonData.setSub_title("황한영,이룸");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10871_1648016636.5417.jpg");
            keywordWebtoonData.setTitle("무역: 운명을 거스르다");
            keywordWebtoonData.setSub_title("작은새우/일차원동만");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10870_1648016298.5089.jpg");
            keywordWebtoonData.setTitle("만고지존");
            keywordWebtoonData.setSub_title("태일생수/잭 노르웨이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10858_1646894514.7813.jpg");
            keywordWebtoonData.setTitle("그 남자의 계략");
            keywordWebtoonData.setSub_title("이채영,한우주");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 6) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10174_1574317553.4498.png");
            keywordWebtoonData.setTitle("동네 누나");
            keywordWebtoonData.setSub_title("타르초&견자");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10590_1612338793.8735.jpg");
            keywordWebtoonData.setTitle("당구장 사랑이");
            keywordWebtoonData.setSub_title("캄쟈&성백&옥충이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10563_1603689733.1208.jpg");
            keywordWebtoonData.setTitle("돈과 여자");
            keywordWebtoonData.setSub_title("김홍태&TB Production");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10541_1599189957.4919.jpg");
            keywordWebtoonData.setTitle("아내가 돌아왔다");
            keywordWebtoonData.setSub_title("양파&꼬붕");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10535_1596419741.0281.jpg");
            keywordWebtoonData.setTitle("고소한 여자");
            keywordWebtoonData.setSub_title("에일리언&frog");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 7) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10291_1558085744.2081.jpg");
            keywordWebtoonData.setTitle("사각사각 로맨스");
            keywordWebtoonData.setSub_title("말초코칩");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            keywordWebtoonData.setTitle("그녀, 윤희");
            keywordWebtoonData.setSub_title("병수씨");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10568_1604900784.8866.jpg");
            keywordWebtoonData.setTitle("속도위반 대표님과 계약 아내");
            keywordWebtoonData.setSub_title("Shuibuciyuan&kkworld&Flower");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8322_1496987995.183.jpg");
            keywordWebtoonData.setTitle("복수할까? 연애할까?");
            keywordWebtoonData.setSub_title("핑지");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        } else if (btnNo == 8) {
            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/5412_1580460555.8698.jpg");
            keywordWebtoonData.setTitle("편의점 샛별이");
            keywordWebtoonData.setSub_title("활화산&스기키 하루미");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/2631_1550797351.4958.jpg");
            keywordWebtoonData.setTitle("청소부K");
            keywordWebtoonData.setSub_title("신진우&홍순식");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/1345_1553841689.2188.jpg");
            keywordWebtoonData.setTitle("뽈쟁이 툰");
            keywordWebtoonData.setSub_title("뽈쟁이");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/10303_1559888119.0164.jpg");
            keywordWebtoonData.setTitle("음지킹");
            keywordWebtoonData.setSub_title("서영관");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);

            keywordWebtoonData = new KeywordWebtoonData();
            keywordWebtoonData.setImg("https://shtosebzjw.akamaized.net/assets/upfile/co_thumb10/8859_1501840279.2393.jpg");
            keywordWebtoonData.setTitle("그녀, 윤희");
            keywordWebtoonData.setSub_title("병수씨");
            keywordWebtoonDataArrayList.add(keywordWebtoonData);
        }

        recommandRecycleAdapter = new KeywordRecyclerViewAdapter(keywordWebtoonDataArrayList, getContext());
        recommandRecycle.setAdapter(recommandRecycleAdapter);
    }
}