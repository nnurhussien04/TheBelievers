package com.northcoders.thebelievers.ui.surah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.ReminderItemBinding;
import com.northcoders.thebelievers.databinding.SurahItemBinding;

import java.util.ArrayList;
import java.util.List;
import androidx.core.content.ContextCompat;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.VerseViewHolder> {

    private List<String> verses = new ArrayList<>();
    private Context context;

    private boolean darkMode;

    public SurahAdapter(Context context,boolean darkMode) {
        this.context = context;
        this.darkMode = darkMode;
    }

    public void setVerses(List<String> verses) {
        this.verses = verses != null ? verses : new ArrayList<>();
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public VerseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SurahItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.surah_item ,parent, false);
        return new VerseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VerseViewHolder holder, int position) {
        String verse = verses.get(position);
        holder.bind(verse);
        if(darkMode){
            holder.itemView.findViewById(R.id.surahLayout).setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.surah_shape_dark_mode));
            ((TextView) holder.itemView.findViewById(R.id.textView)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.cream));
        }
        else{
            holder.itemView.findViewById(R.id.surahLayout).setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.surah_shape));
            ((TextView) holder.itemView.findViewById(R.id.textView)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.brown));
        }
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    static class VerseViewHolder extends RecyclerView.ViewHolder {
        private final SurahItemBinding binding;

        VerseViewHolder(SurahItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String verse) {
            binding.setVerse(verse);
            binding.executePendingBindings();
        }
    }
}

