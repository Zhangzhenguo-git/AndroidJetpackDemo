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
import com.pack.safflower.model.read.CategoryBean;

import java.util.List;

public class ReadRightAdapter extends RecyclerView.Adapter<ReadRightAdapter.ReadRightViewHolder> {
    private Context mContext;
    private List<CategoryBean.DataBean> homeList;
    private setOnItemClickListener mListener;
    private int selected=0;

    public ReadRightAdapter(Context context, List<CategoryBean.DataBean> homeList) {
        this.mContext = context;
        this.homeList = homeList;
    }

    public void setSelected(int selected){
        this.selected=selected;
    }
    public int getSelected(){
        return selected;
    }
    @NonNull
    @Override
    public ReadRightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ReadRightitemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.read_rightitem, parent, false);
        return new ReadRightViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadRightViewHolder holder, int position) {
        CategoryBean.DataBean.DataListBean bean = homeList.get(selected).getDataList().get(position);
        List<CategoryBean.DataBean.DataListBean.ChildListBean> childList = bean.getChildList();

        ReadRightChildAdapter adapter=new ReadRightChildAdapter(mContext,childList);
        holder.tvTitle.setText(bean.getTitle());
        holder.rlRightView.setLayoutManager(new GridLayoutManager(mContext,3));
        holder.rlRightView.setAdapter(adapter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.setOnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.get(selected).getDataList()== null ? 0 : homeList.get(selected).getDataList().size();
    }

    class ReadRightViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private RecyclerView rlRightView;

        public ReadRightViewHolder(@NonNull ReadRightitemBinding binding) {
            super(binding.getRoot());
            this.tvTitle = binding.tvReadRightItemName;
            this.rlRightView = binding.rlreadRightItem;
        }
    }

    public interface setOnItemClickListener {
        void setOnClick(int position);
    }

    public void setOnClickListener(setOnItemClickListener listener) {
        this.mListener = listener;
    }

}
