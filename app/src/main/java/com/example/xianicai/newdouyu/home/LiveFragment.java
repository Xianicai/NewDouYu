package com.example.xianicai.newdouyu.home;

import android.view.View;

import com.example.xianicai.newdouyu.R;
import com.example.xianicai.newdouyu.base.view.BaseFragment;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class LiveFragment extends BaseFragment {
    public static LiveFragment newInstance() {
        return new LiveFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
