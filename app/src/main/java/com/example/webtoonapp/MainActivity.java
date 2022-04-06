package com.example.webtoonapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.fragment.app.FragmentTransaction;

import com.example.webtoonapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public Context context;
    ActivityMainBinding binding;
    MainFragment mainFragment;
    WeeklyFragment weeklyFragment;
    CompleteFragment completeFragment;

    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainFragment = new MainFragment();
        weeklyFragment = new WeeklyFragment();
        completeFragment = new CompleteFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(binding.flMain.getId(), mainFragment);
        transaction.commit();

        binding.ivLogo.setOnClickListener(this::onClick);

        binding.rbMenu1.setOnClickListener(this::onClick);
        binding.rbMenu2.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {

        if(view.getId() == binding.ivLogo.getId()) {
            binding.rbMenu1.setChecked(false);
            binding.rbMenu2.setChecked(false);
            binding.rbMenu3.setChecked(false);
            binding.rbMenu4.setChecked(false);
            binding.rbMenu5.setChecked(false);
            binding.rbMenu6.setChecked(false);
            binding.rbMenu7.setChecked(false);
            binding.rbMenu8.setChecked(false);
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(binding.flMain.getId(), mainFragment);
            transaction.commit();
        }

        if (view.getId() == binding.rbMenu1.getId()) {
            transaction = getSupportFragmentManager().beginTransaction();
            if (binding.rbMenu1.isChecked() == true) {
                binding.rbMenu2.setChecked(false);
                binding.rbMenu3.setChecked(false);
                binding.rbMenu4.setChecked(false);
                binding.rbMenu5.setChecked(false);
                binding.rbMenu6.setChecked(false);
                binding.rbMenu7.setChecked(false);
                binding.rbMenu8.setChecked(false);
                transaction.replace(binding.flMain.getId(), weeklyFragment);
                transaction.commit();
            }
        } else if (view.getId() == binding.rbMenu2.getId()) {
            transaction = getSupportFragmentManager().beginTransaction();
            if (binding.rbMenu2.isChecked() == true) {
                binding.rbMenu1.setChecked(false);
                binding.rbMenu3.setChecked(false);
                binding.rbMenu4.setChecked(false);
                binding.rbMenu5.setChecked(false);
                binding.rbMenu6.setChecked(false);
                binding.rbMenu7.setChecked(false);
                binding.rbMenu8.setChecked(false);
                transaction.replace(binding.flMain.getId(), completeFragment);
                transaction.commit();
            }


        }
    }
}