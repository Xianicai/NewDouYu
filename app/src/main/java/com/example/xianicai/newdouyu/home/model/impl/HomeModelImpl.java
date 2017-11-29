package com.example.xianicai.newdouyu.home.model.impl;

import com.example.xianicai.newdouyu.home.model.HomeModel;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.home.model.service.HomeService;
import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;
import com.example.xianicai.newdouyu.utils.retrofit.Requester;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Zhanglibin on 2017/11/28.
 */

public class HomeModelImpl implements HomeModel {

    private final HomeService mHomeService;

    public HomeModelImpl() {
        mHomeService = Requester.get().create(HomeService.class);
    }

    @Override
    public Observable<HttpResult<List<HomeBannerBean.DataBean>>> getBannerData() {
        return mHomeService.getBanner();
    }

    @Override
    public Observable<HttpResult<List<ColumnBean.DataBean>>> getColumnData() {
        return mHomeService.getColumn();
    }
}
