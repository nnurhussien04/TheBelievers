package com.northcoders.thebelievers.service;

import com.northcoders.thebelievers.model.PrayerTimes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheBelieverAPIService {

    @GET("prayer_times")
    Call<PrayerTimes> getPrayerTimes();

}
