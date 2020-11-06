package com.example.lifecycle.temp;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class BaseMyLifecycle implements LifecycleInterface {
    /**
     * 此类是Lifecycle观察者的实现类，实现其观察者方法，当被观察者被触发时，此处便响应事件
     */
    private String TAG="BaseMyLifecycle:--";
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onCreate被执行");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onStart被执行");

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onResume被执行");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onPause被执行");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onStop被执行");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        System.out.println(TAG+"观察到onDestroy被执行");
    }

    @Override
    public void onLifecycleChanged(@NonNull LifecycleOwner owner, Lifecycle.Event event) {
        System.out.println(TAG+"观察到onLifecycleChanged被执行");
    }
}
