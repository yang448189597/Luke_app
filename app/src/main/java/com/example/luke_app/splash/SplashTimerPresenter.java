package com.example.luke_app.splash;

import android.util.Log;

import com.example.mvp.mvp.base.BaseMvpPresenter;

/*
 * @Author: Luke
 * @Date: 12/23/20 7:49 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContact.IView> implements ISplashActivityContact.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContact.IView view) {
        super(view);
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });

        timer.start();
    }

    public void cancelTimer() {
        timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();
        Log.e("SplashTimerPresenter", "onDestroy");
    }

    @Override
    protected ISplashActivityContact.IView getEmptyView() {
        return ISplashActivityContact.emptyView;
    }

}
