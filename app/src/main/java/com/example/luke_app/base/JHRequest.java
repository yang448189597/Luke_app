package com.example.luke_app.base;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.LfRequest;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:51 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class JHRequest extends LfRequest {
    public static IRequest sendHttp(String path, @RequestMethod int requestMethod){
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        return request;
    }

}
