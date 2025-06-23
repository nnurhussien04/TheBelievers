package com.northcoders.thebelievers.ui.reminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ReminderItemBinding;
import com.northcoders.thebelievers.model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>{
    private List<Reminder> reminderList = new ArrayList<>();
    private Context context;

    public ReminderAdapter(List<Reminder> reminderList, Context context) {
        this.reminderList = reminderList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReminderItemBinding reminderItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.reminder_item,parent,false);
        return new ReminderViewHolder(reminderItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        holder.reminderItemBinding.setReminder(reminderList.get(position));
    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }

    public static class ReminderViewHolder extends RecyclerView.ViewHolder{
        ReminderItemBinding reminderItemBinding;

        public ReminderViewHolder(@NonNull ReminderItemBinding reminderItemBinding) {
            super(reminderItemBinding.getRoot());
            this.reminderItemBinding = reminderItemBinding;
        }
    }

}
