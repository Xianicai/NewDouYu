package com.example.xianicai.newdouyu.base.presenter;

import com.example.xianicai.newdouyu.base.view.BaseView;

/**
 * Created by Zhanglibin on 2017/4/19.
 */

public interface BasePresenter <T extends BaseView> {
    void bindView(T view);

    T getView();

    void release();
}
