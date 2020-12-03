package com.pack.safflower.view.home.exam.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pack.safflower.R;
import com.pack.safflower.viewmodel.home.exam.FourViewModel;

public class FourFragment extends Fragment {

    private FourViewModel mViewModel;

    public static FourFragment newInstance() {
        return new FourFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.four_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FourViewModel.class);
        // TODO: Use the ViewModel
    }

}