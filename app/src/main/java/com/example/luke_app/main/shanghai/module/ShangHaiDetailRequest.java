package com.example.luke_app.main.shanghai.module;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.luke_app.base.JHRequest;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:49 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get);

}
