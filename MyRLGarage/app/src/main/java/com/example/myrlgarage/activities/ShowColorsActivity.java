package com.example.myrlgarage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myrlgarage.databinding.ActivityShowColorsBinding;

public class ShowColorsActivity extends AppCompatActivity {

    ActivityShowColorsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowColorsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.dropdownBlueBtn.setOnClickListener(v -> showBlueColors());
        binding.dropdownOrangeBtn.setOnClickListener(v -> showOrangeColors());
        binding.dropdownAccentBtn.setOnClickListener(v -> showAccentColors());
    }

    void showBlueColors(){
        binding.blueImg.setVisibility(View.VISIBLE);
        binding.orangeImg.setVisibility(View.GONE);
        binding.accentImg.setVisibility(View.GONE);
        binding.dropdownBlueBtn.setRotation(90);
        binding.dropdownOrangeBtn.setRotation(0);
        binding.dropdownAccentBtn.setRotation(0);
    }

    void showOrangeColors(){
        binding.blueImg.setVisibility(View.GONE);
        binding.orangeImg.setVisibility(View.VISIBLE);
        binding.accentImg.setVisibility(View.GONE);
        binding.dropdownBlueBtn.setRotation(0);
        binding.dropdownOrangeBtn.setRotation(90);
        binding.dropdownAccentBtn.setRotation(0);
    }

    void showAccentColors(){
        binding.blueImg.setVisibility(View.GONE);
        binding.orangeImg.setVisibility(View.GONE);
        binding.accentImg.setVisibility(View.VISIBLE);
        binding.dropdownBlueBtn.setRotation(0);
        binding.dropdownOrangeBtn.setRotation(0);
        binding.dropdownAccentBtn.setRotation(90);
    }
}