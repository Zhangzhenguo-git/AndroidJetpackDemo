package com.z.mvvmtwo;

import android.app.Application;

import com.z.mvvmtwo.api.Api;
import com.z.mvvmtwo.api.RetrofitClient;
import com.z.mvvmtwo.db.UserDatabase;

/**
 * 实例化数据库和Retrofit对象
 */
public class MyApplication extends Application {

    private static UserDatabase mUserDatabase;
    private static Api mApi;
    @Override
    public void onCreate() {
        super.onCreate();
        mUserDatabase=UserDatabase.getInstance(this);
        mApi= RetrofitClient.getInstance().getApi();
    }

    public static Api getApi(){
        return mApi;
    }

    public static UserDatabase getUserDatabase(){
        return mUserDatabase;
    }
}
