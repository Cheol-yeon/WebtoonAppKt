package com.example.webtoonapp

import android.content.Context
import com.example.webtoonapp.WeeklyWebtoonData
import androidx.recyclerview.widget.RecyclerView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.appcompat.widget.AppCompatTextView
import com.example.webtoonapp.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import java.util.ArrayList

class WeeklyRecyclerViewAdapter(
    var weeklyWebtoonDatas: ArrayList<WeeklyWebtoonData>?,
    var context: Context
) : RecyclerView.Adapter<WeeklyRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumb1: ImageFilterView
        private val thumb2: ImageFilterView? = null
        private val thumb3: ImageFilterView? = null
        val title1: AppCompatTextView
        val sub_title1: AppCompatTextView
        val hit1: AppCompatTextView

        init {
            thumb1 = view.findViewById(R.id.iv_weeklyThumb1)
            title1 = view.findViewById(R.id.tv_weeklyTitle1)
            sub_title1 = view.findViewById(R.id.tv_weeklySubtitle1)
            hit1 = view.findViewById(R.id.tv_weeklyHit1)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.webtoon_weekly_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weeklyWebtoonData = weeklyWebtoonDatas!![position]
        Glide.with(context)
            .load(weeklyWebtoonData.img)
            .into(holder.thumb1)
        holder.title1.text = weeklyWebtoonData.title
        holder.sub_title1.text = weeklyWebtoonData.subTitle
        holder.hit1.text = weeklyWebtoonData.hit
    }

    override fun getItemCount(): Int {
        return if (weeklyWebtoonDatas == null) 0 else weeklyWebtoonDatas!!.size
    }
}