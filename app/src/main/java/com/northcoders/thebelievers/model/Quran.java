package com.northcoders.thebelievers.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

public class Quran extends BaseObservable implements Parcelable {
    private String surahName;
    private String surahNameArabic;

    private List<String> arabic1;

    public Quran() {
    }

    protected Quran(Parcel in) {
        surahName = in.readString();
        surahNameArabic = in.readString();
        arabic1 = in.createStringArrayList();
    }

    public static final Creator<Quran> CREATOR = new Creator<Quran>() {
        @Override
        public Quran createFromParcel(Parcel in) {
            return new Quran(in);
        }

        @Override
        public Quran[] newArray(int size) {
            return new Quran[size];
        }
    };

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

    public List<String> getArabic1() {
        return arabic1;
    }

    public void setArabic1(List<String> arabic1) {
        this.arabic1 = arabic1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(surahName);
        parcel.writeString(surahNameArabic);
        parcel.writeStringList(arabic1);
    }
}
