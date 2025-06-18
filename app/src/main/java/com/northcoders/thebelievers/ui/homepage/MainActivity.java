package com.northcoders.thebelievers.ui.homepage;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityMainBinding;
import com.northcoders.thebelievers.model.TheBelieverRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityClickHandler clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);
    }
}