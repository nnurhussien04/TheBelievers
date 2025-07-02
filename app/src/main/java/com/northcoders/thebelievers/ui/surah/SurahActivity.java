package com.northcoders.thebelievers.ui.surah;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityMainBinding;
import com.northcoders.thebelievers.databinding.SurahPageBinding;
import com.northcoders.thebelievers.model.Quran;
import com.northcoders.thebelievers.ui.base.BaseActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityClickHandler;



public class SurahActivity extends BaseActivity {

    SurahPageBinding surahPageBinding;
    Quran quran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.surah_page);
        quran = getIntent().getParcelableExtra("QURAN_CHAPTER");
        SurahAdapter surahAdapter = new SurahAdapter(this,isDarkMode);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(surahAdapter);
        if(quran != null) {
            surahAdapter.setVerses(quran.getArabic1());
        }
    }


    @Override
    protected void applyDarkMode() {
        findViewById(R.id.mainLayout).setBackgroundColor(ContextCompat.getColor(this,R.color.dark_shade));
    }

    @Override
    protected void applyLightMode() {
        findViewById(R.id.mainLayout).setBackgroundColor(ContextCompat.getColor(this,R.color.cream));
    }
}
