package com.pack.safflower.view.live;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.BaseFragment_J;
import com.pack.safflower.R;
import com.pack.safflower.databinding.LiveFragmentBinding;
import com.pack.safflower.viewmodel.live.LiveViewModel;

public class LiveFragment extends BaseFragment_J {

    private LiveViewModel mViewModel;
    private LiveFragmentBinding binding;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.live_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(LiveViewModel.class);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initOnClick() {

    }

}