package com.example.http.request.host;

import java.util.Map;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:41 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface IRequest {
    void setParams(Map<String, Object> params);

    Map<String, Object> getParams();

    int getRequestMethod();

    IHost getHost();

    String getPath();


}
