package com.example.livedata.temp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.example.livedata.R;
import com.example.livedata.databinding.ActivityLiveDataBinding;


public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding mBinding;
    private LiveDataUser user;
    private MutableLiveData<LiveDataUser> mLiveData = new MutableLiveData<>();
    private LiveData<String> userInfo = Transformations.map(mLiveData, user -> "姓名：" + user.getName().getValue() + "年龄：" + user.getAge().getValue() + "城市：" + user.getCity());


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(LiveDataActivity.this, R.layout.activity_live_data);
        user = new LiveDataUser("北京", "小明", 20);
        mBinding.tvCityLive.setText(user.getCity());
//        livedata的user属性
        user.getAge().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                String text = integer.toString();
                mBinding.tvAgeLive.setText(text);
            }
        });
//        user.getName().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                String text=s.toString();
//                mBinding.tvNameLive.setText(text);
//            }
//        });
//        livedata的变化设置值
        user.getName().observe(this,mBinding.tvNameLive::setText);
//        packLive(user.getName(), mBinding.tvNameLive);
        mLiveData.setValue(user);
        userInfo.observe(this, mBinding.tvInfoLive::setText);
    }

    /**
     * 简单封装
     *
     * @param liveData
     * @param view
     */
    private void packLive(LiveData<String> liveData, TextView view) {
        liveData.observe(this, view::setText);
    }


    public void changeLive(View view) {
        user.setAge(22);
        user.setName("小明明");
        user.setCity("上海");
        mLiveData.setValue(user);
        Toast.makeText(this, "city未发生变化", Toast.LENGTH_SHORT).show();
    }

}
