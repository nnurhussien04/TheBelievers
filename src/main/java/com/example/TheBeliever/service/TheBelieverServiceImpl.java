package com.example.TheBeliever.service;

import com.example.TheBeliever.model.PrayerTimes;
import com.example.TheBeliever.model.Quran;
import com.example.TheBeliever.model.Reminder;
import com.example.TheBeliever.repository.ReminderRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheBelieverServiceImpl implements TheBelieverService {

    @Autowired
    ReminderRepository reminderRepository;

    @Override
    public PrayerTimes getPrayerTimes() {
        String BASE_URL = "https://www.londonprayertimes.com/api/times/";
        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
        String prayerTimesFormat =
                webClient.get().uri(
                        uri -> uri
                                    .queryParam("format","json")
                                    .queryParam("key","7b88413e-4e2c-4193-bde3-dfd6f793feb8")
                                    .queryParam("24hours","true")
                                    .build()

                )
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        Gson gson = new Gson();
        PrayerTimes prayerTimes = gson.fromJson(prayerTimesFormat, PrayerTimes.class);
        return prayerTimes;
    }

    @Override
    public PrayerTimes getPrayerTimes(String date) {
        String BASE_URL = "https://www.londonprayertimes.com/api/times/";
        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
        String prayerTimesFormat =
                webClient.get().uri(
                                uri -> uri
                                        .queryParam("format","json")
                                        .queryParam("key","7b88413e-4e2c-4193-bde3-dfd6f793feb8")
                                        .queryParam("date",date)
                                        .queryParam("24hours","true")
                                        .build()

                        )
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        Gson gson = new Gson();
        PrayerTimes prayerTimes = gson.fromJson(prayerTimesFormat, PrayerTimes.class);
        return prayerTimes;
    }

    @Override
    public List<Reminder> getAllReminders() {
        List<Reminder> reminders = new ArrayList<>();
        reminderRepository.findAll().forEach(reminders::add);
        return reminders;
    }

    @Override
    public Reminder addReminders(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public List<Quran> getQuranAPI() {
        String BASE_URL = "https://quranapi.pages.dev/api/surah.json";
        WebClient webClient = WebClient.builder().build();
        String quranFormat =
                webClient.get()
                        .uri(BASE_URL)
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        Gson gson = new Gson();
        TypeToken<List<Quran>> token = new TypeToken<>(){};
        List<Quran> quranList = gson.fromJson(quranFormat, token.getType());
        return quranList;
    }


}
