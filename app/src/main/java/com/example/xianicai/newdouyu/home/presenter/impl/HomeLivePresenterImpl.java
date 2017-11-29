package com.example.xianicai.newdouyu.home.presenter.impl;

import com.example.xianicai.newdouyu.base.presenter.BasePresenterImpl;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.home.model.impl.HomeModelImpl;
import com.example.xianicai.newdouyu.home.presenter.HomeLivePresenter;
import com.example.xianicai.newdouyu.home.view.LiveView;
import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;
import com.example.xianicai.newdouyu.utils.retrofit.RespondObserver;
import com.example.xianicai.newdouyu.utils.retrofit.ThreadTransformer;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/11/28.
 */

public class HomeLivePresenterImpl extends BasePresenterImpl<LiveView> implements HomeLivePresenter {

    private final HomeModelImpl mHomeModel;

    public HomeLivePresenterImpl() {
        mHomeModel = new HomeModelImpl();
    }

    @Override
    public void getBannerData() {
        mHomeModel.getBannerData()
                .compose(new ThreadTransformer<HttpResult<List<HomeBannerBean.DataBean>>>())
                .subscribe(new RespondObserver<List<HomeBannerBean.DataBean>>(){
                    @Override
                    public void onSuccess(List<HomeBannerBean.DataBean> result) {
                        super.onSuccess(result);
                        getView().getBannerData(result);
                    }
                });
    }

    @Override
    public void getColumnData() {
        mHomeModel.getColumnData()
                .compose(new ThreadTransformer<HttpResult<List<ColumnBean.DataBean>>>())
                .subscribe(new RespondObserver<List<ColumnBean.DataBean>>(){
                    @Override
                    public void onSuccess(List<ColumnBean.DataBean> result) {
                        super.onSuccess(result);
                        getView().getColumnData(result);
                    }
                });

    }
}
