package com.example.xianicai.newdouyu.home.model.service;

import com.example.xianicai.newdouyu.common.Urls;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Zhanglibin on 2017/11/28.
 */

public interface HomeService {
    /**
     * 直播轮播图片
     *
     * @return
     */
    @GET(Urls.GET_BANNER_DATA)
    Observable<HttpResult<List<HomeBannerBean.DataBean>>> getBanner();

    /**
     * 直播栏目分类
     *
     * @return
     */
    @GET(Urls.GET_COLUMN_DATA)
    Observable<HttpResult<List<ColumnBean.DataBean>>> getColumn();
}
