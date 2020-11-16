package com.pack.safflower.view.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pack.safflower.R
import com.pack.safflower.adapter.ReadLeftAdapter
import com.pack.safflower.adapter.ReadRightAdapter
import com.pack.safflower.base.BaseFragment_J
import com.pack.safflower.databinding.ReadFragmentBinding
import com.pack.safflower.model.read.ReadLeftData
import com.pack.safflower.model.read.ReadRightData
import com.pack.safflower.viewmodel.read.ReadViewModel

class ReadFragment : BaseFragment_J() {
    private lateinit var mViewModel: ReadViewModel
    private lateinit var binding: ReadFragmentBinding
    private var leftAdapter: ReadLeftAdapter? = null
//    private var rightAdapter: ReadRightAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.read_fragment, container, false)
        return binding.getRoot()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ReadViewModel::class.java)
    }

    override fun initData() {
        initLeftRecycleView(mViewModel.loadDatas())
        mViewModel.leftDatas.observe(this, Observer {
            System.out.println(TAG + "leftDatas");
//            initLeftRecycleView(it)
        })
    }

    override fun initOnClick() {
        leftAdapter?.setOnParentClickListener(object :ReadLeftAdapter.setOnClickListener{
            override fun setNotifications(rightAdapter: ReadRightAdapter?, position: Int) {
                System.out.println(TAG + "setNotifications");
                rightAdapter?.notifyDataSetChanged()
            }

            override fun setPatentClick(rightAdapter: ReadRightAdapter?, parent: ReadLeftData?, position: Int) {
                System.out.println(TAG + "setPatentClick");
                binding.rlReadRightListView.layoutManager=LinearLayoutManager(mActivity)
                binding.rlReadRightListView.adapter = rightAdapter;
            }
        })
    }

    companion object {
        fun newInstance(): ReadFragment {
            return ReadFragment()
        }
    }

    /**
     * 左侧列表View及Adapter
     */
    private fun initLeftRecycleView(parents: List<ReadLeftData>) {
        if (parents!=null){
            parents.get(0).isSelected=true
        }
        if (leftAdapter == null) {
            leftAdapter = ReadLeftAdapter(mActivity, parents);
        }
        binding.rlReadLeftListView.layoutManager = LinearLayoutManager(mActivity)
        binding.rlReadLeftListView.setAdapter(leftAdapter)

    }



}