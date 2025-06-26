package com.northcoders.thebelievers.ui.quran;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.thebelievers.R;
import com.northcoders.thebelievers.databinding.QuranItemBinding;
import com.northcoders.thebelievers.model.Quran;

import java.util.ArrayList;
import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    List<Quran> quranList = new ArrayList<>();
    private Context context;

    private Boolean darkMode;

    public QuranAdapter(List<Quran> quranList, Context context,Boolean darkMode) {
        this.quranList = quranList;
        this.context = context;
        this.darkMode = darkMode;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuranItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.quran_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quranItemBinding.setQuran(quranList.get(position));
        if(darkMode) {
            holder.itemView.findViewById(R.id.quranLayout).setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.quran_shape_dark_mode));
            ((TextView)holder.itemView.findViewById(R.id.chapterLabel)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.cream));
            ((TextView)holder.itemView.findViewById(R.id.arabicNameLabel)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.cream));
        } else{
            holder.itemView.findViewById(R.id.quranLayout).setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.quran_shape));
            ((TextView)holder.itemView.findViewById(R.id.chapterLabel)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.brown));
            ((TextView)holder.itemView.findViewById(R.id.arabicNameLabel)).setTextColor(ContextCompat.getColor(holder.itemView.getContext(),R.color.brown));
        }
        }

    @Override
    public int getItemCount() {
        return quranList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        QuranItemBinding quranItemBinding;

        public ViewHolder(QuranItemBinding quranItemBinding) {
            super(quranItemBinding.getRoot());
            this.quranItemBinding = quranItemBinding;
        }
    }
}
