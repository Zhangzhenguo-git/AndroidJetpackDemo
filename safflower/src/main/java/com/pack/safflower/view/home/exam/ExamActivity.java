package com.pack.safflower.view.home.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.base.BaseActivity_K;
import com.pack.safflower.R;
import com.pack.safflower.databinding.ActivityExamBinding;

public class ExamActivity extends BaseActivity_K {
    private ActivityExamBinding binding;


    @Override
    public void setContentView() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_exam);
        initNavi();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initClick() {

    }
    private void initNavi(){
        NavController controller= Navigation.findNavController(this,R.id.flExamFrame);
        AppBarConfiguration configuration=new AppBarConfiguration.Builder(binding.bnvExamNaviBottom.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,controller,configuration);
        NavigationUI.setupWithNavController(binding.bnvExamNaviBottom,controller);
    }
}