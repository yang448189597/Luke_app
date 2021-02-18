package com.example.http.request;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.host.IHost;

import java.util.Map;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:57 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class LfRequest implements IRequest {
    protected IHost host;
    protected String path;

    protected Map<String, Object> params;

    @RequestMethod
    protected int requestMethod;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;

    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }
}
