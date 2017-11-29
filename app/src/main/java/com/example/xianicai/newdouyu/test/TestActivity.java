package com.example.xianicai.newdouyu.test;

import android.os.Bundle;

import com.example.xianicai.newdouyu.R;
import com.example.xianicai.newdouyu.base.view.BaseActivity;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.home.model.service.HomeService;
import com.example.xianicai.newdouyu.utils.ToastUtil;
import com.example.xianicai.newdouyu.utils.retrofit.HttpResult;
import com.example.xianicai.newdouyu.utils.retrofit.Requester;
import com.example.xianicai.newdouyu.utils.retrofit.RespondObserver;
import com.example.xianicai.newdouyu.utils.retrofit.ThreadTransformer;

import java.util.List;

import butterknife.OnClick;

public class TestActivity extends BaseActivity {
    @Override
    public int getlayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    private void getServerData() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {

//        PostInfo postInfo = JSON.parseObject(TestJson.json, PostInfo.class);
//    }
       Requester.get().create(HomeService.class)
        .getBanner()
                .compose(new ThreadTransformer<HttpResult<List<HomeBannerBean.DataBean>>>())
                .subscribe(new RespondObserver<List<HomeBannerBean.DataBean>>() {
                    @Override
                    public void onSuccess(List<HomeBannerBean.DataBean> result) {
                        super.onSuccess(result);
                        ToastUtil.showMessage(result+"");

                    }

                    @Override
                    public void onFailure() {
                        super.onFailure();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }
}
