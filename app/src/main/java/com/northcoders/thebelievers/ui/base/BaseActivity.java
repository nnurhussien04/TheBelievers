package com.northcoders.thebelievers.ui.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected boolean isDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        isDarkMode = prefs.getBoolean("dark_mode", false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isDarkMode) {
            applyDarkMode();
        } else {
            applyLightMode();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean latestMode = prefs.getBoolean("dark_mode", false);
        if (latestMode != isDarkMode) {
            isDarkMode = latestMode;
            recreate(); // triggers onCreate → onStart with correct mode
        }
    }


    protected abstract void applyDarkMode();
    protected abstract void applyLightMode();
}

