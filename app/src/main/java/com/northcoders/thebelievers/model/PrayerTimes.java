package com.northcoders.thebelievers.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.thebelievers.BR;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PrayerTimes extends BaseObservable {
    private String date;
    private String fajr;
    private String sunrise;
    private String dhuhr;
    private String asr;
    private String magrib;
    private String isha;

    public PrayerTimes() {
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
        notifyPropertyChanged(BR.fajr);
    }

    @Bindable
    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
        notifyPropertyChanged(BR.sunrise);
    }

    @Bindable
    public String getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
        notifyPropertyChanged(BR.dhuhr);
    }

    @Bindable
    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
        notifyPropertyChanged(BR.asr);
    }

    @Bindable
    public String getMagrib() {
        return magrib;
    }

    public void setMagrib(String magrib) {
        this.magrib = magrib;
        notifyPropertyChanged(BR.magrib);
    }

    @Bindable
    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
        notifyPropertyChanged(BR.isha);
    }

    public String dateFormatted() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern, Locale.getDefault());
        SimpleDateFormat outputFormat= new SimpleDateFormat("d MMMM yyyy", Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(getDate());
            return outputFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
