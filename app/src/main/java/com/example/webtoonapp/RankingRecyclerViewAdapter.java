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
    private ArrayList<WebtoonData> webtoonDataArrayList;

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

    public RankingRecyclerViewAdapter(ArrayList<WebtoonData> data, Context context) {
        this.webtoonDataArrayList = data;
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
        WebtoonData webtoonData = webtoonDataArrayList.get(position);

        Glide.with(context)
                .load(webtoonData.getImg())
                .into(holder.sign);
        holder.rank.setText(webtoonData.getRank());
        holder.title.setText(webtoonData.getTitle());
        holder.subTitle.setText(webtoonData.getSub_title());
        holder.hit.setText(webtoonData.getHit());

    }

    @Override
    public int getItemCount() {
        return webtoonDataArrayList==null?0:webtoonDataArrayList.size();
    }


}
