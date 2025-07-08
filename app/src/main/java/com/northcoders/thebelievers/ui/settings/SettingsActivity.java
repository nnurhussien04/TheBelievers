package com.northcoders.thebelievers.ui.settings;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivitySettingsBinding;
import com.northcoders.thebelievers.ui.base.BaseActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

public class SettingsActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        SettingsClickHandler clickHandler = new SettingsClickHandler(this,this,viewModel);
        ActivitySettingsBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_settings);
        binding.setClickHandler(clickHandler);

    }





    @Override
    protected void applyDarkMode() {
        int cream = ContextCompat.getColor(this, R.color.cream);
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this, R.color.brown));
        int[] id = {R.id.title,R.id.appearanceText,R.id.title,R.id.lightDarkText,R.id.aboutUsHeader,R.id.appVersion,R.id.versionInfo,R.id.creditsText,R.id.creditsInfo,R.id.contactHeader};

        Button lightDarkModeButton = findViewById(R.id.lightDarkModeButton);
        lightDarkModeButton.setBackgroundColor(cream);
        lightDarkModeButton.setText("Light");
        lightDarkModeButton.setTextColor(ContextCompat.getColor(this, R.color.brown));
        lightDarkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyLightMode();
            }
        });

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setBackgroundColor(cream);
        submitButton.setTextColor(ContextCompat.getColor(this, R.color.brown));

        for(int view:id){
            ((TextView) findViewById(view)).setTextColor(cream);
        }


    }

    @Override
    protected void applyLightMode() {
        int brown = ContextCompat.getColor(this, R.color.brown);
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this, R.color.cream));
        int[] id = {R.id.title,R.id.appearanceText,R.id.title,R.id.lightDarkText,R.id.aboutUsHeader,R.id.appVersion,R.id.versionInfo,R.id.creditsText,R.id.creditsInfo,R.id.contactHeader};
        Button lightDarkModeButton = findViewById(R.id.lightDarkModeButton);
        lightDarkModeButton.setBackgroundColor(brown);
        lightDarkModeButton.setText("Dark");
        lightDarkModeButton.setTextColor(ContextCompat.getColor(this, R.color.cream));
        lightDarkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyDarkMode();
            }
        });

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setBackgroundColor(brown);
        submitButton.setTextColor(ContextCompat.getColor(this, R.color.cream));

        for(int view:id){
            ((TextView) findViewById(view)).setTextColor(brown);
        }


    }

}