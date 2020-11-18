package com.pack.safflower.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {
    private static GlideUtil instance;

    public static synchronized GlideUtil getInstance() {
        if (instance == null) {
            instance = new GlideUtil();
        }
        return instance;
    }

    /**
     * 圆角Glide
     *
     * @param context
     * @param imgUrl
     * @param targetView
     */
    public void setGlideRounde(Context context, String imgUrl, ImageView targetView) {
        Glide.with(context).load(imgUrl).apply(new RequestOptions().transform(new RoundedCorners(6))).into(targetView);
    }

    /**
     * 普通GLide
     */
    public void setGlide(Context context, int imgUrl, ImageView targetView) {
        Glide.with(context).load(imgUrl).into(targetView);
    }

}
