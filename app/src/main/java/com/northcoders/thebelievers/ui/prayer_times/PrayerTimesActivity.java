package com.northcoders.thebelievers.ui.prayer_times;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityPrayerTimesBinding;
import com.northcoders.thebelievers.model.PrayerTimes;
import com.northcoders.thebelievers.model.TheBelieverRepository;
import com.northcoders.thebelievers.ui.base.BaseActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

public class PrayerTimesActivity extends BaseActivity {

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

    @Override
    protected void applyDarkMode() {
        int cream = ContextCompat.getColor(this,R.color.cream);
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.brown));
        ((TextView) findViewById(R.id.title)).setTextColor(cream);
        ((TextView) findViewById(R.id.dateView)).setTextColor(cream);
        ((Button) findViewById(R.id.decreaseDate)).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
        ((Button) findViewById(R.id.increaseDate)).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
        int[] layouts = {R.id.fajrLayout,R.id.sunriseLayout,R.id.zuhrLayout,R.id.asrLayout,R.id.maghribLayout,R.id.ishaLayout};
        for(int layout:layouts){
            ((ConstraintLayout) findViewById(layout)).setBackground(getDrawable(R.drawable.outline_dark_mode));
        }
        int [] texts = {R.id.fajrLabel,R.id.fajrTimeLabel,R.id.sunriseLabel,R.id.sunriseTimeLabel,R.id.zuhrLabel,R.id.zuhrTimeLabel,R.id.asrLabel,R.id.asrTimeLabel,R.id.maghribLabel,R.id.maghribTimeLabel,R.id.ishaLabel,R.id.ishaTimeLabel};
        for(int text:texts){
            ((TextView) findViewById(text)).setTextColor(ContextCompat.getColor(this,R.color.cream));
        }


    }

    @Override
    protected void applyLightMode() {
        int brown = ContextCompat.getColor(this,R.color.brown);
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.cream));
        ((TextView) findViewById(R.id.title)).setTextColor(brown);
        ((TextView) findViewById(R.id.dateView)).setTextColor(brown);
        ((Button) findViewById(R.id.decreaseDate)).setBackground(getDrawable(R.drawable.rectangle));
        ((Button) findViewById(R.id.increaseDate)).setBackground(getDrawable(R.drawable.rectangle));
        int[] layouts = {R.id.fajrLayout,R.id.sunriseLayout,R.id.zuhrLayout,R.id.asrLayout,R.id.maghribLayout,R.id.ishaLayout};
        for(int layout:layouts){
            ((ConstraintLayout) findViewById(layout)).setBackground(getDrawable(R.drawable.outline));
        }
        int [] texts = {R.id.fajrLabel,R.id.fajrTimeLabel,R.id.sunriseLabel,R.id.sunriseTimeLabel,R.id.zuhrLabel,R.id.zuhrTimeLabel,R.id.asrLabel,R.id.asrTimeLabel,R.id.maghribLabel,R.id.maghribTimeLabel,R.id.ishaLabel,R.id.ishaTimeLabel};
        for(int text:texts){
            ((TextView) findViewById(text)).setTextColor(ContextCompat.getColor(this,R.color.brown));
        }
    }
}