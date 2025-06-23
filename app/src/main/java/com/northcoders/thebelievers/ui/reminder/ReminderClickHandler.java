package com.northcoders.thebelievers.ui.reminder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.model.Reminder;
import com.northcoders.thebelievers.ui.homepage.MainActivityViewModel;

public class ReminderClickHandler {
    private Context context;
    private MainActivityViewModel viewModel;
    private Reminder reminder;
    private ReminderActivity reminderActivity;

    public ReminderClickHandler(Context context, MainActivityViewModel viewModel,Reminder reminder,ReminderActivity reminderActivity) {
        this.context = context;
        this.viewModel = viewModel;
        this.reminder = reminder;
        this.reminderActivity = reminderActivity;
    }

    public void refreshPage(View view){
        reminderActivity.finish();
        Intent intent = new Intent(context,ReminderActivity.class);
        context.startActivity(intent);
    }

    public void submitButton(View view){
        viewModel.setReminder(reminder);
        EditText reminderBox = reminderActivity.findViewById(R.id.messagingBox);
        reminderBox.setText("");

    }
}
