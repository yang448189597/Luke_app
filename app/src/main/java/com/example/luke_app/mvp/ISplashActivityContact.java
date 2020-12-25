package com.example.luke_app.mvp;

/*
 * @Author: Luke
 * @Date: 12/25/20 10:58 AM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface ISplashActivityContact {
    interface IView extends IMvpView {
        void setTvTimer(String s);

    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String s) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
