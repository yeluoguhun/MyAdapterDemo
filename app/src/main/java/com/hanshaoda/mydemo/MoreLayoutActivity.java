package com.hanshaoda.mydemo;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午5:01
 * description:
 */
public class MoreLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();
    private MyGridAdapter mGridAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_layout);

        initView();
        initData();
        initRecyclerView();
    }

    private void initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("ITEM +" + i);
        }
        mList.addAll(data);
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mGridAdapter = new MyGridAdapter(mList);
        mGridAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mGridAdapter.isFirstOnly(false);
//============拖拽删除需要实现的=================
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mGridAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
//实现拖拽删除需要adapter继承BaseItemDraggableAdapter
        mGridAdapter.enableDragItem(itemTouchHelper, R.id.tv_title, true);//开启拖拽
//        mGridAdapter.setOnItemDragListener(onItemDragListener);
        mGridAdapter.enableSwipeItem();//开启删除
//        mGridAdapter.setOnItemSwipeListener(onItemSwipeListener);

        mRecyclerView.setAdapter(mGridAdapter);


    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_more);
    }


    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {

        }
    };
    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {

        }

        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {

        }

        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {

        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

        }
    };
}
