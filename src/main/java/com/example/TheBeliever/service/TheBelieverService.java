package com.example.TheBeliever.service;

import com.example.TheBeliever.model.PrayerTimes;
import com.example.TheBeliever.model.Quran;
import com.example.TheBeliever.model.Reminder;

import java.util.List;

public interface TheBelieverService {
    PrayerTimes getPrayerTimes();
    PrayerTimes getPrayerTimes(String date);
    List<Reminder> getAllReminders();
    Reminder addReminders(Reminder reminder);
    List<Quran> getQuranAPI();

}
