package com.northcoders.thebelievers.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Quran extends BaseObservable {
    private String surahName;
    private String surahNameArabic;

    public Quran() {
    }

    @Bindable
    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    @Bindable
    public String getSurahNameArabic() {
        return surahNameArabic;
    }

    public void setSurahNameArabic(String surahNameArabic) {
        this.surahNameArabic = surahNameArabic;
    }
}
