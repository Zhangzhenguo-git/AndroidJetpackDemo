package com.example.livedata.temp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.livedata.R;
import com.example.livedata.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding mBinding;
    private LiveDataUser user;
    private MutableLiveData<LiveDataUser> mLiveData = new MutableLiveData<>();
    private LiveData<String> userInfo = Transformations.map(mLiveData,user -> "姓名：" + user.getName().getValue() + "年龄：" + user.getAge().getValue() + "城市：" + user.getCity());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(LiveDataActivity.this, R.layout.activity_live_data);
    }


}
