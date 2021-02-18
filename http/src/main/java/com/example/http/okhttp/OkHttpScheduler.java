package com.example.http.okhttp;

import com.example.http.HttpHelper;
import com.example.http.HttpScheduler;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.call.ICall;
import com.example.http.request.host.IRequest;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/*
 * @Author: Luke
 * @Date: 2/18/21 5:29 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class OkHttpScheduler extends HttpScheduler {

    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();
        switch (requestMethod) {

            case RequestMethod.Get:

                // 拼接get请求的 host+path
                StringBuilder urlStringBuilder = new StringBuilder(request.getHost().getHost());
                urlStringBuilder.append(request.getPath());
                HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStringBuilder.toString()).newBuilder();


                if (params != null && params.size() > 0) {
                    Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String,Object> next = iterator.next();
                        //TODO 对象如何转成String
                        urlBuilder.addQueryParameter(next.getKey(),String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;

            case RequestMethod.Post:
                // Post

                break;
        }

        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        OkHttpCall okHttpCall = new OkHttpCall(request,call);
        return okHttpCall;
    }

    private OkHttpClient getClient() {
        if (client == null){
            client = new OkHttpClient();
        }
        return client;
    }
}
