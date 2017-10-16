package com.hanshaoda.mydemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午2:49
 * description: 单类型adapter
 */
public class RecyclerViewAdapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    public RecyclerViewAdapter(@Nullable List<Person> data) {
        super(data);
    }

    public RecyclerViewAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    public RecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Person person) {

        helper.setText(R.id.tv_name, person.getName())
                .setText(R.id.tv_content, person.getTrans());
        Glide.with(mContext.getApplicationContext())
                .load(R.mipmap.ic_account_box_black_24dp)
                .into((ImageView) helper.getView(R.id.img_head));
    }
}
