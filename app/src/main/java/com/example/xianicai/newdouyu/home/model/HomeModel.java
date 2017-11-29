package com.example.xianicai.newdouyu.home.model;

import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Zhanglibin on 2017/11/28.
 */

public interface HomeModel {
    Observable<HttpResult<List<HomeBannerBean.DataBean>>> getBannerData();
    Observable<HttpResult<List<ColumnBean.DataBean>>> getColumnData();
}
