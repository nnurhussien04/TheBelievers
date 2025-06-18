package com.northcoders.thebelievers.ui.homepage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.northcoders.thebelievers.model.PrayerTimes;
import com.northcoders.thebelievers.model.TheBelieverRepository;

public class MainActivityViewModel extends AndroidViewModel
{

    TheBelieverRepository repository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new TheBelieverRepository(application);
    }

    public MutableLiveData<PrayerTimes> getPrayerTimes(){
        return repository.getPrayerTimesMutableLiveData();
    }




}
