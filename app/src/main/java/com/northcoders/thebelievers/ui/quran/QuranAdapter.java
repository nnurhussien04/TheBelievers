package com.northcoders.thebelievers.ui.quran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

    public QuranAdapter(List<Quran> quranList, Context context) {
        this.quranList = quranList;
        this.context = context;
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
