package com.example.lifecycle.temp;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class MyLifecycle extends BaseMyLifecycle {

    private boolean mEnable;
    private LifecycleOwner mOwner;
    private MyLifecycleCallback mCallback;

    public MyLifecycle(LifecycleOwner owner,MyLifecycleCallback callback){
        this.mOwner=owner;
        this.mCallback=callback;
    }

    /**
     * 定位代码执行并反馈
     */
    public void enable(){
        mEnable=true;
//            如果onStart生命周期已执行，则进行定位并把结果通过callback回调给UI刷新
        if (mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
            mCallback.onSuccess();
        }else {
            mCallback.onError();
        }
    }
    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
//        super.onStart(owner);
        if (mEnable){
//            执行定位
        }
    }


    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
//        super.onStop(owner);
    }

    interface MyLifecycleCallback{
        void onSuccess();
        void onError();
    }


}
