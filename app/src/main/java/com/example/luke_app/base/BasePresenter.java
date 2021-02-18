package com.example.luke_app.base;

import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.base.BaseMvpPresenter;
import com.example.task.LfTask;
import com.example.task.TaskHelper;

/*
 * @Author: Luke
 * @Date: 2/18/21 7:06 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 *
 * 集成 mvp 和 网络请求的快捷方式
 */
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T>{


    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(LfTask task){
        TaskHelper.submitTask(task,task);
    }
}
