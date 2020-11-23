package com.pack.safflower.view.live;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pack.safflower.R;
import com.pack.safflower.viewmodel.live.LiveViewModel;

public class LiveFragment extends Fragment {

    private LiveViewModel mViewModel;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.live_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LiveViewModel.class);
        // TODO: Use the ViewModel
    }

}