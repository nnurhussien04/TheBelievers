package com.northcoders.thebelievers.ui.homepage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.thebelievers.QuranActivity;
import com.northcoders.thebelievers.ReminderActivity;
import com.northcoders.thebelievers.SettingsActivity;
import com.northcoders.thebelievers.ui.prayer_times.PrayerTimesActivity;

public class MainActivityClickHandler {

    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void clickForPrayerTimes(View view){
        Intent intent = new Intent(context, PrayerTimesActivity.class);
        context.startActivity(intent);
    }

    public void clickForQuran(View view){
        Intent intent = new Intent(context, QuranActivity.class);
        context.startActivity(intent);
    }

    public void clickForSettings(View view){
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

    public void clickForReminder(View view){
        Intent intent = new Intent(context, ReminderActivity.class);
        context.startActivity(intent);
    }




}
