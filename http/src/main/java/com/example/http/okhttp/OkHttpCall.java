package com.example.http.okhttp;

import com.example.http.request.call.ICall;
import com.example.http.request.host.IRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/*
 * @Author: Luke
 * @Date: 2/18/21 6:03 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class OkHttpCall implements ICall {

    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
            response =  call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
