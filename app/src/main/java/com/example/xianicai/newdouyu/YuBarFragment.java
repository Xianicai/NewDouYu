package com.example.xianicai.newdouyu;

import android.view.View;

import com.example.xianicai.newdouyu.base.view.BaseFragment;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class YuBarFragment extends BaseFragment {
    public static YuBarFragment newInstance() {
        return new YuBarFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
