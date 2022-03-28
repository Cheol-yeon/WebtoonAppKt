package com.example.webtoonapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.webtoonapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public Context context;
    ActivityMainBinding binding;
    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainFragment = new MainFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(binding.flMain.getId(), mainFragment);
        transaction.commit();

    }
}