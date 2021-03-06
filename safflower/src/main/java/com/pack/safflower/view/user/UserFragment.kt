package com.pack.safflower.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.base.BaseFragment_J
import com.pack.safflower.R
import com.pack.safflower.databinding.UserFragmentBinding
import com.pack.safflower.viewmodel.user.UserViewModel

class UserFragment : BaseFragment_J() {
    private lateinit var mViewModel: UserViewModel
    private lateinit var binding: UserFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.user_fragment, container, false)
        return binding.getRoot()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun initData() {}
    override fun initOnClick() {}

    companion object {
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }
}