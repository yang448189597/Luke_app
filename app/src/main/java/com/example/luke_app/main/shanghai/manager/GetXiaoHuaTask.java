package com.example.luke_app.main.shanghai.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.example.luke_app.main.shanghai.module.ShangHaiDetailHttpTask;

import java.io.IOException;

import okhttp3.Response;

/*
 * @Author: Luke
 * @Date: 2/18/21 6:18 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
public class GetXiaoHuaTask extends AsyncTask<Object,Object,Object> {

    // 方法运行在子线程中
    @Override
    protected Object doInBackground(Object... objects) {
        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList((String)objects[0],(String)objects[1],(String)objects[2]);
        return desc;
    }

    // 运行在主线程 用于 更新数据
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        try {
            Response response = (Response)o;
            Log.e("initGetNetData","onResponse"+response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
