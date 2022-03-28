package com.example.webtoonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class bannerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Integer> bannerImage;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_main, null);

        ViewPager2 viewPager2 = view.findViewById(R.id.vp2_banner);
        viewPager2.setBackgroundResource(bannerImage.get(position));

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return bannerImage.size();
    }

    public bannerAdapter(Context context, ArrayList<Integer> bannerImage) {
        this.mContext = context;
        this.bannerImage = bannerImage;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
