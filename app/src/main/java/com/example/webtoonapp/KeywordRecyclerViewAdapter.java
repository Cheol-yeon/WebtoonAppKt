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

public class KeywordRecyclerViewAdapter extends RecyclerView.Adapter<KeywordRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<KeywordWebtoonData> keywordWebtoonDataArrayList;

    public KeywordRecyclerViewAdapter(ArrayList<KeywordWebtoonData> keywordWebtoonDataArrayList, Context context) {
        this.context = context;
        this.keywordWebtoonDataArrayList = keywordWebtoonDataArrayList;
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
    public KeywordRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.keyword_recyclerview_item, viewGroup, false);
        return new KeywordRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordRecyclerViewAdapter.ViewHolder holder, int position) {
        KeywordWebtoonData keywordWebtoonData = keywordWebtoonDataArrayList.get(position);

        Glide.with(context)
                .load(keywordWebtoonData.getImg())
                .into(holder.sign);
        holder.title.setText(keywordWebtoonData.getTitle());
        holder.subTitle.setText(keywordWebtoonData.getSub_title());
    }

    @Override
    public int getItemCount() {
        return keywordWebtoonDataArrayList == null ? 0 : keywordWebtoonDataArrayList.size();
    }
}
