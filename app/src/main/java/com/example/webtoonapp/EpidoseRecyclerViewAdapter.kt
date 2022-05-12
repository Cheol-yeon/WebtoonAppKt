package com.example.webtoonapp

import android.content.Context
import com.example.webtoonapp.WebtoonEpisodeData
import androidx.recyclerview.widget.RecyclerView
import androidx.constraintlayout.utils.widget.ImageFilterView
import android.widget.TextView
import com.example.webtoonapp.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import java.util.ArrayList

class EpidoseRecyclerViewAdapter(
    var webtoonEpisodeDataArrayList: ArrayList<WebtoonEpisodeData>?,
    var context: Context
) : RecyclerView.Adapter<EpidoseRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail1: ImageFilterView
        val thumbnail2: ImageFilterView
        val ep_title: TextView
        val ep_subTitle: TextView
        val ep_date: TextView

        init {
            thumbnail1 = view.findViewById(R.id.iv_thumbnail1)
            thumbnail2 = view.findViewById(R.id.iv_thumbnail2)
            ep_title = view.findViewById(R.id.tv_ep_title)
            ep_subTitle = view.findViewById(R.id.tv_ep_stitle)
            ep_date = view.findViewById(R.id.tv_ep_date)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.webtoonepisode_recyclerview_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val webtoonEpisodeData = webtoonEpisodeDataArrayList!![position]
        Glide.with(context)
            .load(webtoonEpisodeData.thumbnail1)
            .into(holder.thumbnail1)
        Glide.with(context)
            .load(webtoonEpisodeData.thumbnail2)
            .into(holder.thumbnail2)
        holder.ep_title.text = webtoonEpisodeData.episode_title
        holder.ep_subTitle.text = webtoonEpisodeData.episode_stitle
        holder.ep_date.text = webtoonEpisodeData.episode_date
    }

    override fun getItemCount(): Int {
        return if (webtoonEpisodeDataArrayList == null) 0 else webtoonEpisodeDataArrayList!!.size
    }
}