package com.pack.safflower.view.home.more;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.base.BaseActivity_J;
import com.example.base.BaseActivity_K;
import com.pack.safflower.R;
import com.pack.safflower.databinding.ActivityMoreBinding;

public class MoreActivity extends BaseActivity_J {

    private ActivityMoreBinding binding;

    @Override
    protected void setContentView() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_more);
        initNavigationView();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {

    }
    private void initNavigationView(){
//        创建当前控制器(fragment容器布局)
        NavController navController= Navigation.findNavController(this,R.id.moreFragment);
        AppBarConfiguration configuration=new AppBarConfiguration.Builder(binding.moreBtNav.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        NavigationUI.setupWithNavController(binding.moreBtNav,navController);

    }
}