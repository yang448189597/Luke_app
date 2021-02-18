package com.example.task;

/*
 * @Author: Luke
 * @Date: 2/18/21 7:03 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface ITaskCallback {
    void onSuccess(Object o);
    void onException(Throwable throwable);
}
