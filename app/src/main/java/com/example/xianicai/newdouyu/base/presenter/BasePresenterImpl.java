package com.example.xianicai.newdouyu.base.presenter;

import com.example.xianicai.newdouyu.base.view.BaseView;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void bindView(T view) {
        this.mView = view;
    }

    @Override
    public T getView() {
        return mView;
    }

    @Override
    public void release() {
        mView = null;
    }
}