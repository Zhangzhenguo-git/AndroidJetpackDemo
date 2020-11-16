package com.pack.safflower.viewmodel.read;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pack.safflower.model.read.ReadLeftData;
import com.pack.safflower.model.read.ReadModelImpl;
import com.pack.safflower.model.read.ReadRightData;

import java.util.List;

public class ReadViewModel extends AndroidViewModel { // TODO: Implement the ViewModel
    private MutableLiveData<List<ReadLeftData>> leftDatas=new MediatorLiveData<>();//live响应的属性
    private ReadModelImpl impl;


    public ReadViewModel(@NonNull Application application) {
        super(application);
        impl=ReadModelImpl.getInstance();
    }

    /**
     * 获取左边父级All数据
     */
    public LiveData<List<ReadLeftData>> getLeftDatas(){
        return leftDatas;
    }

    /**
     * 实例化all数据
     */
    public List<ReadLeftData> loadDatas(){
        if (impl.getAllDatas()!=null){
            leftDatas.setValue(impl.getAllDatas());
        }
        return leftDatas.getValue();
    }
//
//    public List<ReadRightData> getRightDatas(String title){
//        for (int i=0;i<leftDatas.getValue().size();i++){
//            if (leftDatas.getValue().get(i).getRightData().get(i).getName().equals(title)){
//
//            }
//        }
//
//    }
}