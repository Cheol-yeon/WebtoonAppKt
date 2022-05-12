package com.example.webtoonapp

import android.content.Context
import com.example.webtoonapp.RankingWebtoonData
import androidx.recyclerview.widget.RecyclerView
import androidx.constraintlayout.utils.widget.ImageFilterView
import android.widget.TextView
import com.example.webtoonapp.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Intent
import android.view.View
import com.example.webtoonapp.InfoActivity
import com.bumptech.glide.Glide
import java.util.ArrayList

class RankingRecyclerViewAdapter(
    private val rankingWebtoonDataArrayList: ArrayList<RankingWebtoonData>?,
    private val context: Context
) : RecyclerView.Adapter<RankingRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sign: ImageFilterView
        val rank: TextView
        val title: TextView
        val subTitle: TextView
        val hit: TextView

        init {
            sign = view.findViewById(R.id.iv_sign)
            rank = view.findViewById(R.id.tv_rank)
            title = view.findViewById(R.id.tv_webtoonTitle)
            subTitle = view.findViewById(R.id.tv_webtoonSubTitle)
            hit = view.findViewById(R.id.tv_hit)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ranking_viewpager_item, viewGroup, false)
        view.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            context.startActivity(intent)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rankingWebtoonData = rankingWebtoonDataArrayList!![position]
        Glide.with(context)
            .load(rankingWebtoonData.img)
            .into(holder.sign)
        holder.rank.text = rankingWebtoonData.rank
        holder.title.text = rankingWebtoonData.title
        holder.subTitle.text = rankingWebtoonData.sub_title
        holder.hit.text = rankingWebtoonData.hit
    }

    override fun getItemCount(): Int {
        return rankingWebtoonDataArrayList?.size ?: 0
    }
}