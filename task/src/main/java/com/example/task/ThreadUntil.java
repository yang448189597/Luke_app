package com.example.task;

import android.os.Handler;
import android.os.Looper;

import java.util.logging.LogRecord;

/*
 * @Author: Luke
 * @Date: 2/18/21 7:25 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ThreadUntil {
    // 主线程的 Handler
    private final static Handler MAIN = new Handler(Looper.getMainLooper());

    public static void postMainThread(Runnable runnable){
        MAIN.post(new Runnable() {
            @Override
            public void run() {
                try{
                    runnable.run();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
