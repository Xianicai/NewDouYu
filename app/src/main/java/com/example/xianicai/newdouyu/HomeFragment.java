package com.example.xianicai.newdouyu;

import android.view.View;

import com.example.xianicai.newdouyu.base.view.BaseFragment;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class HomeFragment extends BaseFragment {
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
