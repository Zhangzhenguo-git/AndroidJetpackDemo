package com.example.modularone.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.BaseFragment_J;
import com.example.modularone.R;
import com.example.modularone.databinding.OneFragmentBinding;

public class OneFragment extends BaseFragment_J {

    private OneViewModel mViewModel;
    private OneFragmentBinding binding;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(mActivity),R.layout.one_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(OneViewModel.class);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initOnClick() {

    }

}