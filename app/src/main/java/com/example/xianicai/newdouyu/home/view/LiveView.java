package com.example.xianicai.newdouyu.home.view;

import com.example.xianicai.newdouyu.base.view.BaseView;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/11/28.
 */

public interface LiveView extends BaseView {
    void getBannerData(List<HomeBannerBean.DataBean> bannerBean);
    void getColumnData(List<ColumnBean.DataBean> dataBeans);
}
