package com.northcoders.thebelievers.service;

import com.northcoders.thebelievers.model.PrayerTimes;
import com.northcoders.thebelievers.model.Quran;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheBelieverAPIService {

    @GET("prayer_times")
    Call<PrayerTimes> getPrayerTimes();

    @GET("prayer_times/{date}")
    Call<PrayerTimes> getPrayerTimes(@Path("date") String date);

    @GET("quran")
    Call<List<Quran>> getQuran();


}
