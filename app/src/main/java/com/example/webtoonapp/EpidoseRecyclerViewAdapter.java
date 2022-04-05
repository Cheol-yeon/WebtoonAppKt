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

public class EpidoseRecyclerViewAdapter extends RecyclerView.Adapter<EpidoseRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<WebtoonEpisodeData> webtoonEpisodeDataArrayList;

    public EpidoseRecyclerViewAdapter(ArrayList<WebtoonEpisodeData> webtoonEpisodeDataArrayList, Context context) {
        this.context = context;
        this.webtoonEpisodeDataArrayList = webtoonEpisodeDataArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageFilterView thumbnail1, thumbnail2;
        private TextView ep_title, ep_subTitle, ep_date;

        public ViewHolder(@NonNull View view) {
            super(view);

            thumbnail1 = view.findViewById(R.id.iv_thumbnail1);
            thumbnail2 = view.findViewById(R.id.iv_thumbnail2);
            ep_title = view.findViewById(R.id.tv_ep_title);
            ep_subTitle = view.findViewById(R.id.tv_ep_stitle);
            ep_date = view.findViewById(R.id.tv_ep_date);

        }
    }

    @NonNull
    @Override
    public EpidoseRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.webtoonepisode_recyclerview_item, viewGroup, false);
        return new EpidoseRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpidoseRecyclerViewAdapter.ViewHolder holder, int position) {
        WebtoonEpisodeData webtoonEpisodeData = webtoonEpisodeDataArrayList.get(position);

        Glide.with(context)
                .load(webtoonEpisodeData.getThumbnail1())
                .into(holder.thumbnail1);

        Glide.with(context)
                .load(webtoonEpisodeData.getThumbnail2())
                .into(holder.thumbnail2);

        holder.ep_title.setText(webtoonEpisodeData.getEpisode_title());
        holder.ep_subTitle.setText(webtoonEpisodeData.getEpisode_stitle());
        holder.ep_date.setText(webtoonEpisodeData.getEpisode_date());
    }

    @Override
    public int getItemCount() {
        return webtoonEpisodeDataArrayList == null ? 0 : webtoonEpisodeDataArrayList.size();
    }
}
