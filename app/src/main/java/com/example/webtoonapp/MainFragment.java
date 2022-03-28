package com.example.webtoonapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoonapp.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    ArrayList<Integer> bannerImage;
    Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeBanner();

        PagerAdapter adapter = new bannerAdapter(getActivity(), bannerImage);

        binding.vp2Banner.setClipToPadding(false);
        binding.vp2Banner.setAdapter(adapter);



    }

    public void initializeBanner() {
        bannerImage = new ArrayList<>();

        bannerImage.add(R.drawable.first_banner);
        bannerImage.add(R.drawable.first_banner);
        bannerImage.add(R.drawable.first_banner);
        bannerImage.add(R.drawable.first_banner);
        bannerImage.add(R.drawable.first_banner);
    }
}