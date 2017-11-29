package com.example.xianicai.newdouyu.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.xianicai.newdouyu.R;
import com.example.xianicai.newdouyu.base.view.BaseFragment;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.home.model.bean.HomeBannerBean;
import com.example.xianicai.newdouyu.home.presenter.impl.HomeLivePresenterImpl;
import com.example.xianicai.newdouyu.home.view.LiveView;
import com.example.xianicai.newdouyu.home.view.adapter.ColumnAdapter;
import com.example.xianicai.newdouyu.widget.glide.GlideImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class LiveFragment extends BaseFragment implements LiveView {
    @BindView(R.id.banner)
    BGABanner mBanner;
    @BindView(R.id.column_recyclerview)
    RecyclerView mColumnRecyclerview;
    @BindView(R.id.live_recyclerview)
    RecyclerView mLiveRecyclerview;
    Unbinder unbinder;
    private HomeLivePresenterImpl mHomeLivePresenter;
    private ColumnAdapter mColumnAdapter;
    private List<ColumnBean.DataBean> mDataBeans;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initView(View view) {
        mDataBeans = new ArrayList<>();
        mColumnRecyclerview.setHasFixedSize(true);
        mColumnRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mColumnAdapter = new ColumnAdapter(getActivity(), mDataBeans);
        mColumnRecyclerview.setAdapter(mColumnAdapter);
        //mvp
        mHomeLivePresenter = new HomeLivePresenterImpl();
        mHomeLivePresenter.bindView(this);
        mHomeLivePresenter.getBannerData();
        mHomeLivePresenter.getColumnData();

    }

    @Override
    public void getBannerData(List<HomeBannerBean.DataBean> bannerBean) {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < bannerBean.size(); i++) {
            GlideImageView mImageView = new GlideImageView(getActivity());
            mImageView.setDefaultImage(R.mipmap.image_loading_5_3);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setImage(bannerBean.get(i).getPic_url());
            views.add(mImageView);
        }
        mBanner.setData(views);
        //banner的点击事件
        mBanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner bgaBanner, View view, Object o, int i) {

            }
        });
    }

    @Override
    public void getColumnData(List<ColumnBean.DataBean> dataBeans) {
        mDataBeans.clear();
        mDataBeans.addAll(dataBeans);
        mColumnAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
