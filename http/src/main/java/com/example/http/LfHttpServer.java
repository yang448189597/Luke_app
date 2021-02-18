package com.example.http;

import com.example.http.request.host.IRequest;

import java.util.Map;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:39 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class LfHttpServer {
    protected Object execute(IRequest request, Map<String,Object> params){
        return HttpHelper.execute(request,params);
    }
}
