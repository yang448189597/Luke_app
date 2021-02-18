package com.example.luke_app.base;

import com.example.http.request.host.IHost;

/*
 * @Author: Luke
 * @Date: 2/18/21 5:01 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public interface HostManager {
    IHost jhHost = new IHost() {
        @Override
        public String getHost() {
            return "http://v.juhe.cn";
        }

        @Override
        public String getDefaultPath() {
            return "/joke/content/list.php";
        }
    };
}
