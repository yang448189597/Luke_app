package com.example.luke_app.splash;

import android.os.Handler;

/*
 * @Author: Luke
 * @Date: 12/23/20 1:22 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class CustomCountDownTimer implements Runnable {
    // 倒计时 (观察者的设计模式)
    // 传入总时间
    // 每过一秒 总数减1
    // 总时间倒计时为0 回调完成的状态
    private int time;
    private int countDownTime;
    private final ICountDownHandler icountDownHandler;
    private final Handler handler;
    private boolean isRun;


    public CustomCountDownTimer(int time, ICountDownHandler icountDownHandler) {
        handler = new Handler();
        this.time = time;
        this.countDownTime = time;
        this.icountDownHandler = icountDownHandler;

    }

    @Override
    public void run() {
        if (isRun) {
            if (icountDownHandler != null) {
                icountDownHandler.onTicker(countDownTime);
            }
            if (countDownTime == 0) {
                cancel();
                if (icountDownHandler != null) {
                    icountDownHandler.onFinish();
                }
            } else {
                countDownTime = time--;
                handler.postDelayed(this, 1000);
            }

        }
    }


    public void start() {
        isRun = true;
        handler.post(this);
    }

    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }
}
