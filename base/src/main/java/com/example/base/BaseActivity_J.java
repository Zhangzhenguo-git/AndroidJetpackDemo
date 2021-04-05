package com.example.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity_J extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mActivity=this;
        setContentView();
        initData();
        initClick();
    }

    /**
     * 实例化ViewId
     */
    protected abstract void setContentView();

    /**
     * 实例化数据
     */
    protected abstract void initData();

    /**
     * 事件分发
     */
    protected abstract void initClick();

    /**
     * @param context 当前上下文
     * @param endClass 跳转到的activity
     * @param requestCode 请求code，可以根据实际情况填写
     * 全局跳转
     */
    private void baseStartActivity(Activity context,Class<Activity> endClass,Integer requestCode){
        Intent intent=new Intent(context,endClass);
        if (requestCode==-1){
            startActivity(intent);
            context.finish();
        }else{
            startActivityForResult(intent,requestCode);
        }

    }
}
