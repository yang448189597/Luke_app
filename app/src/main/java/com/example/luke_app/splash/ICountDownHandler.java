package com.example.luke_app.splash;

/*
 * @Author: Luke
 * @Date: 12/23/20 1:33 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface ICountDownHandler {

    // 观察者回调接口 （IOS 数据回调）
    void onTicker(int time);
    void onFinish();
}
