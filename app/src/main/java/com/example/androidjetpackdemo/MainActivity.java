package com.example.androidjetpackdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidjetpackdemo.lifecycle.BaseMyLifecycle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        此处注册监听
        getLifecycle().addObserver(new BaseMyLifecycle());
    }

}