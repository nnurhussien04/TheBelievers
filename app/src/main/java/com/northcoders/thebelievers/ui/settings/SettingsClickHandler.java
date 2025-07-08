package com.northcoders.thebelievers.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.ui.homepage.MainActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

public class SettingsClickHandler {
    private Context context;
    private SettingsActivity settingsActivity;
    private MainActivityViewModel viewModel;

    public SettingsClickHandler(Context context,SettingsActivity settingsActivity,MainActivityViewModel viewModel) {
        this.context = context;
        this.settingsActivity = settingsActivity;
        this.viewModel = viewModel;
    }

    public void darkModeButton(View view) {
        SharedPreferences prefs = view.getContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        boolean isDarkMode = prefs.getBoolean("dark_mode", false);
        prefs.edit().putBoolean("dark_mode", !isDarkMode).apply();
        settingsActivity.recreate();
    }

    public void submitFeedback(View view){
        TextView textView = settingsActivity.findViewById(R.id.ContactUsText);
        viewModel.setFeedback(textView.getText().toString());
        textView.setText("");
    }



}
