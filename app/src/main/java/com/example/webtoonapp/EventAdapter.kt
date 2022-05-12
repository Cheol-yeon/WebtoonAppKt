package com.example.webtoonapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.webtoonapp.R
import com.bumptech.glide.Glide

class EventAdapter(private val context: Context, private val sliderImage: Array<String>) :
    RecyclerView.Adapter<EventAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_viewpager_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        int index = position % sliderImage.length;
        holder.bindSliderImage(sliderImage[position])
        //        if (position % 2 == 0) {
//            holder.bindSliderImage(sliderImage[index]);
//        } else {
//            holder.bindSliderImage(sliderImage[index]);
//        }
    }

    override fun getItemCount(): Int {
        return sliderImage.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mImageView: ImageView
        fun bindSliderImage(imageURL: String?) {
            Glide.with(context)
                .load(imageURL)
                .into(mImageView)
        }

        init {
            mImageView = itemView.findViewById(R.id.iv_bannerItem)
        }
    }
}