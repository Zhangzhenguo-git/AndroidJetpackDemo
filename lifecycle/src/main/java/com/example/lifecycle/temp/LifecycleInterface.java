package com.example.lifecycle.temp;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public interface LifecycleInterface extends LifecycleObserver {
    /**
     * 此类是一个接口继承自LifecycleObserver观察者
     * UI线程执行时的方法是被观察者
     * 以下每个方法都会在被被观察者调用时进行触发
     */
    //Lifecycle生命周期
    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    void onCreate(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    void onStart(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    void onResume(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    void onPause(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    void onStop(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    void onDestroy(@NonNull LifecycleOwner owner);

    @OnLifecycleEvent(value = Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(@NonNull LifecycleOwner owner, Lifecycle.Event event);
}
