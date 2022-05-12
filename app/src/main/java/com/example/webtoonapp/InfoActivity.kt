package com.example.webtoonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    AppCompatTextView org_coin;
    ImageFilterView icon_back;
    RecyclerView infoRecyclerview;
    RecyclerView.LayoutManager infoRecyclerviewlayoutManager;
    RecyclerView.Adapter infoRecyclerviewAdapter;

    WebtoonEpisodeData webtoonEpisodeData;
    ArrayList<WebtoonEpisodeData> webtoonEpisodeDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        org_coin = findViewById(R.id.tv_org_coin);
        icon_back = findViewById(R.id.iv_icon_back);
        infoRecyclerview = findViewById(R.id.rv_infoWebtoonlist);

        org_coin.setPaintFlags(org_coin.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        icon_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String title = "편의점 샛별이";

        infoRecyclerview.setHasFixedSize(true);
        infoRecyclerviewlayoutManager = new LinearLayoutManager(this);
        infoRecyclerview.setLayoutManager(infoRecyclerviewlayoutManager);

        getData(title);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void getData(String title) {
        webtoonEpisodeDataArrayList = new ArrayList<>();

        for(int i=0; i<10; i++) {
            webtoonEpisodeData = new WebtoonEpisodeData();
            webtoonEpisodeData.setThumbnail1("https://shtosebzjw.akamaized.net/assets/upfile/ep_thumb2/5412_112522_1578979220.2275.jpg");
            webtoonEpisodeData.setThumbnail2("https://shtosebzjw.akamaized.net/assets/upfile/ep_thumb3/5412_112522_1578979220.2337.jpg");
            webtoonEpisodeData.setEpisode_title("제1화");
            webtoonEpisodeData.setEpisode_stitle("첫 만남, 첫 키스(?)");
            webtoonEpisodeData.setEpisode_date("16.08.27");
            webtoonEpisodeDataArrayList.add(webtoonEpisodeData);
        }

        infoRecyclerviewAdapter = new EpidoseRecyclerViewAdapter(webtoonEpisodeDataArrayList, this);
        infoRecyclerview.setAdapter(infoRecyclerviewAdapter);
    }
}