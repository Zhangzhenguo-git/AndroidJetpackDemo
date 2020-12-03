package com.pack.safflower

import androidx.databinding.DataBindingUtil
import com.example.base.BaseActivity_K
import com.pack.safflower.databinding.ActivityMainBinding

class MainActivity : BaseActivity_K() {
    lateinit var binding:ActivityMainBinding

    override fun setContentView() {
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    override fun initData() {

    }

    override fun initClick() {
        binding.btSuc.setOnClickListener {
            binding.stateLayoutView
                    .Builder()
//                    .setLayout()
                    .hideAllState()
        }
        binding.btIng.setOnClickListener {
            binding.stateLayoutView
//                    获取Builder
                    .Builder()
//                    显示View
                    .showLoadIng()
//                    设置布局
//                    .setLayout(R.layout.layout)
//                    修改布局中的Img、提示语、按钮文字
                    .setIngImgOrTitleOrBt(R.mipmap.ic_launcher,"111","222")
        }
        binding.btFail.setOnClickListener {
            binding.stateLayoutView
                    .Builder()
//                    .setLayout()
                    .showLoadFail()
        }
        binding.btError.setOnClickListener {
            binding.stateLayoutView
                    .Builder()
//                    .setLayout()
                    .showLoadError()
        }
        binding.btEmpty.setOnClickListener {
            binding.stateLayoutView
                    .Builder()
//                    .setLayout()
                    .showLoadEmpty()
        }
    }
}