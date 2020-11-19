package com.pack.safflower.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pack.safflower.R;
import com.pack.safflower.databinding.ReadLeftitemBinding;
import com.pack.safflower.model.read.CategoryBean;

import java.util.List;

public class ReadLeftAdapter extends RecyclerView.Adapter<ReadLeftAdapter.ReadLeftViewHolder> {

    private Context mContext;
    private List<String> mParents;
    private setOnClickListener mListener;
    private int selectItem = 0;


    public ReadLeftAdapter(Context context, List<String> patents) {
        this.mContext = context;
        this.mParents = patents;
    }


    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
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

        if (position == selectItem) {
            holder.clReadLeftItem.setBackgroundResource(R.drawable.left_item_bk_select);
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.green));
        } else {
            holder.clReadLeftItem.setBackgroundResource(R.drawable.left_item_bk_noselect);
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
        }
        holder.tvTitle.setText(mParents.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
//                    rightAdapter = new ReadRightAdapter(mContext, mParents.get(position).getRightData());
                    mListener.setPatentClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mParents == null ? 0 : mParents.size();
    }

    class ReadLeftViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clReadLeftItem;
        TextView tvTitle;

        public ReadLeftViewHolder(@NonNull ReadLeftitemBinding binding) {
            super(binding.getRoot());
            this.tvTitle = binding.tvReadLeftItemName;
            this.clReadLeftItem = binding.clReadLeftItem;
        }
    }

    public interface setOnClickListener {
        void setPatentClick(int position);

    }

    public void setOnParentClickListener(setOnClickListener listener) {
        this.mListener = listener;
    }

}
