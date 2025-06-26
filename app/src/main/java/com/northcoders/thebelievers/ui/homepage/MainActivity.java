package com.northcoders.thebelievers.ui.homepage;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityMainBinding;
import com.northcoders.thebelievers.model.TheBelieverRepository;
import com.northcoders.thebelievers.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityClickHandler clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);
        /*SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        if (prefs.getBoolean("dark_mode", false)) {
            darkMode();
        } else {
            lightMode();
        }*/
    }

    @Override
    protected void applyDarkMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this, R.color.brown));
        ((TextView)findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this, R.color.cream));
        findViewById(R.id.prayerTimesButton).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
        findViewById(R.id.ReminderButton).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
        findViewById(R.id.SettingsButton).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
        findViewById(R.id.QuranButton).setBackground(getDrawable(R.drawable.rectangle_dark_mode));
    }

    @Override
    protected void applyLightMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this, R.color.cream));
        ((TextView)findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this, R.color.brown));
        findViewById(R.id.prayerTimesButton).setBackground(getDrawable(R.drawable.rectangle));
        findViewById(R.id.ReminderButton).setBackground(getDrawable(R.drawable.rectangle));
        findViewById(R.id.SettingsButton).setBackground(getDrawable(R.drawable.rectangle));
        findViewById(R.id.QuranButton).setBackground(getDrawable(R.drawable.rectangle));

    }
}