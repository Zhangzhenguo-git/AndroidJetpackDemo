package com.pack.safflower.model.read;

import android.content.Context;

import java.util.List;

public interface ReadInterface {
    List<Integer> getShowTitle();
    List<String> getMenuList();
    List<CategoryBean.DataBean> getHomeDatas();
    void loadDatas(Context context);

}
