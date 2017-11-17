package com.example.xianicai.newdouyu.base;

import android.app.Application;

/**
 * ZY:
 * Created by zhanglibin on 2016/9/2.
 */
public class BaseApplication extends Application {
    private static BaseApplication app;

    public static BaseApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

}