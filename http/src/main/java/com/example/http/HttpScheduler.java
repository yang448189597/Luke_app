package com.example.http;

/*
 * @Author: Luke
 * @Date: 2/18/21 5:27 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */

import com.example.http.request.call.ICall;
import com.example.http.request.host.IRequest;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public Object execute(ICall call){
        return call.execute();
    };
}
