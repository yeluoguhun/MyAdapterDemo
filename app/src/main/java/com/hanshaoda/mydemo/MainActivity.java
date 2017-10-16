package com.hanshaoda.mydemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener {

    private RecyclerView mRecyclerView;
    private List<Person> mList = new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private View noDataView;
    private View errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEmptyView();
        initRecycler();
        onLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 3000);
    }

    private void initEmptyView() {

        noDataView = getLayoutInflater().inflate(R.layout.empty_view_layout, (ViewGroup) mRecyclerView.getParent(), false);
        errorView = getLayoutInflater().inflate(R.layout.empty_view_layout, (ViewGroup) mRecyclerView.getParent(), false);
    }

    private void initRecycler() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewAdapter = new RecyclerViewAdapter(R.layout.item_layout_content, mList);
//        mRecyclerViewAdapter.openLoadAnimation();
        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
//        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mRecyclerViewAdapter.isFirstOnly(false);//不知第一次加载 有动画 之后滑动也有动画
        mRecyclerViewAdapter.setOnLoadMoreListener(this);

        mRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Person person = mList.get(position);
                Toast.makeText(MainActivity.this, "你点击了" + person.getName(), Toast.LENGTH_SHORT).show();
                if (person.getName().equals("小红")) {
                    startActivity(new Intent(MainActivity.this, DifferenceActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, MoreLayoutActivity.class));
                }
            }
        });
        mRecyclerViewAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "你长按了", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mRecyclerViewAdapter.addHeaderView(getView());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    private View getView() {
        return getLayoutInflater().inflate(R.layout.header_view_layout, (ViewGroup) mRecyclerView.getParent(), false);
    }

    private void onLoading() {

        mRecyclerViewAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent());
    }

    private void getData() {

        List<Person> data = new ArrayList<>();
        Person p = new Person("小张", "班中学习最好的学习委员");
        data.add(p);
        Person p1 = new Person("小李", "班长的助手，负责招呼不听话的");
        data.add(p1);
        Person p2 = new Person("小红", "小李的暗恋对象，班上的红人");
        data.add(p2);
        Person p3 = new Person("小明", "出名的捣蛋鬼，班主任的榜上'名人'");
        data.add(p3);
        Person p4 = new Person("小宋", "安分守己，成绩优异，最受老师待见");
        data.add(p4);
        Person p5 = new Person("小黄", "班上的体育健将，小红的梦中情人");
        data.add(p5);
        Person p6 = new Person("小X", "默默无闻1");
        data.add(p6);
        Person p7 = new Person("小Y", "默默无闻2");
        data.add(p7);
        Person p8 = new Person("小H", "默默无闻3");
        data.add(p8);
        Person p9 = new Person("小M", "充数分子，成绩不突出，也不落后");
        data.add(p9);
        Person p10 = new Person("小YY", "默默无闻2之忧郁");
        data.add(p10);
        Person p11 = new Person("小HH", "默默无闻3之网吧小王子");
        data.add(p11);
        Person p12 = new Person("小MM", "眼神呆萌，班上的小可怜成绩中上，时不时的缺勤");
        data.add(p12);
        List<Person> list = new ArrayList<>();
        mList.addAll(data);
        if (mList != null && mList.size() > 0) {
            mRecyclerViewAdapter.setNewData(mList);
            if (mRecyclerViewAdapter.isLoading()) {
                mRecyclerViewAdapter.loadMoreComplete();
            }
            if (!mRecyclerViewAdapter.isLoadMoreEnable()) {
                mRecyclerViewAdapter.setEnableLoadMore(true);
            }
        } else {
            if (mRecyclerViewAdapter.isLoading()) {
                Toast.makeText(this, "加载更多数据失败", Toast.LENGTH_SHORT).show();
                mRecyclerViewAdapter.loadMoreFail();
            } else {
                mRecyclerViewAdapter.setEmptyView(noDataView);
            }
        }


    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_list);
    }

    @Override
    public void onLoadMoreRequested() {
        mRecyclerViewAdapter.setLoadMoreView(new CustomLoadMoreView());
        getData();
    }

    private static class CustomLoadMoreView extends com.chad.library.adapter.base.loadmore.LoadMoreView {
        @Override
        public int getLayoutId() {
            return R.layout.loading_more_view;
        }

        @Override
        protected int getLoadingViewId() {
            return R.id.load_more_loading_view;
        }

        @Override
        protected int getLoadFailViewId() {
            return R.id.load_more_load_fail_view;
        }

        @Override
        protected int getLoadEndViewId() {
            return 0;
        }
    }
}
