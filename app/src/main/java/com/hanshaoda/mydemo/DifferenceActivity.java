package com.hanshaoda.mydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午6:17
 * description:
 */
public class DifferenceActivity extends AppCompatActivity {

    private RecyclerView mRecycelrView;

    private List<DataBean> mList = new ArrayList<>();
    private DiffAdapter mDiffAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difference_layout);

        initView();
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {

        mRecycelrView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mDiffAdapter = new DiffAdapter(mList);
        mDiffAdapter.openLoadAnimation();
        mDiffAdapter.isFirstOnly(false);
        mRecycelrView.setAdapter(mDiffAdapter);
    }

    private void initData() {

        List<DataBean> data = new ArrayList<>();
        DataBean d1 = new DataBean();
        d1.setName("我是社会主义的一块砖，哪里需要，哪里搬");
        d1.setType(1);

        data.add(d1);

        DataBean d2 = new DataBean();
        d2.setImage(R.mipmap.ic_account_box_black_24dp);
        d2.setName("我是一个小小的人物。。。。。。");
        d2.setType(2);
        data.add(d2);

        mList.addAll(data);

    }

    private void initView() {
        mRecycelrView = (RecyclerView) findViewById(R.id.recycler_diff);
    }
}
