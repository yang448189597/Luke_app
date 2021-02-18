package com.example.luke_app.main.shanghai.module;

import com.example.http.LfHttpServer;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:34 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class ShangHaiDetailHttpTask extends LfHttpServer {

    public Object getXiaoHuaList(String sort, String page, String pagesize) {
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("page", page);
        params.put("pagesize", pagesize);
        params.put("time", "" + System.currentTimeMillis() / 1000);
        params.put("key", "9e79594d7a4f33acf8ad1a206566d965");
        return super.execute(ShangHaiDetailRequest.xiaoHuaRequest, params);
    }


}
