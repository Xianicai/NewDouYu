package com.example.xianicai.newdouyu.home;

import android.view.View;

import com.example.xianicai.newdouyu.R;
import com.example.xianicai.newdouyu.base.view.BaseFragment;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class VideoFragment extends BaseFragment {
    public static VideoFragment newInstance() {
        return new VideoFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
