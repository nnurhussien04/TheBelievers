package com.northcoders.thebelievers.ui.prayer_times;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityPrayerTimesBinding;
import com.northcoders.thebelievers.model.PrayerTimes;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PrayerTimesClickHandler {
    private Context context;
    private PrayerTimes prayerTimes;
    private PrayerTimesActivity prayerTimesActivity;
    private MainActivityViewModel viewModel;

    private ActivityPrayerTimesBinding binding;


    public PrayerTimesClickHandler(Context context, PrayerTimes prayerTimes, PrayerTimesActivity prayerTimesActivity, MainActivityViewModel viewModel, ActivityPrayerTimesBinding binding) {
        this.context = context;
        this.prayerTimes = prayerTimes;
        this.prayerTimesActivity = prayerTimesActivity;
        this.viewModel = viewModel;
        this.binding = binding;
    }

    public void increaseDecreaseDay(int numValue) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date;
        try {
            date = inputFormat.parse(prayerTimes.getDate());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, numValue);

            String newDate = inputFormat.format(calendar.getTime());
            prayerTimes.setDate(newDate);
            TextView textView = prayerTimesActivity.findViewById(R.id.dateView);
            textView.setText(prayerTimes.dateFormatted());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        viewModel.getPrayerTimes(prayerTimes.getDate()).observe(prayerTimesActivity,prayerTimes -> {
                    if(prayerTimes != null){
                        binding.setPrayerTimes(prayerTimes);
                        binding.setClickHandler(this);
                    } else{
                        Toast.makeText(context,"Prayer Times Failed",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void dayForward(View view){
        increaseDecreaseDay(1);
    }

    public void dayReverse(View view){
        increaseDecreaseDay(-1);
    }
}
