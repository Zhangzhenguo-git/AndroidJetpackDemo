package com.pack.safflower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pack.safflower.R;
import com.pack.safflower.databinding.ReadRightitemBinding;
import com.pack.safflower.model.read.ReadLeftData;
import com.pack.safflower.model.read.ReadRightData;

import java.util.List;

public class ReadRightAdapter extends RecyclerView.Adapter<ReadRightAdapter.ReadRightViewHolder> {
    private Context mContext;
    private List<ReadRightData> mRights;
    private ReadRightChildAdapter mChildAdapter;
    public ReadRightAdapter() {
    }

    public ReadRightAdapter(Context context, List<ReadRightData> rights){
        this.mContext=context;
        this.mRights=rights;
        mChildAdapter=new ReadRightChildAdapter();
    }

    @NonNull
    @Override
    public ReadRightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReadRightitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.read_rightitem,parent,false);
        return new ReadRightViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadRightViewHolder holder, int position) {
        holder.tvTitle.setText(mRights.get(position).getName());
        if (mChildAdapter==null){
            mChildAdapter=new ReadRightChildAdapter(mContext,mRights.get(position).getChildData());
            holder.rlRightView.setLayoutManager(new GridLayoutManager(mContext,3));
            holder.rlRightView.setAdapter(mChildAdapter);
        }else {
            mChildAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mRights==null?0:mRights.size();
    }

    class ReadRightViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private RecyclerView rlRightView;
        public ReadRightViewHolder(@NonNull ReadRightitemBinding binding) {
            super(binding.getRoot());
            this.tvTitle=binding.tvReadRightItemName;
            this.rlRightView=binding.rlreadRightItem;
        }
    }

}
