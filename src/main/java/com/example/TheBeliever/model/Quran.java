package com.example.TheBeliever.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quran {
    private String surahName;
    private String surahNameArabic;
    private String surahNameTranslation;
    private List<String> arabic1;
}
