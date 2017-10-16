package com.hanshaoda.mydemo;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;

import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午6:27
 * description:
 */
public class DiffAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {


    public DiffAdapter(List<DataBean> data) {
        super(data);
//        继承BaseMultiItemQuickAdapter 使用此方式
//        addItemType(MultipleItem.TEXT, R.layout.text_view);
//        addItemType(MultipleItem.IMG, R.layout.image_view);
        setMultiTypeDelegate(new MultiTypeDelegate<DataBean>() {
            @Override
            protected int getItemType(DataBean dataBean) {
                return dataBean.type;
            }
        });

        getMultiTypeDelegate()
                .registerItemType(DataBean.FIRST_TYPE, R.layout.first_layout)
                .registerItemType(DataBean.SECOND_TYPE, R.layout.second_layout);
    }


    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        switch (helper.getItemViewType()) {
            case DataBean.FIRST_TYPE:
                helper.setText(R.id.tv_first, item.getName());
                break;
            case DataBean.SECOND_TYPE:
                helper.setText(R.id.tv_second, item.getName());
                Glide.with(mContext.getApplicationContext())
                        .load(item.getImage())
                        .into((ImageView) helper.getView(R.id.img_second));
                break;
        }
    }
}
