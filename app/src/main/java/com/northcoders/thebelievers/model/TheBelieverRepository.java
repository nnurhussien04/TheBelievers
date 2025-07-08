package com.northcoders.thebelievers.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.thebelievers.service.RetrofitInstance;
import com.northcoders.thebelievers.service.TheBelieverAPIService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TheBelieverRepository {
    private MutableLiveData<PrayerTimes> prayerTimesMutableLiveData = new MutableLiveData<>();

    private Application application;

    private MutableLiveData<List<Quran>> quranMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Reminder>> reminderMutbaleLiveData = new MutableLiveData<>();
    private MutableLiveData<Quran> surahMutableLiveData = new MutableLiveData<>();
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

    public MutableLiveData<PrayerTimes> getPrayerTimesMutableLiveData(String date){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<PrayerTimes> prayerTimesCall = service.getPrayerTimes(date);
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

    public MutableLiveData<List<Quran>> getQuranMutableLiveData(){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<List<Quran>> quranList = service.getQuran();
        quranList.enqueue(new Callback<List<Quran>>() {
            @Override
            public void onResponse(Call<List<Quran>> call, Response<List<Quran>> response) {
                if(!response.isSuccessful()){
                    try{
                        Log.d("QuranListError", "message" + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    quranMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Quran>> call, Throwable t) {
                Log.d("QuranListError", "onFailure: " + t.getMessage());
            }
        });
        return quranMutableLiveData;
    }

    public MutableLiveData<List<Reminder>> getReminderMutbaleLiveData(){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<List<Reminder>> reminders = service.getReminders();
        reminders.enqueue(new Callback<List<Reminder>>() {
            @Override
            public void onResponse(Call<List<Reminder>> call, Response<List<Reminder>> response) {
                if(!response.isSuccessful()){
                    try{
                        Log.d("ReminderListError", "message" + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    reminderMutbaleLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Reminder>> call, Throwable t) {
                Log.d("ReminderListError", "onFailure: " + t.getMessage());
            }
        });
        return reminderMutbaleLiveData;
    }

    public void addReminder(Reminder reminder){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<Reminder> reminderCall = service.postReminders(reminder);
        reminderCall.enqueue(new Callback<Reminder>() {
            @Override
            public void onResponse(Call<Reminder> call, Response<Reminder> response) {
                Toast.makeText(application.getBaseContext(),"Reminder Posted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Reminder> call, Throwable t) {
                Toast.makeText(application.getBaseContext(),"Reminder Failed, Try Again",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MutableLiveData<Quran> getSurah(Integer chapter){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<Quran> surahCall = service.getSurah(chapter);
        surahCall.enqueue(new Callback<Quran>() {
            @Override
            public void onResponse(Call<Quran> call, Response<Quran> response) {
                if(response.isSuccessful()){
                    surahMutableLiveData.setValue(response.body());
                }
                else{
                    try{
                        Log.d("SurahError", "onResponse: + " +response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<Quran> call, Throwable t) {
                Log.d("SurahError", "onFailure: " + t.getMessage());
                Toast.makeText(application.getBaseContext(),"Surah Error",Toast.LENGTH_SHORT).show();
            }
        });
        return surahMutableLiveData;
    }

    public void sendFeedback(String feedback){
        TheBelieverAPIService service = RetrofitInstance.getServiceMethod();
        Call<String> feedbackSent = service.sendFeedback(feedback);
        feedbackSent.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Toast.makeText(application.getBaseContext(),"Feedback Sent",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(application.getBaseContext(),"Feedback Failed, Try Again",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("FeedbackError", "onFailure: " + t.getMessage());
                Toast.makeText(application.getBaseContext(),"Feedback Failed, Try Again",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
