package com.example.paging;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paging.db.Student;

//PagedListAdapter继承自RecycleViewAdapter
public class PagingAdapter extends PagedListAdapter<Student, PagingAdapter.MyViewHolder> {

    //DiffUtil是RecyclerView提供的，用于对比和生成差异数据
    private static final DiffUtil.ItemCallback<Student> DIFF_CALLBACK = new DiffUtil.ItemCallback<Student>() {
        @Override
        public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem == newItem;
        }
    };

    public PagingAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_paging,parent,false);
        return new MyViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setName(getItem(position));
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_name_item_rv_paging);
        }
        public void setName(Student student) {
            tvName.setText(student.getName());
        }
    }
}
