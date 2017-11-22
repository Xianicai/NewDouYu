package com.example.xianicai.newdouyu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.xianicai.newdouyu.base.view.BaseFragment;
import com.example.xianicai.newdouyu.home.DiscoverFragment;
import com.example.xianicai.newdouyu.home.LiveFragment;
import com.example.xianicai.newdouyu.home.VideoFragment;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/11/17.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private String[] mTitles = new String[]{"视频", "直播", "发现"};

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        //给TabLayout添加标签
        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
        }
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {

                        Fragment fragment = null;
                        switch (position) {
                            case 0:
                                fragment = VideoFragment.newInstance();
                                break;
                            case 1:
                                fragment = LiveFragment.newInstance();

                                break;
                            case 2:
                                fragment = DiscoverFragment.newInstance();
                                break;
                            default:
                                break;
                        }
                        return fragment;
                    }

                    @Override
                    public int getCount() {
                        return mTitles.length;
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return mTitles[position];
                    }

                };
        mViewPager.setAdapter(fragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    VideoFragment.newInstance();
                } else if (position == 1) {
                    LiveFragment.newInstance();
                } else {
                    DiscoverFragment.newInstance();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
