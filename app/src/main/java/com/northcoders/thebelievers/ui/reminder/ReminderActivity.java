package com.northcoders.thebelievers.ui.reminder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ActivityReminderBinding;
import com.northcoders.thebelievers.model.Reminder;
import com.northcoders.thebelievers.ui.base.BaseActivity;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

import java.util.List;

public class ReminderActivity extends BaseActivity {
    private MainActivityViewModel viewModel;
    private List<Reminder> reminderList;
    private ReminderAdapter reminderAdapter;
    private ActivityReminderBinding binding;
    private RecyclerView recyclerView;
    private Reminder reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reminder);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_reminder);
        reminder = new Reminder();
        ReminderClickHandler clickHandler = new ReminderClickHandler(this,viewModel,reminder,this);
        binding.setReminder(reminder);
        binding.setClickHandler(clickHandler);
        getAllReminders();
    }

    @Override
    protected void applyDarkMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.brown));
        ((TextView) findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this,R.color.cream));
        ((Button) findViewById(R.id.submitButton)).setTextColor(ContextCompat.getColor(this,R.color.brown));
        ((Button) findViewById(R.id.submitButton)).setBackgroundColor(ContextCompat.getColor(this,R.color.cream));
    }

    @Override
    protected void applyLightMode() {
        findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(this,R.color.cream));
        ((TextView) findViewById(R.id.title)).setTextColor(ContextCompat.getColor(this,R.color.brown));
        ((Button) findViewById(R.id.submitButton)).setTextColor(ContextCompat.getColor(this,R.color.cream));
        ((Button) findViewById(R.id.submitButton)).setBackgroundColor(ContextCompat.getColor(this,R.color.brown));

    }

    private void getAllReminders(){
        viewModel.getReminders().observe(this, new Observer<List<Reminder>>() {
            @Override
            public void onChanged(List<Reminder> reminders) {
                reminderList = reminders;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView(){
        reminderAdapter = new ReminderAdapter(reminderList,this);
        recyclerView = binding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(reminderAdapter);
        reminderAdapter.notifyDataSetChanged();
    }


}