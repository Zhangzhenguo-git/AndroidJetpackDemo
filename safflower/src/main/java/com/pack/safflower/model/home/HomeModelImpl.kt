package com.pack.safflower.model.home

import com.pack.safflower.R
import com.pack.safflower.model.home.GridData
import com.pack.safflower.model.home.HomeModel
import com.pack.safflower.model.home.TableData

/**
 * @author Zhangzhenguo
 * @create 2020/8/31
 * @Email 18311371235@163.com
 * @Describe
 */ class HomeModelImpl : HomeModel {

    var people2 = listOf(
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐"),
            TableData("精选","为你推荐")
    )

    /**
     * 获取tab选项卡Item内容
     */
    override fun getTabItems(): List<TableData> {
//        ...省略网络请求
        return people2
    }


    var gridS= listOf(
            GridData(R.mipmap.ic_launcher,"考试宝"),
            GridData(R.mipmap.ic_launcher,"音乐播放"),
            GridData(R.mipmap.ic_launcher,"视频播放"),
            GridData(R.mipmap.ic_launcher,"QQ导航栏"),
            GridData(R.mipmap.ic_launcher,"Tab切换"),
            GridData(R.mipmap.ic_launcher,"星座运势"),
            GridData(R.mipmap.ic_launcher,"天气预报"),
            GridData(R.mipmap.ic_launcher,"融云即时"),
            GridData(R.mipmap.ic_launcher,"A I客服"),
            GridData(R.mipmap.ic_launcher,"敬请期待")
    )
    /**
     * 获取网格菜单Item内容
     */
    override fun getGridItems(): List<GridData> {
//        ...省略网络请求
        return gridS
    }

}