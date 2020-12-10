package com.pack.safflower.view.home.exam.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.BaseFragment_J;
import com.pack.banner.IndicatorView;
import com.pack.banner.ScaleInTransformer;
import com.pack.safflower.R;
import com.pack.safflower.adapter.BannerImageAdapter;
import com.pack.safflower.databinding.OneFragmentBinding;
import com.pack.safflower.util.UIUtil;
import com.pack.safflower.util.Utils;
import com.pack.safflower.viewmodel.home.exam.OneViewModel;

public class OneFragment extends BaseFragment_J {

    private OneViewModel mViewModel;
    private OneFragmentBinding binding;
    private BannerImageAdapter adapter;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.one_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(OneViewModel.class);
    }

    @Override
    protected void initData() {
        initBannerView();
    }

    /**
     * banner
     */
    private void initBannerView() {
        binding.oneBannerView.setAutoTurningTime(3000)
                .setIndicator(new IndicatorView(mActivity)
                        .setIndicatorColor(Color.WHITE)
                        .setIndicatorStyle(IndicatorView.IndicatorStyle.INDICATOR_CIRCLE_RECT)
                        .setIndicatorSelectorColor(Color.BLACK)
                )
                .setPageMargin(UIUtil.dip2px(mActivity, 20.0), UIUtil.dip2px(mActivity, 10.0))
//                轮播两边样式
                .addPageTransformer(new ScaleInTransformer())
                .setOuterPageChangeListener(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        super.onPageScrollStateChanged(state);
                    }
                });
        adapter = new BannerImageAdapter(mActivity, Utils.getImage(6));
        binding.oneBannerView.setAdapter(adapter);
    }
    @Override
    protected void initOnClick() {

    }

}