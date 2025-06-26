package com.northcoders.thebelievers.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.ui.homepage.MainActivity;

public class SettingsClickHandler {
    private Context context;
    private SettingsActivity settingsActivity;

    public SettingsClickHandler(Context context,SettingsActivity settingsActivity) {
        this.context = context;
        this.settingsActivity = settingsActivity;
    }

    public void darkModeButton(View view) {
        SharedPreferences prefs = view.getContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        boolean isDarkMode = prefs.getBoolean("dark_mode", false);
        prefs.edit().putBoolean("dark_mode", !isDarkMode).apply();
        settingsActivity.recreate();

    }



}
