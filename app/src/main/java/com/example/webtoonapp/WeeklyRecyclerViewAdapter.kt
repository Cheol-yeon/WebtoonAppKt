package com.example.webtoonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WeeklyRecyclerViewAdapter extends RecyclerView.Adapter<WeeklyRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<WeeklyWebtoonData> weeklyWebtoonDatas;

    public WeeklyRecyclerViewAdapter(ArrayList<WeeklyWebtoonData> weeklyWebtoonDatas, Context context) {
        this.context = context;
        this.weeklyWebtoonDatas = weeklyWebtoonDatas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageFilterView thumb1, thumb2, thumb3;
        private AppCompatTextView title1, sub_title1, hit1;


        public ViewHolder(@NonNull View view) {
            super(view);
            thumb1 = view.findViewById(R.id.iv_weeklyThumb1);
            title1 = view.findViewById(R.id.tv_weeklyTitle1);
            sub_title1 = view.findViewById(R.id.tv_weeklySubtitle1);
            hit1 = view.findViewById(R.id.tv_weeklyHit1);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.webtoon_weekly_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        WeeklyWebtoonData weeklyWebtoonData = weeklyWebtoonDatas.get(position);

        Glide.with(context)
                .load(weeklyWebtoonData.getImg())
                .into(holder.thumb1);
        holder.title1.setText(weeklyWebtoonData.getTitle());
        holder.sub_title1.setText(weeklyWebtoonData.getSubTitle());
        holder.hit1.setText(weeklyWebtoonData.getHit());

    }

    @Override
    public int getItemCount() {
        return weeklyWebtoonDatas == null ? 0 : weeklyWebtoonDatas.size();
    }


}
