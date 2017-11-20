package com.example.xianicai.newdouyu;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.xianicai.newdouyu.base.view.BaseFragment;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)

    ViewPager mViewPager;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
