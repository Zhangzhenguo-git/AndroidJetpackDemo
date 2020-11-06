package com.example.androidjetpackdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> mNameEvent=new MutableLiveData<>();

    public MutableLiveData<String> getmNameEvent(){
        return mNameEvent;
    }

}
