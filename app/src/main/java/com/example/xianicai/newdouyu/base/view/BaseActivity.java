package com.example.xianicai.newdouyu.base.view;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ZY:基础的Aty,实现简单的接口，方法
 * Created by zhanglibin.
 */
public abstract class BaseActivity extends RxFragmentActivity implements BaseView {
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getlayoutId());
        //初始化黄油刀控件绑定框架
        mUnbinder = ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public abstract int getlayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    @Override
    public void showProgress() {
    }

    @Override
    public void showProgress(String message) {

    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void showMsg(String msg) {

    }

}
