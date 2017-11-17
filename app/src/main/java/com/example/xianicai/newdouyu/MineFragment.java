package com.example.xianicai.newdouyu;

import android.view.View;

import com.example.xianicai.newdouyu.base.view.BaseFragment;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class MineFragment extends BaseFragment {
    public static MineFragment newInstance() {
        return new MineFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
