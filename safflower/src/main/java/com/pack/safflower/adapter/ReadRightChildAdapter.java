package com.pack.safflower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pack.safflower.R;
import com.pack.safflower.databinding.ReadRightitemBinding;
import com.pack.safflower.databinding.ReadRightitemChildBinding;
import com.pack.safflower.model.read.ReadLeftData;
import com.pack.safflower.model.read.ReadRightChildData;
import com.pack.safflower.model.read.ReadRightData;

import java.util.List;

public class ReadRightChildAdapter extends RecyclerView.Adapter<ReadRightChildAdapter.ReadRightChildViewHolder> {

    private Context mContext;
    private List<ReadRightChildData> mChilds;
    private setOnClickListener mListener;

    public ReadRightChildAdapter(Context context, List<ReadRightChildData> childs){
        this.mContext=context;
        this.mChilds=childs;
    }


    @NonNull
    @Override
    public ReadRightChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReadRightitemChildBinding binding= DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.read_rightitem_child,parent,false);
        return new ReadRightChildAdapter.ReadRightChildViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadRightChildViewHolder holder, int position) {
        if (mChilds.get(position).isSelected()){
            holder.tvTitle.setText(mChilds.get(position).getName());
            holder.ivImg.setImageResource(mChilds.get(position).getImgId());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.setPatentClick(mChilds.get(position),position);
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return mChilds==null?0:mChilds.size();
    }

    class ReadRightChildViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImg;
        private TextView tvTitle;
        public ReadRightChildViewHolder(@NonNull ReadRightitemChildBinding binding) {
            super(binding.getRoot());
            this.ivImg=binding.ivReadRightItemChildImg;
            this.tvTitle=binding.tvReadRightItemChildTitle;
        }
    }

    public interface setOnClickListener{
        void setPatentClick(ReadRightChildData parent,int position);
    }

    public void setOnParentClickListener(setOnClickListener listener){
        this.mListener=listener;
    }

}
