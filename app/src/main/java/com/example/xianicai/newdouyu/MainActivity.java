package com.example.xianicai.newdouyu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.xianicai.newdouyu.base.view.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;
    private FragmentManager mFragmentManager;
    private String[] mTitles = new String[]{"首页", "分类", "关注", "鱼吧", "我的"};
    private HomeFragment mHomeFragment;
    private ClassifyFragment mClassifyFragment;
    private StarFragment mStarFragment;
    private YuBarFragment mYuBarFragment;
    private MineFragment mMineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDefaultFragment();
    }


    @Override
    public int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mBottomNavigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor(R.color.actionsheet_gray)
                .setBarBackgroundColor(R.color.white);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home_selected, mTitles[0])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.home_pressed)))
                .addItem(new BottomNavigationItem(R.mipmap.live_selected, mTitles[1])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.live_pressed)))
                .addItem(new BottomNavigationItem(R.mipmap.video_selected, mTitles[2])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.video)))
                .addItem(new BottomNavigationItem(R.mipmap.follow_selected, mTitles[3])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.follow_pressed)))
                .addItem(new BottomNavigationItem(R.mipmap.user_selected, mTitles[4])
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.user_pressed)))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(MainActivity.this);
    }

    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.newInstance();
        transaction.add(R.id.frameLayout, mHomeFragment);
        transaction.commit();
    }

    /**
     * 隐藏当前fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mClassifyFragment != null) {
            transaction.hide(mClassifyFragment);
        }
        if (mStarFragment != null) {
            transaction.hide(mStarFragment);
        }
        if (mYuBarFragment != null) {
            transaction.hide(mYuBarFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }

    }

    @Override
    public void onTabSelected(int position) {

        //开启事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);

        /**
         * fragment 用 add + show + hide 方式
         * 只有第一次切换会创建fragment，再次切换不创建
         *
         * fragment 用 replace 方式
         * 每次切换都会重新创建
         *
         */
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.frameLayout, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:

                if (mClassifyFragment == null) {
                    mClassifyFragment = ClassifyFragment.newInstance();
                    transaction.add(R.id.frameLayout, mClassifyFragment);
                } else {
                    transaction.show(mClassifyFragment);
                }
                break;
            case 2:
                if (mStarFragment == null) {
                    mStarFragment = StarFragment.newInstance();
                    transaction.add(R.id.frameLayout, mStarFragment);
                } else {
                    transaction.show(mStarFragment);
                }
                break;
            case 3:
                if (mYuBarFragment == null) {
                    mYuBarFragment = YuBarFragment.newInstance();
                    transaction.add(R.id.frameLayout, mYuBarFragment);
                } else {
                    transaction.show(mYuBarFragment);
                }
                break;
            case 4:
                if (mMineFragment == null) {
                    mMineFragment = MineFragment.newInstance();
                    transaction.add(R.id.frameLayout, mMineFragment);
                } else {
                    transaction.show(mMineFragment);
                }
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


}
