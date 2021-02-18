package com.example.http.request;

import com.example.http.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.host.IHost;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:57 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class LfRequest implements IRequest {
    protected IHost host;

    @RequestMethod
    protected int requestMethod;
}
