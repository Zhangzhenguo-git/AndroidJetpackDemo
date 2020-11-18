package com.pack.safflower.model.read;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.loader.AssetsProvider;

import com.blankj.utilcode.util.GsonUtils;
import com.pack.safflower.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadModelImpl implements ReadInterface {

    private static ReadModelImpl instance;
    private List<String> menuList = new ArrayList<>();
    private List<CategoryBean.DataBean> homeList = new ArrayList<>();
    private List<Integer> showTitle;

    public static synchronized ReadModelImpl getInstance() {
        if (instance == null) {
            instance = new ReadModelImpl();
        }
        return instance;
    }

    @Override
    public List<Integer> getShowTitle() {
        return showTitle;
    }

    @Override
    public List<String> getMenuList() {
        return menuList;
    }

    @Override
    public List<CategoryBean.DataBean> getHomeDatas() {
        return homeList;
    }

    @Override
    public void loadDatas(Context context) {
        StringBuffer buffer = new StringBuffer();
//        获取assets资源
        AssetManager ap = context.getAssets();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ap.open("category.json")));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CategoryBean bean = GsonUtils.fromJson(buffer.toString(), CategoryBean.class);

        showTitle = new ArrayList<>();
        for (int i = 0; i < bean.getData().size(); i++) {
            CategoryBean.DataBean parent = bean.getData().get(i);
            menuList.add(parent.getModuleTitle());
            showTitle.add(i);
            homeList.add(parent);
        }
    }

}
