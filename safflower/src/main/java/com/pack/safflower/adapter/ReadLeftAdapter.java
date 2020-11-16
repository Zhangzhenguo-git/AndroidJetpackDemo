package com.pack.safflower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pack.safflower.R;
import com.pack.safflower.databinding.ReadLeftitemBinding;
import com.pack.safflower.model.read.ReadLeftData;
import com.pack.safflower.model.read.ReadRightData;

import java.util.List;

public class ReadLeftAdapter extends RecyclerView.Adapter<ReadLeftAdapter.ReadLeftViewHolder> {

    private Context mContext;
    private List<ReadLeftData> mParents;
    private setOnClickListener mListener;
    private ReadRightAdapter rightAdapter;


    public ReadLeftAdapter(Context context, List<ReadLeftData> patents) {
        this.mContext = context;
        this.mParents = patents;
    }

    @NonNull
    @Override
    public ReadLeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ReadLeftitemBinding binding = DataBindingUtil.inflate(inflater, R.layout.read_leftitem, parent, false);
        return new ReadLeftViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadLeftViewHolder holder, int position) {
        holder.tvTitle.setText(mParents.get(position).getName());
        if (mParents.get(position).isSelected()) {
            if (rightAdapter == null) {
                rightAdapter = new ReadRightAdapter(mContext, mParents.get(position).getRightData());
                mListener.setPatentClick(rightAdapter, mParents.get(position), position);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mParents.get(position).setSelected(true);
//                    rightAdapter = new ReadRightAdapter(mContext, mParents.get(position).getRightData());
//                    mListener.setPatentClick(rightAdapter, mParents.get(position), position);
                    mListener.setNotifications(rightAdapter, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mParents == null ? 0 : mParents.size();
    }

    class ReadLeftViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public ReadLeftViewHolder(@NonNull ReadLeftitemBinding binding) {
            super(binding.getRoot());
            this.tvTitle = binding.tvReadLeftItemName;
        }
    }

    public interface setOnClickListener {
        void setPatentClick(ReadRightAdapter rightAdapter, ReadLeftData parent, int position);

        void setNotifications(ReadRightAdapter rightAdapter, int position);
    }

    public void setOnParentClickListener(setOnClickListener listener) {
        this.mListener = listener;
    }

}
