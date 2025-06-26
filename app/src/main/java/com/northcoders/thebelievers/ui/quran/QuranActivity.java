package com.northcoders.thebelievers.ui.quran;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityQuranBinding;
import com.northcoders.thebelievers.model.Quran;
import com.northcoders.thebelievers.ui.base.BaseActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

import java.util.List;

public class QuranActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<Quran> quranList;
    private QuranAdapter quranAdapter;
    private ActivityQuranBinding quranBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quran);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        quranBinding = DataBindingUtil.setContentView(this,R.layout.activity_quran);
        getAllQuran();
    }

    @Override
    protected void applyDarkMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.brown));
        ((TextView) findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this,R.color.cream));
    }

    @Override
    protected void applyLightMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.cream));
        ((TextView) findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this,R.color.brown));
    }

    private void getAllQuran(){
        mainActivityViewModel.getQuran().observe(this, new Observer<List<Quran>>() {
            @Override
            public void onChanged(List<Quran> qurans) {
                quranList = qurans;
                displayInRecyclerView();
            }
        });
    }
    public void displayInRecyclerView(){
        quranAdapter = new QuranAdapter(quranList,this,isDarkMode);
        recyclerView = quranBinding.recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(quranAdapter);
        quranAdapter.notifyDataSetChanged();
    }


}