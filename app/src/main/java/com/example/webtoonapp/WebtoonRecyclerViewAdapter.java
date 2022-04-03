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

public class WebtoonRecyclerViewAdapter extends RecyclerView.Adapter<WebtoonRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<WebtoonData> webtoonDataArrayList;

    public WebtoonRecyclerViewAdapter(ArrayList<WebtoonData> webtoonDataArrayList, Context context) {
        this.context = context;
        this.webtoonDataArrayList = webtoonDataArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageFilterView sign;
        private TextView title, subTitle;

        public ViewHolder(@NonNull View view) {
            super(view);
            sign = view.findViewById(R.id.iv_filterImage);
            title = view.findViewById(R.id.tv_filterImageTitle);
            subTitle = view.findViewById(R.id.tv_filterImageSubTitle);
        }
    }

    @NonNull
    @Override
    public WebtoonRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.keyword_recyclerview_item, viewGroup, false);
        return new WebtoonRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebtoonRecyclerViewAdapter.ViewHolder holder, int position) {
        WebtoonData webtoonData = webtoonDataArrayList.get(position);

        Glide.with(context)
                .load(webtoonData.getImg())
                .into(holder.sign);
        holder.title.setText(webtoonData.getTitle());
        holder.subTitle.setText(webtoonData.getSub_title());
    }

    @Override
    public int getItemCount() {
        return webtoonDataArrayList == null ? 0 : webtoonDataArrayList.size();
    }
}
