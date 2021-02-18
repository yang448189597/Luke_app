package com.example.task;

/*
 * @Author: Luke
 * @Date: 2/18/21 7:12 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class TaskHelper {
    public static void submitTask(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        AsyncTaskInstance instance = AsyncTaskInstance.getInstance(iTaskBackground,iTaskCallback);
        // 构建线程池管理器
//        exec.excute(instance);
    }
}
