package com.pack.safflower.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pack.safflower.R;
import com.pack.safflower.viewmodel.home.HomeViewModel;

import java.util.List;

public class BannerImageAdapter extends RecyclerView.Adapter<BannerImageAdapter.MyViewHolder> {

    private Context mContext;
    private List<Integer> items;

    public BannerImageAdapter(Context context, List<Integer> items) {
        this.mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.banner_item_image, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(holder.image)
                .load(items.get(position))
                .apply(new RequestOptions().transform(new RoundedCorners(SizeUtils.dp2px(10F))))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
        }
    }
}
