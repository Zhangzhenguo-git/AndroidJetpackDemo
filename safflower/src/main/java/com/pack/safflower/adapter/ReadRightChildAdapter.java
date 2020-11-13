package com.pack.safflower.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReadRightChildAdapter extends RecyclerView.Adapter<ReadRightChildAdapter.ReadLeftViewHolder> {

    @NonNull
    @Override
    public ReadLeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ReadLeftViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ReadLeftViewHolder extends RecyclerView.ViewHolder{

        public ReadLeftViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
