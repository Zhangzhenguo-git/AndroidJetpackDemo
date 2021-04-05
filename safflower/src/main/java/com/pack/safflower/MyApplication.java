package com.pack.safflower;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application {

    private boolean isDebugArouter=true;
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugArouter){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

    }
}
