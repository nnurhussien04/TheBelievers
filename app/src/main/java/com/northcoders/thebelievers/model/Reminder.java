package com.northcoders.thebelievers.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.thebelievers.BR;

public class Reminder extends BaseObservable {
    Long id;
    String reminder;


    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
        notifyPropertyChanged(BR.reminder);
    }


}
