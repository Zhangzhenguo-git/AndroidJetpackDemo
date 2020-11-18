package com.pack.safflower.viewmodel.read;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.pack.safflower.model.read.CategoryBean;
import com.pack.safflower.model.read.ReadModelImpl;

import java.util.List;

public class ReadViewModel extends AndroidViewModel { // TODO: Implement the ViewModel
    private MutableLiveData<List<CategoryBean.DataBean>> homeDatas=new MediatorLiveData<>();//live响应的属性
    private MutableLiveData<List<String>> menuList=new MediatorLiveData<>();//live响应的属性
    private MutableLiveData<List<Integer>> showTitle=new MediatorLiveData<>();//live响应的属性
    private ReadModelImpl impl;


    public ReadViewModel(@NonNull Application application) {
        super(application);
        impl=ReadModelImpl.getInstance();
    }


    /**
     * 实例化数据
     * @param context
     */
    public void loadDatas(Context context){
        impl.loadDatas(context);
    }
    /**
     * 实例化all数据
     */
    public List<CategoryBean.DataBean> getHomeDatas(){
        if (impl.getHomeDatas()!=null){
            homeDatas.setValue(impl.getHomeDatas());
        }
        return homeDatas.getValue();
    }

    /**
     *
     * @return
     */
    public List<String> getMenuList(){
        if (impl.getMenuList()!=null){
            menuList.setValue(impl.getMenuList());
        }
        return menuList.getValue();
    }

    /**
     *
     * @return
     */
    public List<Integer> getShowTitle() {
        if (impl.getShowTitle()!=null){
            showTitle.setValue(impl.getShowTitle());
        }
        return showTitle.getValue();
    }

}