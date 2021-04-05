package com.example.modularone;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.BaseFragment_J;

public class MoreOneFragment extends BaseFragment_J {

    private MoreOneViewModel mViewModel;

    public static MoreOneFragment newInstance() {
        return new MoreOneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.more_one_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MoreOneViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initOnClick() {

    }

}