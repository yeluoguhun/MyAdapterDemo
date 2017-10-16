package com.hanshaoda.mydemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午5:47
 * description:
 */
public class MyGridAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public MyGridAdapter(List<String> mList) {
        super(R.layout.item_layout_grid, mList);
    }

    public MyGridAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title, item);
    }
}
