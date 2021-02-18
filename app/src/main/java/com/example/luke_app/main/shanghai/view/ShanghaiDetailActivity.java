package com.example.luke_app.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.luke_app.R;
import com.example.luke_app.base.BaseActivity;
import com.example.luke_app.base.ViewInject;
import com.example.luke_app.main.shanghai.If.IShanghaiDetailContact;
import com.example.luke_app.main.shanghai.manager.GetXiaoHuaTask;
import com.example.luke_app.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.luke_app.main.shanghai.presenter.ShanghaiDetailPresenter;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 * @Author: Luke
 * @Date: 1/29/21 4:43 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@ViewInject(mainLayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity implements IShanghaiDetailContact.IView {

    IShanghaiDetailContact.IPresenter mPresenter =  new ShanghaiDetailPresenter(this);

    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
        initGetNetData();
        initPostNetData();
    }

    private void initPostNetData() {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("key","7754fdaa2ad11e4f25fb9172eaf4108b");
        // 建造者的设计模式
        Request request = new Request.Builder().url("http://apis.juhe.cn/lottery/types").post(builder.build()).build();
        Call call = client.newCall(request);

        // 异步 两个回调 一个失败的 一个成功
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("initGetNetData","onFailure"+e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("initGetNetData","onResponse"+response.body().string());
            }
        });

    }

    /**
     * 发送网络请求 OkHttp
     */
    private void initGetNetData() {

        mPresenter.getNetData();
//        GetXiaoHuaTask task = new GetXiaoHuaTask();
//        task.execute("desc","1","1");

//        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc","1","2");
//        if(desc instanceof Response){
//            Response response = (Response)desc;
//            Log.e("initGetNetData","onResponse"+response.body().toString());
//        }

//        OkHttpClient client = new OkHttpClient();
//        HttpUrl.Builder builder = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
//        builder.addQueryParameter("sort","desc");
//        builder.addQueryParameter("page","1");
//        builder.addQueryParameter("pagesize","2");
//        builder.addQueryParameter("time",""+System.currentTimeMillis()/1000);
//        builder.addQueryParameter("key","9e79594d7a4f33acf8ad1a206566d965");
//        // 建造者的设计模式
//        Request request = new Request.Builder().url(builder.build()).get().build();
//        Call call = client.newCall(request);
//        // 同步请求
////        Response execute = call.execute();
//
//        // 异步 两个回调 一个失败的 一个成功
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Log.e("initGetNetData","onFailure"+e);
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.e("initGetNetData","onResponse"+response.body().string());
//            }
//        });
    }

    private void initAnima() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ViewCompat.setTransitionName(ivShanghaiDetail,mActivityOptionsCompat);
            // 开启专场动画
            startPostponedEnterTransition();
        }
    }

    // Android 5.0 系统的 界面专场动画
    public static void star_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity, ShanghaiDetailActivity.class);
            Pair pair = new Pair(view, mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }

    }
}
