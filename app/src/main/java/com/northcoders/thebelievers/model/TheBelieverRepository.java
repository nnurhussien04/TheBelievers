package com.northcoders.thebelievers.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.thebelievers.service.RetrofitInstance;
import com.northcoders.thebelievers.service.TheBelieverAPIService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheBelieverRepository {
    private MutableLiveData<PrayerTimes> prayerTimesMutableLiveData = new MutableLiveData<>();

    private Application application;

    public TheBelieverRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<PrayerTimes> getPrayerTimesMutableLiveData() {
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<PrayerTimes> prayerTimesCall = service.getPrayerTimes();
        prayerTimesCall.enqueue(new Callback<PrayerTimes>() {
            @Override
            public void onResponse(Call<PrayerTimes> call, Response<PrayerTimes> response) {
                if(!response.isSuccessful()){
                    try {
                        Log.d("PrayerTimesError", "onFailure: " + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else{
                    prayerTimesMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PrayerTimes> call, Throwable t) {
                Log.d("PrayerTimesError", "onFailure: " + t.getMessage());
            }
        });
        return prayerTimesMutableLiveData;
    }
}
