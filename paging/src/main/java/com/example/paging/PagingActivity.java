package com.example.paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.paging.databinding.ActivityPagingBinding;

public class PagingActivity extends AppCompatActivity {

    private ActivityPagingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_paging);
        binding.rvPaging.setLayoutManager(new LinearLayoutManager(this));
        PagingAdapter adapter=new PagingAdapter();
        binding.rvPaging.setAdapter(adapter);


        PagingPresenter presenter=new PagingPresenter(PagingActivity.this);
        presenter.allStudents.observe(this,adapter::submitList);
    }
}