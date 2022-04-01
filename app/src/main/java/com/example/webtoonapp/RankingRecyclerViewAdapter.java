package com.example.webtoonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RankingRecyclerViewAdapter extends RecyclerView.Adapter<RankingRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RankingWebtoonData> rankingWebtoonDataArrayList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageFilterView sign;
        private TextView rank, title, subTitle, hit;

        public ViewHolder(@NonNull View view) {
            super(view);
            sign = view.findViewById(R.id.iv_sign);
            rank = view.findViewById(R.id.tv_rank);
            title = view.findViewById(R.id.tv_webtoonTitle);
            subTitle = view.findViewById(R.id.tv_webtoonSubTitle);
            hit = view.findViewById(R.id.tv_hit);
        }
    }

    public RankingRecyclerViewAdapter(ArrayList<RankingWebtoonData> data, Context context) {
        this.rankingWebtoonDataArrayList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RankingRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ranking_viewpager_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingRecyclerViewAdapter.ViewHolder holder, int position) {
        RankingWebtoonData rankingWebtoonData = rankingWebtoonDataArrayList.get(position);

        Glide.with(context)
                .load(rankingWebtoonData.getImg())
                .into(holder.sign);
        holder.rank.setText(rankingWebtoonData.getRank());
        holder.title.setText(rankingWebtoonData.getTitle());
        holder.subTitle.setText(rankingWebtoonData.getSub_title());
        holder.hit.setText(rankingWebtoonData.getHit());

    }

    @Override
    public int getItemCount() {
        return rankingWebtoonDataArrayList ==null?0: rankingWebtoonDataArrayList.size();
    }


}
