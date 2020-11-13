package com.pack.safflower.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pack.safflower.model.read.ReadRightData;

import java.util.List;

public class ReadLeftAdapter extends RecyclerView.Adapter<ReadLeftAdapter.ReadLeftViewHolder> {

    private Context mContext;
    private List<ReadRightData> mListTable;
    public ReadLeftAdapter(){

    }

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
