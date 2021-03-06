package com.pack.safflower.view.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.base.BaseFragment_J
import com.pack.safflower.R
import com.pack.safflower.adapter.ReadLeftAdapter
import com.pack.safflower.adapter.ReadRightAdapter
import com.pack.safflower.databinding.ReadFragmentBinding
import com.pack.safflower.viewmodel.read.ReadViewModel

class ReadFragment : BaseFragment_J() {
    private lateinit var mViewModel: ReadViewModel
    private lateinit var binding: ReadFragmentBinding
    private var leftAdapter: ReadLeftAdapter? = null
    private var rightAdapter: ReadRightAdapter? = null
    private var currentItem = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.read_fragment, container, false)
        return binding.getRoot()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ReadViewModel::class.java)
        mViewModel.loadDatas(mActivity)
    }

    override fun initData() {
        leftAdapter = ReadLeftAdapter(mActivity, mViewModel.menuList)
        leftAdapter?.selectItem = 0
        binding.rlReadLeftListView.layoutManager = LinearLayoutManager(mActivity)
//        binding.rlReadLeftListView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.))
        binding.rlReadLeftListView.setAdapter(leftAdapter)

        rightAdapter = ReadRightAdapter(mActivity, mViewModel.homeDatas)
        rightAdapter?.selected = 0
        binding.rlReadRightListView.layoutManager = LinearLayoutManager(mActivity)
        binding.rlReadRightListView.adapter = rightAdapter

    }

    override fun initOnClick() {
        leftAdapter?.setOnParentClickListener(object : ReadLeftAdapter.setOnClickListener {
            override fun setPatentClick(position: Int) {
                System.out.println(TAG + "setPatentClick");
                leftAdapter?.selectItem = position
                leftAdapter?.notifyDataSetChanged()
                if (position==0){
                    binding.rlReadRightListView.setBackgroundResource(R.drawable.right_view_bk_topone)
                }else{
                    binding.rlReadRightListView.setBackgroundResource(R.drawable.right_view_bk_all)
                }
                rightAdapter?.selected = position
                rightAdapter?.notifyDataSetChanged()
            }
        })
//        home列表Item点击监听
        rightAdapter?.setOnClickListener(object : ReadRightAdapter.setOnItemClickListener {
            override fun setOnClick(position: Int) {

            }
        })
//        home列表滑动监听
        binding.rlReadRightListView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            var selectedIndex = 0

            //用来标记是否正在向最后一个滑动
            var isSlidingToLast = false
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val manager = recyclerView.layoutManager as LinearLayoutManager?
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    val lastVisibleItem = manager!!.findLastCompletelyVisibleItemPosition()
                    val totalItemCount = manager!!.itemCount

                    // 获取当前滚动到的条目位置
                    val firstIndex: Int = manager.findFirstVisibleItemPosition()
                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == totalItemCount - 1 && isSlidingToLast) {
                        //加载更多功能的代码
                        System.out.println("执行滑动到底部")
                        selectedIndex++
                    } else {
                        System.out.println("执行滑动到顶部")
                        if (selectedIndex > 0) {
                            selectedIndex--
                        }
                    }
                    System.out.println("执行:" + firstIndex + "-----" + selectedIndex)
//                    leftAdapter?.selectItem = firstIndex
//                    leftAdapter?.notifyDataSetChanged()
//                    rightAdapter?.selected = 0
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dy > 0) {
                    //大于0表示正在向右滚动
                    isSlidingToLast = true;
                    System.out.println("执行向下滑动")
                } else {
                    //小于等于0表示停止或向左滚动
                    isSlidingToLast = false;
                    System.out.println("执行向上滑动")
                }
            }
        })

    }

    companion object {
        fun newInstance(): ReadFragment {
            return ReadFragment()
        }
    }

}