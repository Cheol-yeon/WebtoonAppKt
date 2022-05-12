package com.example.webtoonapp

import android.content.Context
import com.example.webtoonapp.WebtoonData
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

class WebtoonRecyclerViewAdapter2(
    var webtoonDataArrayList: ArrayList<WebtoonData>?,
    var context: Context
) : RecyclerView.Adapter<WebtoonRecyclerViewAdapter2.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sign: ImageFilterView
        val title: TextView
        val subTitle: TextView

        init {
            sign = view.findViewById(R.id.iv_filterImage)
            title = view.findViewById(R.id.tv_filterImageTitle)
            subTitle = view.findViewById(R.id.tv_filterImageSubTitle)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.webtoon_recyclerview_item2, viewGroup, false)
        view.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            context.startActivity(intent)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val webtoonData = webtoonDataArrayList!![position]
        Glide.with(context)
            .load(webtoonData.img)
            .into(holder.sign)
        holder.title.text = webtoonData.title
        holder.subTitle.text = webtoonData.sub_title
    }

    override fun getItemCount(): Int {
        return if (webtoonDataArrayList == null) 0 else webtoonDataArrayList!!.size
    }
}