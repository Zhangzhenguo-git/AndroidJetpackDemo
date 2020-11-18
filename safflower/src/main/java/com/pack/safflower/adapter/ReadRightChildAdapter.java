package com.pack.safflower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pack.safflower.R;
import com.pack.safflower.databinding.ReadRightitemChildBinding;
import com.pack.safflower.model.read.CategoryBean;
import com.pack.safflower.util.GlideUtil;

import java.util.List;

public class ReadRightChildAdapter extends RecyclerView.Adapter<ReadRightChildAdapter.ReadRightChildViewHolder> {

    private Context mContext;
    private List<CategoryBean.DataBean.DataListBean> mChilds;
    private setOnClickListener mListener;

    public ReadRightChildAdapter(Context context, List<CategoryBean.DataBean.DataListBean> childs){
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
//        GlideUtil.getInstance().setGlideRounde(mContext,mChilds.get(position).getImgURL(),holder.ivImg);
        GlideUtil.getInstance().setGlide(mContext,R.mipmap.ic_launcher,holder.ivImg);
        holder.tvTitle.setText(mChilds.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.setPatentClick(position);
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
        void setPatentClick(int position);
    }

    public void setOnParentClickListener(setOnClickListener listener){
        this.mListener=listener;
    }

}
