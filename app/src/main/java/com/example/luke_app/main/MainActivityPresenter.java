package com.example.luke_app.main;

import com.example.luke_app.R;
import com.example.luke_app.main.shanghai.BeiJingFragment;
import com.example.luke_app.main.shanghai.HangZhouFragment;
import com.example.luke_app.main.shanghai.ShangHaiFragment;
import com.example.luke_app.main.shanghai.ShenZhenFragment;
import com.example.luke_app.mvp.base.BaseMvpPresenter;

import androidx.fragment.app.Fragment;

/*
 * @Author: Luke
 * @Date: 12/28/20 11:27 AM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContact.IView> implements IMainActivityContact.IPresenter {

    //当前fragment 角标
    private int mCurrentFragmentIndex = 0;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentId;


    public MainActivityPresenter(IMainActivityContact.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContact.IView getEmptyView() {
        return IMainActivityContact.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    // 切换fragment 方法
    private void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if(mFragment != null){
            addAndShowFragment(mFragment);
        }else {
            newCurrentFragment(mCurrentFragmentIndex);
        }
        setCurChecked(mCurrentFragmentIndex);

    }

    // 记录当前角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentId = R.id.rb_main_shanghai;
                break;
            case 1:
                mCurrentId = R.id.rb_main_hangzhou;
                break;
            case 2:
                mCurrentId = R.id.rb_main_shenzhen;
                break;
            case 3:
                mCurrentId = R.id.rb_main_beijing;
                break;
        }
    }

    // 创建当前 Fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    // 显示fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    // 隐藏fragment
    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }
    }
}
