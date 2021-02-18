package com.example.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * @Author: Luke
 * @Date: 2/18/21 7:16 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class AsyncTaskInstance extends FutureTask {

    private final ITaskBackground iTaskBackground;
    private final ITaskCallback iTaskCallback;

    public AsyncTaskInstance(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        super(new Callable() {
            @Override
            public Object call() throws Exception {
                return iTaskBackground.onBackground();
            }
        });
        this.iTaskBackground = iTaskBackground;
        this.iTaskCallback = iTaskCallback;
    }

    @Override
    protected void done() {
        if(iTaskCallback != null){
            onComplete();
        }
    }

    // 获取 future Task 执行过程中的异常
    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        if(iTaskCallback  != null){
            ThreadUntil.postMainThread(new Runnable() {
                @Override
                public void run() {
                    iTaskCallback.onException(t);
                }
            });
        }
    }

    private void onComplete() {
        try {
            Object object = get();
            if(object != null){
                ThreadUntil.postMainThread(new Runnable() {
                    @Override
                    public void run() {
                        iTaskCallback.onSuccess(object);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AsyncTaskInstance getInstance(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback){
        return new AsyncTaskInstance(iTaskBackground,iTaskCallback);
    }
}
