package com.northcoders.thebelievers.ui.prayer_times;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityPrayerTimesBinding;
import com.northcoders.thebelievers.model.PrayerTimes;
import com.northcoders.thebelievers.model.TheBelieverRepository;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

public class PrayerTimesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prayer_times);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        ActivityPrayerTimesBinding prayerTimesBinding = DataBindingUtil.setContentView(this,R.layout.activity_prayer_times);
        viewModel.getPrayerTimes().observe(this, prayerTimes -> {
            if(prayerTimes != null){
                PrayerTimesClickHandler clickHandler = new PrayerTimesClickHandler(this,prayerTimes,this,viewModel,prayerTimesBinding);
                prayerTimesBinding.setClickHandler(clickHandler);
                prayerTimesBinding.setPrayerTimes(prayerTimes);
            }
            else{
                Toast.makeText(this.getApplicationContext(),"Prayer Times Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}