package com.example.luke_app.main;

import com.example.luke_app.mvp.ILifeCircle;
import com.example.luke_app.mvp.IMvpView;
import com.example.luke_app.mvp.MvpController;

import androidx.fragment.app.Fragment;

/*
 * @Author: Luke
 * @Date: 12/25/20 10:58 AM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface IMainActivityContact {
    interface IView extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCircle {
        void initHomeFragment();
    }

    IView emptyView = new IView() {

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}