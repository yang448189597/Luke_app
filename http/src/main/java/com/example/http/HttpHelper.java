package com.example.http;

import com.example.http.okhttp.OkHttpScheduler;
import com.example.http.request.call.ICall;
import com.example.http.request.host.IRequest;

import java.util.Map;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:43 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class HttpHelper {
    private volatile static HttpScheduler httpScheduler;

    public static HttpScheduler getHttpScheduler(){
        if(httpScheduler == null){
            synchronized (HttpHelper.class){
                if(httpScheduler == null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }


    protected static Object execute(IRequest request, Map<String,Object> params) {
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        Object object = getHttpScheduler().execute(call);
        return null;
    }
}
